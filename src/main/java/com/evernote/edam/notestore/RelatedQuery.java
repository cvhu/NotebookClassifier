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
 * A description of the thing for which we are searching for related
 * entities.
 * 
 * You must specify either <em>noteGuid</em> or <em>plainText</em>, but
 * not both. <em>filter</em> is optional.
 * 
 * <dl>
 * <dt>noteGuid</dt>
 * <dd>The GUID of an existing note in your account for which related
 *     entities will be found.</dd>
 * 
 * <dt>plainText</dt>
 * <dd>A string of plain text for which to find related entities.
 *     You should provide a text block with a number of characters between
 *     EDAM_RELATED_PLAINTEXT_LEN_MIN and EDAM_RELATED_PLAINTEXT_LEN_MAX.
 *     </dd>
 * 
 * <dt>filter</dt>
 * <dd>The list of criteria that will constrain the notes being considered
 *     related.
 *     Please note that some of the parameters may be ignored, such as
 *     <em>order</em> and <em>ascending</em>.
 * </dd>
 * </dl>
 */
public class RelatedQuery implements TBase<RelatedQuery>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("RelatedQuery");

  private static final TField NOTE_GUID_FIELD_DESC = new TField("noteGuid", TType.STRING, (short)1);
  private static final TField PLAIN_TEXT_FIELD_DESC = new TField("plainText", TType.STRING, (short)2);
  private static final TField FILTER_FIELD_DESC = new TField("filter", TType.STRUCT, (short)3);

  private String noteGuid;
  private String plainText;
  private NoteFilter filter;


  // isset id assignments

  public RelatedQuery() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RelatedQuery(RelatedQuery other) {
    if (other.isSetNoteGuid()) {
      this.noteGuid = other.noteGuid;
    }
    if (other.isSetPlainText()) {
      this.plainText = other.plainText;
    }
    if (other.isSetFilter()) {
      this.filter = new NoteFilter(other.filter);
    }
  }

  public RelatedQuery deepCopy() {
    return new RelatedQuery(this);
  }

  public void clear() {
    this.noteGuid = null;
    this.plainText = null;
    this.filter = null;
  }

  public String getNoteGuid() {
    return this.noteGuid;
  }

  public void setNoteGuid(String noteGuid) {
    this.noteGuid = noteGuid;
  }

  public void unsetNoteGuid() {
    this.noteGuid = null;
  }

  /** Returns true if field noteGuid is set (has been asigned a value) and false otherwise */
  public boolean isSetNoteGuid() {
    return this.noteGuid != null;
  }

  public void setNoteGuidIsSet(boolean value) {
    if (!value) {
      this.noteGuid = null;
    }
  }

  public String getPlainText() {
    return this.plainText;
  }

  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }

  public void unsetPlainText() {
    this.plainText = null;
  }

  /** Returns true if field plainText is set (has been asigned a value) and false otherwise */
  public boolean isSetPlainText() {
    return this.plainText != null;
  }

  public void setPlainTextIsSet(boolean value) {
    if (!value) {
      this.plainText = null;
    }
  }

  public NoteFilter getFilter() {
    return this.filter;
  }

  public void setFilter(NoteFilter filter) {
    this.filter = filter;
  }

  public void unsetFilter() {
    this.filter = null;
  }

  /** Returns true if field filter is set (has been asigned a value) and false otherwise */
  public boolean isSetFilter() {
    return this.filter != null;
  }

  public void setFilterIsSet(boolean value) {
    if (!value) {
      this.filter = null;
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RelatedQuery)
      return this.equals((RelatedQuery)that);
    return false;
  }

  public boolean equals(RelatedQuery that) {
    if (that == null)
      return false;

    boolean this_present_noteGuid = true && this.isSetNoteGuid();
    boolean that_present_noteGuid = true && that.isSetNoteGuid();
    if (this_present_noteGuid || that_present_noteGuid) {
      if (!(this_present_noteGuid && that_present_noteGuid))
        return false;
      if (!this.noteGuid.equals(that.noteGuid))
        return false;
    }

    boolean this_present_plainText = true && this.isSetPlainText();
    boolean that_present_plainText = true && that.isSetPlainText();
    if (this_present_plainText || that_present_plainText) {
      if (!(this_present_plainText && that_present_plainText))
        return false;
      if (!this.plainText.equals(that.plainText))
        return false;
    }

    boolean this_present_filter = true && this.isSetFilter();
    boolean that_present_filter = true && that.isSetFilter();
    if (this_present_filter || that_present_filter) {
      if (!(this_present_filter && that_present_filter))
        return false;
      if (!this.filter.equals(that.filter))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(RelatedQuery other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    RelatedQuery typedOther = (RelatedQuery)other;

    lastComparison = Boolean.valueOf(isSetNoteGuid()).compareTo(typedOther.isSetNoteGuid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNoteGuid()) {      lastComparison = TBaseHelper.compareTo(this.noteGuid, typedOther.noteGuid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlainText()).compareTo(typedOther.isSetPlainText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlainText()) {      lastComparison = TBaseHelper.compareTo(this.plainText, typedOther.plainText);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFilter()).compareTo(typedOther.isSetFilter());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFilter()) {      lastComparison = TBaseHelper.compareTo(this.filter, typedOther.filter);
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
        case 1: // NOTE_GUID
          if (field.type == TType.STRING) {
            this.noteGuid = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PLAIN_TEXT
          if (field.type == TType.STRING) {
            this.plainText = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // FILTER
          if (field.type == TType.STRUCT) {
            this.filter = new NoteFilter();
            this.filter.read(iprot);
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
    if (this.noteGuid != null) {
      if (isSetNoteGuid()) {
        oprot.writeFieldBegin(NOTE_GUID_FIELD_DESC);
        oprot.writeString(this.noteGuid);
        oprot.writeFieldEnd();
      }
    }
    if (this.plainText != null) {
      if (isSetPlainText()) {
        oprot.writeFieldBegin(PLAIN_TEXT_FIELD_DESC);
        oprot.writeString(this.plainText);
        oprot.writeFieldEnd();
      }
    }
    if (this.filter != null) {
      if (isSetFilter()) {
        oprot.writeFieldBegin(FILTER_FIELD_DESC);
        this.filter.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RelatedQuery(");
    boolean first = true;

    if (isSetNoteGuid()) {
      sb.append("noteGuid:");
      if (this.noteGuid == null) {
        sb.append("null");
      } else {
        sb.append(this.noteGuid);
      }
      first = false;
    }
    if (isSetPlainText()) {
      if (!first) sb.append(", ");
      sb.append("plainText:");
      if (this.plainText == null) {
        sb.append("null");
      } else {
        sb.append(this.plainText);
      }
      first = false;
    }
    if (isSetFilter()) {
      if (!first) sb.append(", ");
      sb.append("filter:");
      if (this.filter == null) {
        sb.append("null");
      } else {
        sb.append(this.filter);
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

