package com.example.demo.model;

public class FormData {
    private String fname;
    private String lname;
    private String email;
    private String phoneNo;


    public FormData(){

    }

    public FormData(String fname, String lname, String email, String phoneNo) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
