package com.example.mobileappdevelop.simpledoctor;

import android.content.SharedPreferences;

import java.util.Objects;

/**
 * Created by Nocturnal on 05-Apr-17.
 */

public class LogInPref {

    public static final String EMAIL="email";
    public static  final String PASSWORD="password";
    public static final String LOGIN_PREF_NAME="log_in";
    private RegSharePreference regPrefernce;
    RegisterPref register;
    private SharedPreferences.Editor editor;
    public LogInPref(SharedPreferences preferences)
    {
        regPrefernce=new RegSharePreference(preferences);
        this.editor=preferences.edit();
    }
    public boolean LogIn(String email,String password){

        register = new RegisterPref();
        register = regPrefernce.GetRegister();
        if (Objects.equals(register.getEmail(), new String(email))&&Objects.equals(register.getPasword(), new String(password))){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean MatchSecurityQuestion(int questionId,String answer)
    {
        return true;
    }
    public boolean ForgetPassword(String newPassword)
    {
        return  true;
    }
    public boolean ChangePassword(String oldPassword,String newPassword)
    {
        return true;
    }
}
