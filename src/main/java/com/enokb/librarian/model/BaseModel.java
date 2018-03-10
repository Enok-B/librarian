package com.enokb.librarian.model;

public class BaseModel {
    private String id;

    public BaseModel() {
    }

    private BaseModel(Builder builder) {
        setId(builder.id);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(BaseModel copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        return builder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id='" + id + '\'' +
                '}';
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public BaseModel build() {
            return new BaseModel(this);
        }
    }
}
