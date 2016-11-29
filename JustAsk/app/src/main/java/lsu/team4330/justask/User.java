/****************************************************************************************/
/*
/* FILE NAME: User.java
/*
/* DESCRIPTION: class to hold user information
/*
/*
/*
/* DATE       BY               DESCRIPTION
/* ========== ===============  =============
/* 11/26/2016 Ben Graham       Created the class
/*
/****************************************************************************************/

package lsu.team4330.justask;

//user class
public class User {

    private String name;
    private int userId;

    //constructor for the user information
    User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    //returns the name of the user
    public String getName() {
        return this.name;
    }

    //returns the users Id
    public int getUserId() {
        return this.userId;
    }
}
