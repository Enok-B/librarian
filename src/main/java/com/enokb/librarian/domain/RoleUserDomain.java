package com.enokb.librarian.domain;

public class RoleUserDomain {
    private String id;

    private String userid;

    private Integer roleid;

    public RoleUserDomain() {
    }

    private RoleUserDomain(Builder builder) {
        setId(builder.id);
        setUserid(builder.userid);
        setRoleid(builder.roleid);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RoleUserDomain copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.userid = copy.getUserid();
        builder.roleid = copy.getRoleid();
        return builder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }


    public static final class Builder {
        private String id;
        private String userid;
        private Integer roleid;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder userid(String val) {
            userid = val;
            return this;
        }

        public Builder roleid(Integer val) {
            roleid = val;
            return this;
        }

        public RoleUserDomain build() {
            return new RoleUserDomain(this);
        }
    }
}