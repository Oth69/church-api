package com.example.uploadtest;
public class ReadWriteUserDetails {
    public String fullName,doB,email, gender, mobile, job,username,password;

    public ReadWriteUserDetails(){};

    public ReadWriteUserDetails(String textDoB,String textEmail,String textFullName,String textGender,String textJob,String textMobile,String textUsername,String textPwd){
        this.doB = textDoB;
        this.email = textEmail;
        this.fullName = textFullName;
        this.gender = textGender;
        this.job = textJob;
        this.mobile = textMobile;
        this.username = textUsername;
        this.password = textPwd;






    }
}
