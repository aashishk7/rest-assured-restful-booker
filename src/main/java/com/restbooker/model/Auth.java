package com.restbooker.model;

public class Auth {
    
    private String username;
    private String password;

    private Auth(String name, String password) {
        this.username = name ;
        this.password = password ;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public static class Builder {
        private String username, password;

        public Builder setusername(String name) {
            this.username = name;
            return this;
        }

        public Builder setpassword(String password) {
            this.password = password;
            return this;
        }

        public Auth build() {
            return new Auth(username, password);
        }
    }
}
