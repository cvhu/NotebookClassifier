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
 * A description of the thing for which the service will find related
 * entities, via findRelated(), together with a description of what
 * type of entities and how many you are seeking in the
 * RelatedResult.
 * 
 * <dl>
 * <dt>maxNotes</dt>
 * <dd>Return notes that are related to the query, but no more than
 *     this many.  Any value greater than EDAM_RELATED_MAX_NOTES
 *     will be silently capped.  If you do not set this field, then
 *     no notes will be returned.</dd>
 * 
 * <dt>maxNotebooks</dt>
 * <dd>Return notebooks that are related to the query, but no more than
 *     this many.  Any value greater than EDAM_RELATED_MAX_NOTEBOOKS
 *     will be silently capped.  If you do not set this field, then
 *     no notebooks will be returned.</dd>
 * 
 * <dt>maxTags</dt>
 * <dd>Return tags that are related to the query, but no more than
 *     this many.  Any value greater than EDAM_RELATED_MAX_TAGS
 *     will be silently capped.  If you do not set this field, then
 *     no tags will be returned.</dd>
 * </dl>
 * 
 * <dt>writableNotebooksOnly</dt>
 * <dd>Require that all returned related notebooks are writable.
 *     The user will be able to create notes in all returned notebooks.
 *     However, individual notes returned may still belong to notebooks
 *     in which the user lacks the ability to create notes.</dd>
 * </dl>
 * 
 * <dt>includeContainingNotebooks</dt>
 * <dd>If set to <code>true</code>, return the containingNotebooks field
 *     in the RelatedResult, which will contain the list of notebooks to
 *     to which the returned related notes belong.</dd>
 * </dl>
 * 
 * <dt>includeDebugInfo</dt>
 * <dd>NOTE: This should be excluded from the public API.<br /><br />
 *     If set to <code>true</code>, indicate that debug information should
 *     be returned in the 'debugInfo' field of RelatedResult.</dd>
 * </dl>
 */
