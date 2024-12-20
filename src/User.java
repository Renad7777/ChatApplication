/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
//public class User implements Cloneable {
//    private String fullName;
//    private String email;
//    private String password;
//
//    public User(String fullName, String email, String password) {
//        this.fullName = fullName;
//        this.email = email;
//        this.password = password;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public User clone() {
//        try {
//            return (User) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException("Clone not supported", e);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "fullName='" + fullName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//
//    
//}
public class User implements Cloneable {
    private String fullName;
    private String email;
    private String password;

    // Constructor
    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    // Private constructor for Builder
    private User(Builder builder) {
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Clone method
    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String fullName;
        private String email;
        private String password;

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
