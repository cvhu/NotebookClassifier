/*
  Evernote API sample code, structured as a simple command line
  application that demonstrates several API calls.
  
  To compile (Unix):

	javac -classpath target/evernote-api-1.23.jar:target/jsoup-1.7.2.jar NotebookClassifier2.java
 
  To run:
	java -classpath .:target/evernote-api-1.23.jar:target/jsoup-1.7.2.jar NotebookClassifier2

 
  Full documentation of the Evernote API can be found at 
  http://dev.evernote.com/documentation/cloud/
 */

import org.jsoup.*;
import java.lang.Math;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;

import com.evernote.thrift.protocol.TBinaryProtocol;
import com.evernote.thrift.transport.THttpClient;
import com.evernote.thrift.transport.TTransportException;

import com.evernote.edam.type.*;
import com.evernote.edam.userstore.*;
import com.evernote.edam.error.*;
import com.evernote.edam.userstore.Constants;
import com.evernote.edam.notestore.*;

public class NotebookClassifier2 {
  
  /***************************************************************************
   * You must change the following values before running this sample code    *
   ***************************************************************************/

  // Real applications authenticate with Evernote using OAuth, but for the
  // purpose of exploring the API, you can get a developer token that allows
  // you to access your own Evernote account. To get a developer token, visit 
  // https://sandbox.evernote.com/api/DeveloperToken.action
  private static final String authToken = "S=s182:U=13de92b:E=1452fcf9ff5:C=13dd81e73f9:P=1cd:A=en-devtoken:V=2:H=81f21a95f4c859b7486651615a09b3d9"; //revoked
  
  /***************************************************************************
   * You shouldn't need to change anything below here to run sample code     *
   ***************************************************************************/  

  // Initial development is performed on our sandbox server. To use the production 
  // service, change "sandbox.evernote.com" to "www.evernote.com" and replace your
  // developer token above with a token from 
  // https://www.evernote.com/api/DeveloperToken.action
  // private static final String evernoteHost = "sandbox.evernote.com";
  private static final String evernoteHost = "www.evernote.com";
  private static final String userStoreUrl = "https://" + evernoteHost + "/edam/user";

  // In a real application, you would change the User Agent to a string that describes 
  // your application, using the form company name/app name and version. Using a unique 
  // user agent string helps us provide you with better support. 
  private static final String userAgent = "Notebook Classifier " + 
                                          Constants.EDAM_VERSION_MAJOR + "." + 
                                          Constants.EDAM_VERSION_MINOR;

  private NoteStore.Client noteStore;
  
  private HashMap<String, HashMap<String, Integer>> noteTFMap;
  private HashMap<String, String> noteNBMap;
  private HashMap<String, LinkedList<String>> wordDFMap;

  private double testRatio;
  private LinkedList<String> xTrain;
  private LinkedList<String> yTrain;
  private LinkedList<String> xTest;
  private LinkedList<String> yTest;

  /**
   * Console entry point.
   */
  public static void main(String args[]) throws Exception{
    if ("your developer token".equals(authToken)) {
      System.err.println("Please fill in your developer token");
      System.err.println("To get a developer token, go to https://sandbox.evernote.com/api/DeveloperToken.action");
      return;
    }

    NotebookClassifier2 nc = new NotebookClassifier2();
    if (nc.intitialize(0.2)) {
      try {
        nc.parseNotes();
		nc.train();
		nc.test();
      } catch (EDAMUserException e) {
        // These are the most common error types that you'll need to handle
        // EDAMUserException is thrown when an API call fails because a 
        // paramter was invalid.
        if (e.getErrorCode() == EDAMErrorCode.AUTH_EXPIRED) {
          System.err.println("Your authentication token is expired!");
        } else if (e.getErrorCode() == EDAMErrorCode.INVALID_AUTH) {
          System.err.println("Your authentication token is invalid!");
        } else if (e.getErrorCode() == EDAMErrorCode.QUOTA_REACHED) {
          System.err.println("Your authentication token is invalid!");
        } else {
          System.err.println("Error: " + e.getErrorCode().toString() +
            " parameter: " + e.getParameter());
        }
      } catch (EDAMSystemException e) {
        System.err.println("System error: " + e.getErrorCode().toString());
      } catch (TTransportException t) {
        System.err.println("Networking error: " + t.getMessage());
      }    
    }
  }
  