public class RelatedResultSpec implements TBase<RelatedResultSpec>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("RelatedResultSpec");

  private static final TField MAX_NOTES_FIELD_DESC = new TField("maxNotes", TType.I32, (short)1);
  private static final TField MAX_NOTEBOOKS_FIELD_DESC = new TField("maxNotebooks", TType.I32, (short)2);
  private static final TField MAX_TAGS_FIELD_DESC = new TField("maxTags", TType.I32, (short)3);
  private static final TField WRITABLE_NOTEBOOKS_ONLY_FIELD_DESC = new TField("writableNotebooksOnly", TType.BOOL, (short)4);
  private static final TField INCLUDE_CONTAINING_NOTEBOOKS_FIELD_DESC = new TField("includeContainingNotebooks", TType.BOOL, (short)5);
  private static final TField INCLUDE_DEBUG_INFO_FIELD_DESC = new TField("includeDebugInfo", TType.BOOL, (short)6);

  private int maxNotes;
  private int maxNotebooks;
  private int maxTags;
  private boolean writableNotebooksOnly;
  private boolean includeContainingNotebooks;
  private boolean includeDebugInfo;


  // isset id assignments
  private static final int __MAXNOTES_ISSET_ID = 0;
  private static final int __MAXNOTEBOOKS_ISSET_ID = 1;
  private static final int __MAXTAGS_ISSET_ID = 2;
  private static final int __WRITABLENOTEBOOKSONLY_ISSET_ID = 3;
  private static final int __INCLUDECONTAININGNOTEBOOKS_ISSET_ID = 4;
  private static final int __INCLUDEDEBUGINFO_ISSET_ID = 5;
  private boolean[] __isset_vector = new boolean[6];

  public RelatedResultSpec() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RelatedResultSpec(RelatedResultSpec other) {
    System.arraycopy(other.__isset_vector, 0, __isset_vector, 0, other.__isset_vector.length);
    this.maxNotes = other.maxNotes;
    this.maxNotebooks = other.maxNotebooks;
    this.maxTags = other.maxTags;
    this.writableNotebooksOnly = other.writableNotebooksOnly;
    this.includeContainingNotebooks = other.includeContainingNotebooks;
    this.includeDebugInfo = other.includeDebugInfo;
  }

  public RelatedResultSpec deepCopy() {
    return new RelatedResultSpec(this);
  }

  public void clear() {
    setMaxNotesIsSet(false);
    this.maxNotes = 0;
    setMaxNotebooksIsSet(false);
    this.maxNotebooks = 0;
    setMaxTagsIsSet(false);
    this.maxTags = 0;
    setWritableNotebooksOnlyIsSet(false);
    this.writableNotebooksOnly = false;
    setIncludeContainingNotebooksIsSet(false);
    this.includeContainingNotebooks = false;
    setIncludeDebugInfoIsSet(false);
    this.includeDebugInfo = false;
  }

  public int getMaxNotes() {
    return this.maxNotes;
  }

  public void setMaxNotes(int maxNotes) {
    this.maxNotes = maxNotes;
    setMaxNotesIsSet(true);
  }

  public void unsetMaxNotes() {
    __isset_vector[__MAXNOTES_ISSET_ID] = false;
  }

  /** Returns true if field maxNotes is set (has been asigned a value) and false otherwise */
  public boolean isSetMaxNotes() {
    return __isset_vector[__MAXNOTES_ISSET_ID];
  }

  public void setMaxNotesIsSet(boolean value) {
    __isset_vector[__MAXNOTES_ISSET_ID] = value;
  }

  public int getMaxNotebooks() {
    return this.maxNotebooks;
  }

  public void setMaxNotebooks(int maxNotebooks) {
    this.maxNotebooks = maxNotebooks;
    setMaxNotebooksIsSet(true);
  }

  public void unsetMaxNotebooks() {
    __isset_vector[__MAXNOTEBOOKS_ISSET_ID] = false;
  }

  /** Returns true if field maxNotebooks is set (has been asigned a value) and false otherwise */
  public boolean isSetMaxNotebooks() {
    return __isset_vector[__MAXNOTEBOOKS_ISSET_ID];
  }

  public void setMaxNotebooksIsSet(boolean value) {
    __isset_vector[__MAXNOTEBOOKS_ISSET_ID] = value;
  }

  public int getMaxTags() {
    return this.maxTags;
  }

  public void setMaxTags(int maxTags) {
    this.maxTags = maxTags;
    setMaxTagsIsSet(true);
  }

  public void unsetMaxTags() {
    __isset_vector[__MAXTAGS_ISSET_ID] = false;
  }

  /** Returns true if field maxTags is set (has been asigned a value) and false otherwise */
  public boolean isSetMaxTags() {
    return __isset_vector[__MAXTAGS_ISSET_ID];
  }

  public void setMaxTagsIsSet(boolean value) {
    __isset_vector[__MAXTAGS_ISSET_ID] = value;
  }

  public boolean isWritableNotebooksOnly() {
    return this.writableNotebooksOnly;
  }

  public void setWritableNotebooksOnly(boolean writableNotebooksOnly) {
    this.writableNotebooksOnly = writableNotebooksOnly;
    setWritableNotebooksOnlyIsSet(true);
  }

  public void unsetWritableNotebooksOnly() {
    __isset_vector[__WRITABLENOTEBOOKSONLY_ISSET_ID] = false;
  }

  /** Returns true if field writableNotebooksOnly is set (has been asigned a value) and false otherwise */
  public boolean isSetWritableNotebooksOnly() {
    return __isset_vector[__WRITABLENOTEBOOKSONLY_ISSET_ID];
  }

  public void setWritableNotebooksOnlyIsSet(boolean value) {
    __isset_vector[__WRITABLENOTEBOOKSONLY_ISSET_ID] = value;
  }

  public boolean isIncludeContainingNotebooks() {
    return this.includeContainingNotebooks;
  }

  public void setIncludeContainingNotebooks(boolean includeContainingNotebooks) {
    this.includeContainingNotebooks = includeContainingNotebooks;
    setIncludeContainingNotebooksIsSet(true);
  }

  public void unsetIncludeContainingNotebooks() {
    __isset_vector[__INCLUDECONTAININGNOTEBOOKS_ISSET_ID] = false;
  }

  /** Returns true if field includeContainingNotebooks is set (has been asigned a value) and false otherwise */
  public boolean isSetIncludeContainingNotebooks() {
    return __isset_vector[__INCLUDECONTAININGNOTEBOOKS_ISSET_ID];
  }

  public void setIncludeContainingNotebooksIsSet(boolean value) {
    __isset_vector[__INCLUDECONTAININGNOTEBOOKS_ISSET_ID] = value;
  }

  public boolean isIncludeDebugInfo() {
    return this.includeDebugInfo;
  }

  public void setIncludeDebugInfo(boolean includeDebugInfo) {
    this.includeDebugInfo = includeDebugInfo;
    setIncludeDebugInfoIsSet(true);
  }

  public void unsetIncludeDebugInfo() {
    __isset_vector[__INCLUDEDEBUGINFO_ISSET_ID] = false;
  }

  /** Returns true if field includeDebugInfo is set (has been asigned a value) and false otherwise */
  public boolean isSetIncludeDebugInfo() {
    return __isset_vector[__INCLUDEDEBUGINFO_ISSET_ID];
  }

  public void setIncludeDebugInfoIsSet(boolean value) {
    __isset_vector[__INCLUDEDEBUGINFO_ISSET_ID] = value;
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RelatedResultSpec)
      return this.equals((RelatedResultSpec)that);
    return false;
  }

  public boolean equals(RelatedResultSpec that) {
    if (that == null)
      return false;

    boolean this_present_maxNotes = true && this.isSetMaxNotes();
    boolean that_present_maxNotes = true && that.isSetMaxNotes();
    if (this_present_maxNotes || that_present_maxNotes) {
      if (!(this_present_maxNotes && that_present_maxNotes))
        return false;
      if (this.maxNotes != that.maxNotes)
        return false;
    }

    boolean this_present_maxNotebooks = true && this.isSetMaxNotebooks();
    boolean that_present_maxNotebooks = true && that.isSetMaxNotebooks();
    if (this_present_maxNotebooks || that_present_maxNotebooks) {
      if (!(this_present_maxNotebooks && that_present_maxNotebooks))
        return false;
      if (this.maxNotebooks != that.maxNotebooks)
        return false;
    }

    boolean this_present_maxTags = true && this.isSetMaxTags();
    boolean that_present_maxTags = true && that.isSetMaxTags();
    if (this_present_maxTags || that_present_maxTags) {
      if (!(this_present_maxTags && that_present_maxTags))
        return false;
      if (this.maxTags != that.maxTags)
        return false;
    }

    boolean this_present_writableNotebooksOnly = true && this.isSetWritableNotebooksOnly();
    boolean that_present_writableNotebooksOnly = true && that.isSetWritableNotebooksOnly();
    if (this_present_writableNotebooksOnly || that_present_writableNotebooksOnly) {
      if (!(this_present_writableNotebooksOnly && that_present_writableNotebooksOnly))
        return false;
      if (this.writableNotebooksOnly != that.writableNotebooksOnly)
        return false;
    }

    boolean this_present_includeContainingNotebooks = true && this.isSetIncludeContainingNotebooks();
    boolean that_present_includeContainingNotebooks = true && that.isSetIncludeContainingNotebooks();
    if (this_present_includeContainingNotebooks || that_present_includeContainingNotebooks) {
      if (!(this_present_includeContainingNotebooks && that_present_includeContainingNotebooks))
        return false;
      if (this.includeContainingNotebooks != that.includeContainingNotebooks)
        return false;
    }

    boolean this_present_includeDebugInfo = true && this.isSetIncludeDebugInfo();
    boolean that_present_includeDebugInfo = true && that.isSetIncludeDebugInfo();
    if (this_present_includeDebugInfo || that_present_includeDebugInfo) {
      if (!(this_present_includeDebugInfo && that_present_includeDebugInfo))
        return false;
      if (this.includeDebugInfo != that.includeDebugInfo)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RelatedResultSpec other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RelatedResultSpec typedOther = (RelatedResultSpec)other;

    lastComparison = Boolean.valueOf(isSetMaxNotes()).compareTo(typedOther.isSetMaxNotes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxNotes()) {      lastComparison = TBaseHelper.compareTo(this.maxNotes, typedOther.maxNotes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxNotebooks()).compareTo(typedOther.isSetMaxNotebooks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxNotebooks()) {      lastComparison = TBaseHelper.compareTo(this.maxNotebooks, typedOther.maxNotebooks);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxTags()).compareTo(typedOther.isSetMaxTags());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxTags()) {      lastComparison = TBaseHelper.compareTo(this.maxTags, typedOther.maxTags);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWritableNotebooksOnly()).compareTo(typedOther.isSetWritableNotebooksOnly());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWritableNotebooksOnly()) {      lastComparison = TBaseHelper.compareTo(this.writableNotebooksOnly, typedOther.writableNotebooksOnly);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIncludeContainingNotebooks()).compareTo(typedOther.isSetIncludeContainingNotebooks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIncludeContainingNotebooks()) {      lastComparison = TBaseHelper.compareTo(this.includeContainingNotebooks, typedOther.includeContainingNotebooks);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIncludeDebugInfo()).compareTo(typedOther.isSetIncludeDebugInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIncludeDebugInfo()) {      lastComparison = TBaseHelper.compareTo(this.includeDebugInfo, typedOther.includeDebugInfo);
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
        case 1: // MAX_NOTES
          if (field.type == TType.I32) {
            this.maxNotes = iprot.readI32();
            setMaxNotesIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // MAX_NOTEBOOKS
          if (field.type == TType.I32) {
            this.maxNotebooks = iprot.readI32();
            setMaxNotebooksIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // MAX_TAGS
          if (field.type == TType.I32) {
            this.maxTags = iprot.readI32();
            setMaxTagsIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // WRITABLE_NOTEBOOKS_ONLY
          if (field.type == TType.BOOL) {
            this.writableNotebooksOnly = iprot.readBool();
            setWritableNotebooksOnlyIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // INCLUDE_CONTAINING_NOTEBOOKS
          if (field.type == TType.BOOL) {
            this.includeContainingNotebooks = iprot.readBool();
            setIncludeContainingNotebooksIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // INCLUDE_DEBUG_INFO
          if (field.type == TType.BOOL) {
            this.includeDebugInfo = iprot.readBool();
            setIncludeDebugInfoIsSet(true);
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
    if (isSetMaxNotes()) {
      oprot.writeFieldBegin(MAX_NOTES_FIELD_DESC);
      oprot.writeI32(this.maxNotes);
      oprot.writeFieldEnd();
    }
    if (isSetMaxNotebooks()) {
      oprot.writeFieldBegin(MAX_NOTEBOOKS_FIELD_DESC);
      oprot.writeI32(this.maxNotebooks);
      oprot.writeFieldEnd();
    }
    if (isSetMaxTags()) {
      oprot.writeFieldBegin(MAX_TAGS_FIELD_DESC);
      oprot.writeI32(this.maxTags);
      oprot.writeFieldEnd();
    }
    if (isSetWritableNotebooksOnly()) {
      oprot.writeFieldBegin(WRITABLE_NOTEBOOKS_ONLY_FIELD_DESC);
      oprot.writeBool(this.writableNotebooksOnly);
      oprot.writeFieldEnd();
    }
    if (isSetIncludeContainingNotebooks()) {
      oprot.writeFieldBegin(INCLUDE_CONTAINING_NOTEBOOKS_FIELD_DESC);
      oprot.writeBool(this.includeContainingNotebooks);
      oprot.writeFieldEnd();
    }
    if (isSetIncludeDebugInfo()) {
      oprot.writeFieldBegin(INCLUDE_DEBUG_INFO_FIELD_DESC);
      oprot.writeBool(this.includeDebugInfo);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RelatedResultSpec(");
    boolean first = true;

    if (isSetMaxNotes()) {
      sb.append("maxNotes:");
      sb.append(this.maxNotes);
      first = false;
    }
    if (isSetMaxNotebooks()) {
      if (!first) sb.append(", ");
      sb.append("maxNotebooks:");
      sb.append(this.maxNotebooks);
      first = false;
    }
    if (isSetMaxTags()) {
      if (!first) sb.append(", ");
      sb.append("maxTags:");
      sb.append(this.maxTags);
      first = false;
    }
    if (isSetWritableNotebooksOnly()) {
      if (!first) sb.append(", ");
      sb.append("writableNotebooksOnly:");
      sb.append(this.writableNotebooksOnly);
      first = false;
    }
    if (isSetIncludeContainingNotebooks()) {
      if (!first) sb.append(", ");
      sb.append("includeContainingNotebooks:");
      sb.append(this.includeContainingNotebooks);
      first = false;
    }
    if (isSetIncludeDebugInfo()) {
      if (!first) sb.append(", ");
      sb.append("includeDebugInfo:");
      sb.append(this.includeDebugInfo);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

