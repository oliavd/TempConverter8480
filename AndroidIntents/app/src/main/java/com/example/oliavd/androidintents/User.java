package com.example.oliavd.androidintents;

/**
 * Created by oliavd on 2/27/18.
 */

public class User {

    public static String USER_NAME = "username";
    /* true -> male // false->female */
    public static String USER_GENDER = "gender";
    public static String USER_SKILL_POINTS = "skillPoints";
    public String name;
    public boolean gender;
    public int skillPoints;

    public User(String name, boolean gender){
        this.name = name;
        this.gender = gender;
        this.skillPoints = 0;

    }


}