  /**
   * Intialize UserStore and NoteStore clients. During this step, we authenticate
   * with the Evernote web service. All of this code is boilerplate - you can copy
   * it straight into your application.
   */
  private boolean intitialize(double tr) throws Exception{
	noteTFMap = new HashMap<String, HashMap<String, Integer>>();
	noteNBMap = new HashMap<String, String>();
	wordDFMap = new HashMap<String, LinkedList<String>>();
	testRatio = tr;
	
    // Set up the UserStore client and check that we can speak to the server
    THttpClient userStoreTrans = new THttpClient(userStoreUrl);
    userStoreTrans.setCustomHeader("User-Agent", userAgent);
    TBinaryProtocol userStoreProt = new TBinaryProtocol(userStoreTrans);
    UserStore.Client userStore = new UserStore.Client(userStoreProt, userStoreProt);

    boolean versionOk = userStore.checkVersion("Notebook Classifier",
        com.evernote.edam.userstore.Constants.EDAM_VERSION_MAJOR,
        com.evernote.edam.userstore.Constants.EDAM_VERSION_MINOR);
    if (!versionOk) {
      System.err.println("Incomatible Evernote client protocol version");
      return false;
    }
    
    // Get the URL used to interact with the contents of the user's account
    // When your application authenticates using OAuth, the NoteStore URL will
    // be returned along with the auth token in the final OAuth request.
    // In that case, you don't need to make this call.
    String notestoreUrl = userStore.getNoteStoreUrl(authToken);
    
    // Set up the NoteStore client 
    THttpClient noteStoreTrans = new THttpClient(notestoreUrl);
    noteStoreTrans.setCustomHeader("User-Agent", userAgent);
    TBinaryProtocol noteStoreProt = new TBinaryProtocol(noteStoreTrans);
    noteStore = new NoteStore.Client(noteStoreProt, noteStoreProt);
    
    return true;
  }
  
  /**
   * Retrieve and display a list of the user's notes.
   */
  private void parseNotes() throws Exception{    
    xTrain = new LinkedList<String>();
    yTrain = new LinkedList<String>();
    xTest = new LinkedList<String>();
    yTest = new LinkedList<String>();
    // First, get a list of all notebooks
    List<Notebook> notebooks = noteStore.listNotebooks(authToken);    
	Random rand = new Random();
    for (Notebook notebook : notebooks) {
      System.out.println("Notebook: " + notebook.getName());
      String nbGuid = notebook.getGuid();
      // notebookIds.add(nbGuid);
      // Next, search for the first 100 notes in this notebook, ordering by creation date
      NoteFilter filter = new NoteFilter();
      filter.setNotebookGuid(notebook.getGuid());
      filter.setOrder(NoteSortOrder.CREATED.getValue());
      filter.setAscending(true);
      int offset = 0;
      NoteList noteList = noteStore.findNotes(authToken, filter, offset, 50);
	  List<Note> notes = noteList.getNotes();
	  while(notes.size() < noteList.getTotalNotes()){		
		offset += noteList.getNotesSize();
		noteList = noteStore.findNotes(authToken, filter, offset, 50);
		notes.addAll(noteList.getNotes());
	  }	  
      System.out.printf("-- %d notes\n", notes.size());
	  for(Note note : notes){
	    if(rand.nextDouble() <= testRatio){
		  xTest.add(note.getGuid());
		  yTest.add(nbGuid);
	    }else{
		  xTrain.add(note.getGuid());
		  yTrain.add(nbGuid);		
	    }
	  }
 	} 
    System.out.printf("Done parsing notes: train- %d test-%d\n", yTrain.size(), yTest.size());
  }

  private String getNoteContent(String noteId) throws Exception{
	String content = noteStore.getNoteContent(authToken, noteId);
	content = Jsoup.parse(content).text().toLowerCase().replaceAll("[^a-z]", " ");
	return content;
  }

