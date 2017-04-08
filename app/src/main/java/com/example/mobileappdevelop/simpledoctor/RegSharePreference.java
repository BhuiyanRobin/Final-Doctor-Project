package com.example.mobileappdevelop.simpledoctor;

import android.content.SharedPreferences;

/**
 * Created by Nocturnal on 05-Apr-17.
 */

public class RegSharePreference {

    public static final String REG_SHARE_PREFERENCE_NAME="register";
    public static final String FIRST_NAME="first_Name";
    public static final String LAST_NAME="last_Name";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String PROFILE_PICTURE="profile_picture";
    public static final String SECURITY_QUESTION_ID="security_question";
    public static final String SECURITY_QUESTION_ANSWER="question_answer";
    private SharedPreferences myPrefrence;
    private SharedPreferences.Editor editor;

    RegSharePreference(SharedPreferences preferences)
    {
        myPrefrence=preferences;
        editor=myPrefrence.edit();
    }

    public boolean Save(RegisterPref register)
    {

            editor.putString(FIRST_NAME,register.getFirstName());
            editor.putString(LAST_NAME,register.getLastName());
            editor.putString(EMAIL,register.getEmail());
            editor.putString(PASSWORD,register.getPasword());
            editor.putString(SECURITY_QUESTION_ID,register.getSecQues());
            editor.putString(SECURITY_QUESTION_ANSWER,register.getSecQuesAns());
        editor.commit();
            return true;

    }
    public boolean Update(RegisterPref register)
    {
        editor.putString(FIRST_NAME,register.getFirstName());
        editor.putString(LAST_NAME,register.getLastName());
        editor.putString(EMAIL,register.getEmail());
        editor.putString(PASSWORD,register.getPasword());
        editor.putString(SECURITY_QUESTION_ID,register.getSecQues());
        editor.putString(SECURITY_QUESTION_ANSWER,register.getSecQuesAns());
        editor.commit();
        return true;
    }
    public RegisterPref GetRegister()
    {
        RegisterPref aRegister=new RegisterPref();
        aRegister.setFirstName(myPrefrence.getString(FIRST_NAME,""));
        aRegister.setLastName(myPrefrence.getString(LAST_NAME,""));
        aRegister.setEmail(myPrefrence.getString(EMAIL,""));
        aRegister.setPasword(myPrefrence.getString(PASSWORD,""));
        aRegister.setSecQues(myPrefrence.getString(SECURITY_QUESTION_ID,""));
        aRegister.setSecQuesAns(myPrefrence.getString(SECURITY_QUESTION_ANSWER,""));
        return aRegister;
    }

}
