package com.test;

public class SignUpUser {
    private final String fullName;
    private final String mobileNumber;
    private final String email;
    private final String password;

    public SignUpUser(String fullName, String mobileNumber, String email, String password) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