  private void train() throws Exception{
	Integer N = xTrain.size();
	for (int i = 0; i < N; i++) {
		String noteId = xTrain.get(i);
		String nbId = yTrain.get(i);
		// List<String> tagGuids = note.getTagGuids();
		// 		if(tagGuids != null){
		// 			for(String tagGuid : tagGuids){
		// 				HashMap<String, Integer> nbTag = tagMap.get(tagGuid);
		// 				if(nbTag==null){
		// 					nbTag = new HashMap<String, Integer>();
		// 				}			
		// 				Integer tagCount = nbTag.get(nbGuid);
		// 				if(tagCount == null){
		// 					tagCount = 0;
		// 				}
		// 				tagCount++;
		// 				nbTag.put(nbGuid, tagCount);
		// 				tagMap.put(tagGuid, nbTag);
		// 			}						
		// 		}
		noteNBMap.put(noteId, nbId);
		System.out.printf(" %d", N - i);		
		String content = getNoteContent(noteId);		
		HashMap<String, Integer> wordTF = noteTFMap.get(noteId);
		if(wordTF == null){
			wordTF = new HashMap<String, Integer>();					
		}
		if(content != null){
			StringTokenizer st = new StringTokenizer(content);
			// System.out.printf(" %d:%d", note.getTagGuidsSize(), st.countTokens());
			while(st.hasMoreTokens()){
				String word = st.nextToken();				
				Integer tf = wordTF.get(word);
				if(tf == null){
					tf = 0;
				}
				tf++;
				wordTF.put(word, tf);
				noteTFMap.put(noteId, wordTF);
				
				LinkedList<String> noteIds = wordDFMap.get(word);
				if(noteIds == null){
					noteIds = new LinkedList<String>();
				}
				if(!noteIds.contains(noteId)){
					noteIds.add(noteId);
				}
				wordDFMap.put(word, noteIds);
			}
		}		
    }
	System.out.printf("\n");
    insertMaxTf();
    // System.out.println();
    // 	for(String tagGuid : tagMap.keySet()){
    // 		HashMap<String, Integer> nbTag = tagMap.get(tagGuid);
    // 		System.out.printf("-%s:[", tagGuid.substring(0,4));
    // 		for(String nbGuid : nbTag.keySet()){
    // 			System.out.printf("%s:%d ", nbGuid.substring(0,4), nbTag.get(nbGuid));
    // 		}
    // 		System.out.printf("]\n");
    // 	}
	System.out.println("--Total dictionary size: "+wordDFMap.size());
  }

  private void insertMaxTf(){
	for(String noteId : noteTFMap.keySet()){
		int maxTf = 0;
		HashMap<String, Integer> wordTF = noteTFMap.get(noteId);
		for(String word : wordTF.keySet()){
			int tf = wordTF.get(word);
			if(tf > maxTf){
				maxTf = tf;
			}
		}
		wordTF.put("<max tf>", maxTf);
		noteTFMap.put(noteId, wordTF);
	}
  }

  private String classifyNotebook(String noteId) throws Exception{
	String maxNoteId = noteId;
	double maxScore = Math.log(0);
	int i = 0;
	int N = noteTFMap.size();
	for(String neighborId : noteTFMap.keySet()){
		i++;
		System.out.printf("compared with %d/%d note...", i, N);		
		double score = getScore(noteId, neighborId);
		if(score > maxScore){
			System.out.printf("%f:%f replaced! \n", score, maxScore);
			maxScore = score;
			maxNoteId = neighborId;
		}else{
			System.out.printf("%f:%f \n", score, maxScore);
		}
	}
	return noteNBMap.get(maxNoteId);
  }

  private double getScore(String noteId, String neighborId) throws Exception{
	String content = getNoteContent(noteId);
	double score = 0.0;
	double len1 = 0.0;
	double len2 = 0.0;
	HashMap<String, Integer> wordTF = noteTFMap.get(neighborId);
	if(content != null && wordTF != null){
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(content);
		Integer maxCount = 0;
		while(st.hasMoreTokens()){
			String word = st.nextToken();
			Integer count = wordMap.get(word);
			if(count == null){
				count = 0;
			}
			count++;
			if(count > maxCount){
				maxCount = count;
			}
			wordMap.put(word, count);
		}
		System.out.printf("\n");
		for(String word : wordMap.keySet()){
			Integer tf = wordTF.get(word);
			if(tf == null){
				// System.out.printf(".");
			}else{
				// System.out.printf("-");
				double tff1 = tf.doubleValue()/wordTF.get("<max tf>");
				double tff2 = wordMap.get(word)/maxCount;
				Integer noteCount = noteTFMap.size();
				Integer df = wordDFMap.get(word).size();
				double idf = Math.log(noteCount.doubleValue()/df.doubleValue());
				double w1 = tff1*idf;
				double w2 = tff2*idf;
				score += w1*w2;
				len1 += w1*w1;
				len2 += w2*w2;
			}
		}
		
	}
	score = score/Math.sqrt(len1*len2);
	return Math.log(score);
  }

  private void test() throws Exception{
	int correct = 0;
	int wrong = 0;
  	for(int i = 0; i < xTest.size(); i++){
	  System.out.printf("..%d.. \n", i);
	  String noteId = xTest.get(i);
	  String yPredicted = classifyNotebook(noteId);
	  System.out.printf("..%d.. %s : %s\n", i, yPredicted, yTest.get(i));
	  if(yPredicted==null){
		wrong++;
	  }else{
		if(yPredicted.equals(yTest.get(i))){
		  correct++;
		}else{
	      wrong++;
		}
	  }	  
    }
    System.out.printf("Accuracy: %d/%d\n", correct, (correct+wrong));
  }
}
