// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HiService.proto

package com.example.grpc;

/**
 * Protobuf type {@code com.example.grpc.HelloRequest}
 */
public  final class HelloRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.grpc.HelloRequest)
    HelloRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use HelloRequest.newBuilder() to construct.
  private HelloRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HelloRequest() {
    name_ = "";
    age_ = 0;
    hobbies_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private HelloRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 16: {

            age_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              hobbies_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000004;
            }
            hobbies_.add(s);
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              tags_ = com.google.protobuf.MapField.newMapField(
                  TagsDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000008;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            tags__ = input.readMessage(
                TagsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            tags_.getMutableMap().put(
                tags__.getKey(), tags__.getValue());
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        hobbies_ = hobbies_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 4:
        return internalGetTags();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.grpc.HelloRequest.class, com.example.grpc.HelloRequest.Builder.class);
  }

  private int bitField0_;
  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 1;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGE_FIELD_NUMBER = 2;
  private int age_;
  /**
   * <code>int32 age = 2;</code>
   */
  public int getAge() {
    return age_;
  }

  public static final int HOBBIES_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList hobbies_;
  /**
   * <code>repeated string hobbies = 3;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getHobbiesList() {
    return hobbies_;
  }
  /**
   * <code>repeated string hobbies = 3;</code>
   */
  public int getHobbiesCount() {
    return hobbies_.size();
  }
  /**
   * <code>repeated string hobbies = 3;</code>
   */
  public java.lang.String getHobbies(int index) {
    return hobbies_.get(index);
  }
  /**
   * <code>repeated string hobbies = 3;</code>
   */
  public com.google.protobuf.ByteString
      getHobbiesBytes(int index) {
    return hobbies_.getByteString(index);
  }

  public static final int TAGS_FIELD_NUMBER = 4;
  private static final class TagsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_TagsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> tags_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetTags() {
    if (tags_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          TagsDefaultEntryHolder.defaultEntry);
    }
    return tags_;
  }

  public int getTagsCount() {
    return internalGetTags().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; tags = 4;</code>
   */

  public boolean containsTags(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetTags().getMap().containsKey(key);
  }
  /**
   * Use {@link #getTagsMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getTags() {
    return getTagsMap();
  }
  /**
   * <code>map&lt;string, string&gt; tags = 4;</code>
   */

  public java.util.Map<java.lang.String, java.lang.String> getTagsMap() {
    return internalGetTags().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; tags = 4;</code>
   */

  public java.lang.String getTagsOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetTags().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; tags = 4;</code>
   */

  public java.lang.String getTagsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetTags().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (age_ != 0) {
      output.writeInt32(2, age_);
    }
    for (int i = 0; i < hobbies_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, hobbies_.getRaw(i));
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetTags(),
        TagsDefaultEntryHolder.defaultEntry,
        4);
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, age_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < hobbies_.size(); i++) {
        dataSize += computeStringSizeNoTag(hobbies_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getHobbiesList().size();
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetTags().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      tags__ = TagsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, tags__);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.grpc.HelloRequest)) {
      return super.equals(obj);
    }
    com.example.grpc.HelloRequest other = (com.example.grpc.HelloRequest) obj;

    boolean result = true;
    result = result && getName()
        .equals(other.getName());
    result = result && (getAge()
        == other.getAge());
    result = result && getHobbiesList()
        .equals(other.getHobbiesList());
    result = result && internalGetTags().equals(
        other.internalGetTags());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    if (getHobbiesCount() > 0) {
      hash = (37 * hash) + HOBBIES_FIELD_NUMBER;
      hash = (53 * hash) + getHobbiesList().hashCode();
    }
    if (!internalGetTags().getMap().isEmpty()) {
      hash = (37 * hash) + TAGS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetTags().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.grpc.HelloRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.HelloRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.HelloRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.HelloRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.grpc.HelloRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.HelloRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.grpc.HelloRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.grpc.HelloRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.grpc.HelloRequest)
      com.example.grpc.HelloRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetTags();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 4:
          return internalGetMutableTags();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.grpc.HelloRequest.class, com.example.grpc.HelloRequest.Builder.class);
    }

    // Construct using com.example.grpc.HelloRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      name_ = "";

      age_ = 0;

      hobbies_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      internalGetMutableTags().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.grpc.HiService.internal_static_com_example_grpc_HelloRequest_descriptor;
    }

    public com.example.grpc.HelloRequest getDefaultInstanceForType() {
      return com.example.grpc.HelloRequest.getDefaultInstance();
    }

    public com.example.grpc.HelloRequest build() {
      com.example.grpc.HelloRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.example.grpc.HelloRequest buildPartial() {
      com.example.grpc.HelloRequest result = new com.example.grpc.HelloRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.name_ = name_;
      result.age_ = age_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        hobbies_ = hobbies_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.hobbies_ = hobbies_;
      result.tags_ = internalGetTags();
      result.tags_.makeImmutable();
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.grpc.HelloRequest) {
        return mergeFrom((com.example.grpc.HelloRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.grpc.HelloRequest other) {
      if (other == com.example.grpc.HelloRequest.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (!other.hobbies_.isEmpty()) {
        if (hobbies_.isEmpty()) {
          hobbies_ = other.hobbies_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureHobbiesIsMutable();
          hobbies_.addAll(other.hobbies_);
        }
        onChanged();
      }
      internalGetMutableTags().mergeFrom(
          other.internalGetTags());
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.grpc.HelloRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.grpc.HelloRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 2;</code>
     */
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 2;</code>
     */
    public Builder setAge(int value) {
      
      age_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 2;</code>
     */
    public Builder clearAge() {
      
      age_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList hobbies_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureHobbiesIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        hobbies_ = new com.google.protobuf.LazyStringArrayList(hobbies_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getHobbiesList() {
      return hobbies_.getUnmodifiableView();
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public int getHobbiesCount() {
      return hobbies_.size();
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public java.lang.String getHobbies(int index) {
      return hobbies_.get(index);
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public com.google.protobuf.ByteString
        getHobbiesBytes(int index) {
      return hobbies_.getByteString(index);
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public Builder setHobbies(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureHobbiesIsMutable();
      hobbies_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public Builder addHobbies(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureHobbiesIsMutable();
      hobbies_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public Builder addAllHobbies(
        java.lang.Iterable<java.lang.String> values) {
      ensureHobbiesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, hobbies_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public Builder clearHobbies() {
      hobbies_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string hobbies = 3;</code>
     */
    public Builder addHobbiesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureHobbiesIsMutable();
      hobbies_.add(value);
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> tags_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetTags() {
      if (tags_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            TagsDefaultEntryHolder.defaultEntry);
      }
      return tags_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableTags() {
      onChanged();;
      if (tags_ == null) {
        tags_ = com.google.protobuf.MapField.newMapField(
            TagsDefaultEntryHolder.defaultEntry);
      }
      if (!tags_.isMutable()) {
        tags_ = tags_.copy();
      }
      return tags_;
    }

    public int getTagsCount() {
      return internalGetTags().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public boolean containsTags(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetTags().getMap().containsKey(key);
    }
    /**
     * Use {@link #getTagsMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getTags() {
      return getTagsMap();
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getTagsMap() {
      return internalGetTags().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public java.lang.String getTagsOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetTags().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public java.lang.String getTagsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetTags().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearTags() {
      internalGetMutableTags().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public Builder removeTags(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableTags().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableTags() {
      return internalGetMutableTags().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */
    public Builder putTags(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableTags().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; tags = 4;</code>
     */

    public Builder putAllTags(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableTags().getMutableMap()
          .putAll(values);
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.example.grpc.HelloRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.grpc.HelloRequest)
  private static final com.example.grpc.HelloRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.grpc.HelloRequest();
  }

  public static com.example.grpc.HelloRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HelloRequest>
      PARSER = new com.google.protobuf.AbstractParser<HelloRequest>() {
    public HelloRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new HelloRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HelloRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HelloRequest> getParserForType() {
    return PARSER;
  }

  public com.example.grpc.HelloRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

