package com.example.mobileappdevelop.simpledoctor;

/**
 * Created by Nocturnal on 05-Apr-17.
 */

public class RegisterPref {
    private String firstName;
    private  String lastName;
    private String email;
    private String pasword;
    private String secQues;
    private String secQuesAns;

    //region constructor
    public RegisterPref() {
    }

    public RegisterPref(String firstName, String lastName, String email, String pasword, String secQuesid, String secQuesAns) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pasword = pasword;
        this.secQues = secQuesid;
        this.secQuesAns = secQuesAns;
    }
    //endregion

    //region setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setSecQues(String secQues) {
        this.secQues = secQues;
    }

    public void setSecQuesAns(String secQuesAns) {
        this.secQuesAns = secQuesAns;
    }


    //endregion

    //region getter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPasword() {
        return pasword;
    }

    public String getSecQues() {
        return secQues;
    }

    public String getSecQuesAns() {
        return secQuesAns;
    }


    //endregion

    //region Method

    public  String FullName()
    {
        return this.firstName+" "+this.lastName;
    }
    //endregion

}
