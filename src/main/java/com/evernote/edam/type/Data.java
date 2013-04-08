/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.evernote.edam.type;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import com.evernote.thrift.*;
import com.evernote.thrift.protocol.*;

/**
 *  In several places, EDAM exchanges blocks of bytes of data for a component
 *  which may be relatively large.  For example:  the contents of a clipped
 *  HTML note, the bytes of an embedded image, or the recognition XML for
 *  a large image.  This structure is used in the protocol to represent
 *  any of those large blocks of data when they are transmitted or when
 *  they are only referenced their metadata.
 * 
 * <dl>
 *  <dt>bodyHash</dt>
 *    <dd>This field carries a one-way hash of the contents of the
 *    data body, in binary form.  The hash function is MD5<br/>
 *    Length:  EDAM_HASH_LEN (exactly)
 *    </dd>
 * 
 *  <dt>size</dt>
 *    <dd>The length, in bytes, of the data body.
 *    </dd>
 * 
 *  <dt>body</dt>
 *    <dd>This field is set to contain the binary contents of the data
 *    whenever the resource is being transferred.  If only metadata is
 *    being exchanged, this field will be empty.  For example, a client could
 *    notify the service about the change to an attribute for a resource
 *    without transmitting the binary resource contents.
 *    </dd>
 *  </dl>
 */
public class Data implements TBase<Data>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Data");

  private static final TField BODY_HASH_FIELD_DESC = new TField("bodyHash", TType.STRING, (short)1);
  private static final TField SIZE_FIELD_DESC = new TField("size", TType.I32, (short)2);
  private static final TField BODY_FIELD_DESC = new TField("body", TType.STRING, (short)3);

  private byte[] bodyHash;
  private int size;
  private byte[] body;


  // isset id assignments
  private static final int __SIZE_ISSET_ID = 0;
  private boolean[] __isset_vector = new boolean[1];

  public Data() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Data(Data other) {
    System.arraycopy(other.__isset_vector, 0, __isset_vector, 0, other.__isset_vector.length);
    if (other.isSetBodyHash()) {
      this.bodyHash = new byte[other.bodyHash.length];
      System.arraycopy(other.bodyHash, 0, bodyHash, 0, other.bodyHash.length);
    }
    this.size = other.size;
    if (other.isSetBody()) {
      this.body = new byte[other.body.length];
      System.arraycopy(other.body, 0, body, 0, other.body.length);
    }
  }

  public Data deepCopy() {
    return new Data(this);
  }

  public void clear() {
    this.bodyHash = null;
    setSizeIsSet(false);
    this.size = 0;
    this.body = null;
  }

  public byte[] getBodyHash() {
    return this.bodyHash;
  }

  public void setBodyHash(byte[] bodyHash) {
    this.bodyHash = bodyHash;
  }

  public void unsetBodyHash() {
    this.bodyHash = null;
  }

  /** Returns true if field bodyHash is set (has been asigned a value) and false otherwise */
  public boolean isSetBodyHash() {
    return this.bodyHash != null;
  }

  public void setBodyHashIsSet(boolean value) {
    if (!value) {
      this.bodyHash = null;
    }
  }

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
    setSizeIsSet(true);
  }

  public void unsetSize() {
    __isset_vector[__SIZE_ISSET_ID] = false;
  }

  /** Returns true if field size is set (has been asigned a value) and false otherwise */
  public boolean isSetSize() {
    return __isset_vector[__SIZE_ISSET_ID];
  }

  public void setSizeIsSet(boolean value) {
    __isset_vector[__SIZE_ISSET_ID] = value;
  }

  public byte[] getBody() {
    return this.body;
  }

  public void setBody(byte[] body) {
    this.body = body;
  }

  public void unsetBody() {
    this.body = null;
  }

  /** Returns true if field body is set (has been asigned a value) and false otherwise */
  public boolean isSetBody() {
    return this.body != null;
  }

  public void setBodyIsSet(boolean value) {
    if (!value) {
      this.body = null;
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Data)
      return this.equals((Data)that);
    return false;
  }

  public boolean equals(Data that) {
    if (that == null)
      return false;

    boolean this_present_bodyHash = true && this.isSetBodyHash();
    boolean that_present_bodyHash = true && that.isSetBodyHash();
    if (this_present_bodyHash || that_present_bodyHash) {
      if (!(this_present_bodyHash && that_present_bodyHash))
        return false;
      if (TBaseHelper.compareTo(this.bodyHash, that.bodyHash) != 0)
        return false;
    }

    boolean this_present_size = true && this.isSetSize();
    boolean that_present_size = true && that.isSetSize();
    if (this_present_size || that_present_size) {
      if (!(this_present_size && that_present_size))
        return false;
      if (this.size != that.size)
        return false;
    }

    boolean this_present_body = true && this.isSetBody();
    boolean that_present_body = true && that.isSetBody();
    if (this_present_body || that_present_body) {
      if (!(this_present_body && that_present_body))
        return false;
      if (TBaseHelper.compareTo(this.body, that.body) != 0)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Data other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Data typedOther = (Data)other;

    lastComparison = Boolean.valueOf(isSetBodyHash()).compareTo(typedOther.isSetBodyHash());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBodyHash()) {      lastComparison = TBaseHelper.compareTo(this.bodyHash, typedOther.bodyHash);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSize()).compareTo(typedOther.isSetSize());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSize()) {      lastComparison = TBaseHelper.compareTo(this.size, typedOther.size);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBody()).compareTo(typedOther.isSetBody());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBody()) {      lastComparison = TBaseHelper.compareTo(this.body, typedOther.body);
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
        case 1: // BODY_HASH
          if (field.type == TType.STRING) {
            this.bodyHash = iprot.readBytes();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SIZE
          if (field.type == TType.I32) {
            this.size = iprot.readI32();
            setSizeIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // BODY
          if (field.type == TType.STRING) {
            this.body = iprot.readBytes();
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
    if (this.bodyHash != null) {
      if (isSetBodyHash()) {
        oprot.writeFieldBegin(BODY_HASH_FIELD_DESC);
        oprot.writeBinary(this.bodyHash);
        oprot.writeFieldEnd();
      }
    }
    if (isSetSize()) {
      oprot.writeFieldBegin(SIZE_FIELD_DESC);
      oprot.writeI32(this.size);
      oprot.writeFieldEnd();
    }
    if (this.body != null) {
      if (isSetBody()) {
        oprot.writeFieldBegin(BODY_FIELD_DESC);
        oprot.writeBinary(this.body);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Data(");
    boolean first = true;

    if (isSetBodyHash()) {
      sb.append("bodyHash:");
      if (this.bodyHash == null) {
        sb.append("null");
      } else {
        TBaseHelper.toString(this.bodyHash, sb);
      }
      first = false;
    }
    if (isSetSize()) {
      if (!first) sb.append(", ");
      sb.append("size:");
      sb.append(this.size);
      first = false;
    }
    if (isSetBody()) {
      if (!first) sb.append(", ");
      sb.append("body:");
      if (this.body == null) {
        sb.append("null");
      } else {
        TBaseHelper.toString(this.body, sb);
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

