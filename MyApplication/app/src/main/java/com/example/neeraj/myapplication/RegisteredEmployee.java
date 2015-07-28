package com.example.neeraj.myapplication;

import java.math.BigInteger;

/**
 * Created by neeraj on 28/7/15.
 */
public class RegisteredEmployee implements java.io.Serializable{
    private String name,type,email,hobbies,dob,password,about;
    private String mobileNo,gender;

    public RegisteredEmployee(String pName,String pType,String pmob,String pEmail,String pGender,String pHobbies,String pDob,String pPassword,String pAbout){
        name=pName;
        type=pType;
        mobileNo=pmob;
        email=pEmail;
        gender=pGender;
        hobbies=pHobbies;
        dob=pDob;
        password=pPassword;
        about=pAbout;
    }

    public String displayEmployee(){
        String data;
        data="\n Name : "+name+"\n Type : "+type+"\n Email : "+email+"\n Mobile : "+mobileNo+"\n Gender : "+gender+"\n Hobbies : "+hobbies+"\n DOB : "+dob+"\n Password : "+password+"\n About : "+about+"\n\n You Have Been Successfully Registered.";
        return data;
    }
}
