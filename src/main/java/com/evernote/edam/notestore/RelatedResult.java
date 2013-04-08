/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.evernote.edam.notestore;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import com.evernote.thrift.*;
import com.evernote.thrift.protocol.*;

/**
 * The result of calling findRelated().  The contents of the notes,
 * notebooks, and tags fields will be in decreasing order of expected
 * relevance.  It is possible that fewer results than requested will be
 * returned even if there are enough distinct entities in the account
 * in cases where the relevance is estimated to be low.
 * 
 * <dl>
 * <dt>notes</dt>
 * <dd>If notes have been requested to be included, this will be the
 *     list of notes.</dd>
 * 
 * <dt>notebooks</dt>
 * <dd>If notebooks have been requested to be included, this will be the
 *     list of notebooks.</dd>
 * 
 * <dt>tags</dt>
 * <dd>If tags have been requested to be included, this will be the list
 *     of tags.</dd>
 * </dl>
 * 
 * <dt>containingNotebooks</dt>
 * <dd>If <code>includeContainingNotebooks</code> is set to <code>true</code>
 *     in the RelatedResultSpec, return the list of notebooks to
 *     to which the returned related notes belong. The notebooks in this
 *     list will occur once per notebook GUID and are represented as
 *     NotebookDescriptor objects.</dd>
 * </dl>
 * 
 * <dt>debugInfo</dt>
 * <dd>NOTE: This should be excluded from the public API.<br /><br />
 *     If <code>includeDebugInfo</code> in RelatedResultSpec is set to
 *     <code>true</code>, this field may contain debug information
 *     if the service decides to do so.</dd>
 * </dl>
 */
