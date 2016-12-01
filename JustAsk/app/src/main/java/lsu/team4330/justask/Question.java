package lsu.team4330.justask;

import com.google.firebase.auth.UserInfo;

/**
 * Created by ben on 11/30/16.
 */

public class Question {
    private String question;
    private User sender;
    private String time;

    Question() {
        // No Args Constructor
    }

    Question(String question, User sender, String time) {
        this.question = question;
        this.sender = sender;
        this.time = time;
    }

    public String getQuestion() {
        return question;
    }

    public User getSender() {
        return sender;
    }

    public String getTime() {
        return time;
    }
}
