package lsu.team4330.justask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Question extends AppCompatActivity {

    private String question;
    private int questionId;
    private User sender;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Creates toolbar and handles back navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    Question(String question, int questionId, User sender, int time) {
        this.question = question;
        this.questionId = questionId;
        this.sender = sender;
        this.time = time;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getQuestionId() {
        return this.questionId;
    }

    public User getSender() {
        return this.sender;
    }

    public int getTime() {
        return this.time;
    }
}