public class RelatedResult implements TBase<RelatedResult>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("RelatedResult");

  private static final TField NOTES_FIELD_DESC = new TField("notes", TType.LIST, (short)1);
  private static final TField NOTEBOOKS_FIELD_DESC = new TField("notebooks", TType.LIST, (short)2);
  private static final TField TAGS_FIELD_DESC = new TField("tags", TType.LIST, (short)3);
  private static final TField CONTAINING_NOTEBOOKS_FIELD_DESC = new TField("containingNotebooks", TType.LIST, (short)4);
  private static final TField DEBUG_INFO_FIELD_DESC = new TField("debugInfo", TType.STRING, (short)5);

  private List<com.evernote.edam.type.Note> notes;
  private List<com.evernote.edam.type.Notebook> notebooks;
  private List<com.evernote.edam.type.Tag> tags;
  private List<com.evernote.edam.type.NotebookDescriptor> containingNotebooks;
  private String debugInfo;


  // isset id assignments

  public RelatedResult() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RelatedResult(RelatedResult other) {
    if (other.isSetNotes()) {
      List<com.evernote.edam.type.Note> __this__notes = new ArrayList<com.evernote.edam.type.Note>();
      for (com.evernote.edam.type.Note other_element : other.notes) {
        __this__notes.add(new com.evernote.edam.type.Note(other_element));
      }
      this.notes = __this__notes;
    }
    if (other.isSetNotebooks()) {
      List<com.evernote.edam.type.Notebook> __this__notebooks = new ArrayList<com.evernote.edam.type.Notebook>();
      for (com.evernote.edam.type.Notebook other_element : other.notebooks) {
        __this__notebooks.add(new com.evernote.edam.type.Notebook(other_element));
      }
      this.notebooks = __this__notebooks;
    }
    if (other.isSetTags()) {
      List<com.evernote.edam.type.Tag> __this__tags = new ArrayList<com.evernote.edam.type.Tag>();
      for (com.evernote.edam.type.Tag other_element : other.tags) {
        __this__tags.add(new com.evernote.edam.type.Tag(other_element));
      }
      this.tags = __this__tags;
    }
    if (other.isSetContainingNotebooks()) {
      List<com.evernote.edam.type.NotebookDescriptor> __this__containingNotebooks = new ArrayList<com.evernote.edam.type.NotebookDescriptor>();
      for (com.evernote.edam.type.NotebookDescriptor other_element : other.containingNotebooks) {
        __this__containingNotebooks.add(new com.evernote.edam.type.NotebookDescriptor(other_element));
      }
      this.containingNotebooks = __this__containingNotebooks;
    }
    if (other.isSetDebugInfo()) {
      this.debugInfo = other.debugInfo;
    }
  }

  public RelatedResult deepCopy() {
    return new RelatedResult(this);
  }

  public void clear() {
    this.notes = null;
    this.notebooks = null;
    this.tags = null;
    this.containingNotebooks = null;
    this.debugInfo = null;
  }

  public int getNotesSize() {
    return (this.notes == null) ? 0 : this.notes.size();
  }

  public java.util.Iterator<com.evernote.edam.type.Note> getNotesIterator() {
    return (this.notes == null) ? null : this.notes.iterator();
  }

  public void addToNotes(com.evernote.edam.type.Note elem) {
    if (this.notes == null) {
      this.notes = new ArrayList<com.evernote.edam.type.Note>();
    }
    this.notes.add(elem);
  }

  public List<com.evernote.edam.type.Note> getNotes() {
    return this.notes;
  }

  public void setNotes(List<com.evernote.edam.type.Note> notes) {
    this.notes = notes;
  }

  public void unsetNotes() {
    this.notes = null;
  }

  /** Returns true if field notes is set (has been asigned a value) and false otherwise */
  public boolean isSetNotes() {
    return this.notes != null;
  }

  public void setNotesIsSet(boolean value) {
    if (!value) {
      this.notes = null;
    }
  }

  public int getNotebooksSize() {
    return (this.notebooks == null) ? 0 : this.notebooks.size();
  }

  public java.util.Iterator<com.evernote.edam.type.Notebook> getNotebooksIterator() {
    return (this.notebooks == null) ? null : this.notebooks.iterator();
  }

  public void addToNotebooks(com.evernote.edam.type.Notebook elem) {
    if (this.notebooks == null) {
      this.notebooks = new ArrayList<com.evernote.edam.type.Notebook>();
    }
    this.notebooks.add(elem);
  }

  public List<com.evernote.edam.type.Notebook> getNotebooks() {
    return this.notebooks;
  }

  public void setNotebooks(List<com.evernote.edam.type.Notebook> notebooks) {
    this.notebooks = notebooks;
  }

  public void unsetNotebooks() {
    this.notebooks = null;
  }

  /** Returns true if field notebooks is set (has been asigned a value) and false otherwise */
  public boolean isSetNotebooks() {
    return this.notebooks != null;
  }

  public void setNotebooksIsSet(boolean value) {
    if (!value) {
      this.notebooks = null;
    }
  }

  public int getTagsSize() {
    return (this.tags == null) ? 0 : this.tags.size();
  }

  public java.util.Iterator<com.evernote.edam.type.Tag> getTagsIterator() {
    return (this.tags == null) ? null : this.tags.iterator();
  }

  public void addToTags(com.evernote.edam.type.Tag elem) {
    if (this.tags == null) {
      this.tags = new ArrayList<com.evernote.edam.type.Tag>();
    }
    this.tags.add(elem);
  }

  public List<com.evernote.edam.type.Tag> getTags() {
    return this.tags;
  }

  public void setTags(List<com.evernote.edam.type.Tag> tags) {
    this.tags = tags;
  }

  public void unsetTags() {
    this.tags = null;
  }

  /** Returns true if field tags is set (has been asigned a value) and false otherwise */
  public boolean isSetTags() {
    return this.tags != null;
  }

  public void setTagsIsSet(boolean value) {
    if (!value) {
      this.tags = null;
    }
  }

  public int getContainingNotebooksSize() {
    return (this.containingNotebooks == null) ? 0 : this.containingNotebooks.size();
  }

  public java.util.Iterator<com.evernote.edam.type.NotebookDescriptor> getContainingNotebooksIterator() {
    return (this.containingNotebooks == null) ? null : this.containingNotebooks.iterator();
  }

  public void addToContainingNotebooks(com.evernote.edam.type.NotebookDescriptor elem) {
    if (this.containingNotebooks == null) {
      this.containingNotebooks = new ArrayList<com.evernote.edam.type.NotebookDescriptor>();
    }
    this.containingNotebooks.add(elem);
  }

  public List<com.evernote.edam.type.NotebookDescriptor> getContainingNotebooks() {
    return this.containingNotebooks;
  }

  public void setContainingNotebooks(List<com.evernote.edam.type.NotebookDescriptor> containingNotebooks) {
    this.containingNotebooks = containingNotebooks;
  }

  public void unsetContainingNotebooks() {
    this.containingNotebooks = null;
  }

  /** Returns true if field containingNotebooks is set (has been asigned a value) and false otherwise */
  public boolean isSetContainingNotebooks() {
    return this.containingNotebooks != null;
  }

  public void setContainingNotebooksIsSet(boolean value) {
    if (!value) {
      this.containingNotebooks = null;
    }
  }

  public String getDebugInfo() {
    return this.debugInfo;
  }

  public void setDebugInfo(String debugInfo) {
    this.debugInfo = debugInfo;
  }

  public void unsetDebugInfo() {
    this.debugInfo = null;
  }

  /** Returns true if field debugInfo is set (has been asigned a value) and false otherwise */
  public boolean isSetDebugInfo() {
    return this.debugInfo != null;
  }

  public void setDebugInfoIsSet(boolean value) {
    if (!value) {
      this.debugInfo = null;
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RelatedResult)
      return this.equals((RelatedResult)that);
    return false;
  }

  public boolean equals(RelatedResult that) {
    if (that == null)
      return false;

    boolean this_present_notes = true && this.isSetNotes();
    boolean that_present_notes = true && that.isSetNotes();
    if (this_present_notes || that_present_notes) {
      if (!(this_present_notes && that_present_notes))
        return false;
      if (!this.notes.equals(that.notes))
        return false;
    }

    boolean this_present_notebooks = true && this.isSetNotebooks();
    boolean that_present_notebooks = true && that.isSetNotebooks();
    if (this_present_notebooks || that_present_notebooks) {
      if (!(this_present_notebooks && that_present_notebooks))
        return false;
      if (!this.notebooks.equals(that.notebooks))
        return false;
    }

    boolean this_present_tags = true && this.isSetTags();
    boolean that_present_tags = true && that.isSetTags();
    if (this_present_tags || that_present_tags) {
      if (!(this_present_tags && that_present_tags))
        return false;
      if (!this.tags.equals(that.tags))
        return false;
    }

    boolean this_present_containingNotebooks = true && this.isSetContainingNotebooks();
    boolean that_present_containingNotebooks = true && that.isSetContainingNotebooks();
    if (this_present_containingNotebooks || that_present_containingNotebooks) {
      if (!(this_present_containingNotebooks && that_present_containingNotebooks))
        return false;
      if (!this.containingNotebooks.equals(that.containingNotebooks))
        return false;
    }

    boolean this_present_debugInfo = true && this.isSetDebugInfo();
    boolean that_present_debugInfo = true && that.isSetDebugInfo();
    if (this_present_debugInfo || that_present_debugInfo) {
      if (!(this_present_debugInfo && that_present_debugInfo))
        return false;
      if (!this.debugInfo.equals(that.debugInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RelatedResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RelatedResult typedOther = (RelatedResult)other;

    lastComparison = Boolean.valueOf(isSetNotes()).compareTo(typedOther.isSetNotes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotes()) {      lastComparison = TBaseHelper.compareTo(this.notes, typedOther.notes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNotebooks()).compareTo(typedOther.isSetNotebooks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotebooks()) {      lastComparison = TBaseHelper.compareTo(this.notebooks, typedOther.notebooks);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTags()).compareTo(typedOther.isSetTags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTags()) {      lastComparison = TBaseHelper.compareTo(this.tags, typedOther.tags);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContainingNotebooks()).compareTo(typedOther.isSetContainingNotebooks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContainingNotebooks()) {      lastComparison = TBaseHelper.compareTo(this.containingNotebooks, typedOther.containingNotebooks);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDebugInfo()).compareTo(typedOther.isSetDebugInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDebugInfo()) {      lastComparison = TBaseHelper.compareTo(this.debugInfo, typedOther.debugInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // NOTES
          if (field.type == TType.LIST) {
            {
              TList _list94 = iprot.readListBegin();
              this.notes = new ArrayList<com.evernote.edam.type.Note>(_list94.size);
              for (int _i95 = 0; _i95 < _list94.size; ++_i95)
              {
                com.evernote.edam.type.Note _elem96;
                _elem96 = new com.evernote.edam.type.Note();
                _elem96.read(iprot);
                this.notes.add(_elem96);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // NOTEBOOKS
          if (field.type == TType.LIST) {
            {
              TList _list97 = iprot.readListBegin();
              this.notebooks = new ArrayList<com.evernote.edam.type.Notebook>(_list97.size);
              for (int _i98 = 0; _i98 < _list97.size; ++_i98)
              {
                com.evernote.edam.type.Notebook _elem99;
                _elem99 = new com.evernote.edam.type.Notebook();
                _elem99.read(iprot);
                this.notebooks.add(_elem99);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TAGS
          if (field.type == TType.LIST) {
            {
              TList _list100 = iprot.readListBegin();
              this.tags = new ArrayList<com.evernote.edam.type.Tag>(_list100.size);
              for (int _i101 = 0; _i101 < _list100.size; ++_i101)
              {
                com.evernote.edam.type.Tag _elem102;
                _elem102 = new com.evernote.edam.type.Tag();
                _elem102.read(iprot);
                this.tags.add(_elem102);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // CONTAINING_NOTEBOOKS
          if (field.type == TType.LIST) {
            {
              TList _list103 = iprot.readListBegin();
              this.containingNotebooks = new ArrayList<com.evernote.edam.type.NotebookDescriptor>(_list103.size);
              for (int _i104 = 0; _i104 < _list103.size; ++_i104)
              {
                com.evernote.edam.type.NotebookDescriptor _elem105;
                _elem105 = new com.evernote.edam.type.NotebookDescriptor();
                _elem105.read(iprot);
                this.containingNotebooks.add(_elem105);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // DEBUG_INFO
          if (field.type == TType.STRING) {
            this.debugInfo = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.notes != null) {
      if (isSetNotes()) {
        oprot.writeFieldBegin(NOTES_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.notes.size()));
          for (com.evernote.edam.type.Note _iter106 : this.notes)
          {
            _iter106.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.notebooks != null) {
      if (isSetNotebooks()) {
        oprot.writeFieldBegin(NOTEBOOKS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.notebooks.size()));
          for (com.evernote.edam.type.Notebook _iter107 : this.notebooks)
          {
            _iter107.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.tags != null) {
      if (isSetTags()) {
        oprot.writeFieldBegin(TAGS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.tags.size()));
          for (com.evernote.edam.type.Tag _iter108 : this.tags)
          {
            _iter108.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.containingNotebooks != null) {
      if (isSetContainingNotebooks()) {
        oprot.writeFieldBegin(CONTAINING_NOTEBOOKS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRUCT, this.containingNotebooks.size()));
          for (com.evernote.edam.type.NotebookDescriptor _iter109 : this.containingNotebooks)
          {
            _iter109.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.debugInfo != null) {
      if (isSetDebugInfo()) {
        oprot.writeFieldBegin(DEBUG_INFO_FIELD_DESC);
        oprot.writeString(this.debugInfo);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RelatedResult(");
    boolean first = true;

    if (isSetNotes()) {
      sb.append("notes:");
      if (this.notes == null) {
        sb.append("null");
      } else {
        sb.append(this.notes);
      }
      first = false;
    }
    if (isSetNotebooks()) {
      if (!first) sb.append(", ");
      sb.append("notebooks:");
      if (this.notebooks == null) {
        sb.append("null");
      } else {
        sb.append(this.notebooks);
      }
      first = false;
    }
    if (isSetTags()) {
      if (!first) sb.append(", ");
      sb.append("tags:");
      if (this.tags == null) {
        sb.append("null");
      } else {
        sb.append(this.tags);
      }
      first = false;
    }
    if (isSetContainingNotebooks()) {
      if (!first) sb.append(", ");
      sb.append("containingNotebooks:");
      if (this.containingNotebooks == null) {
        sb.append("null");
      } else {
        sb.append(this.containingNotebooks);
      }
      first = false;
    }
    if (isSetDebugInfo()) {
      if (!first) sb.append(", ");
      sb.append("debugInfo:");
      if (this.debugInfo == null) {
        sb.append("null");
      } else {
        sb.append(this.debugInfo);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

