/****************************************************************************************/
/*
/* FILE NAME: Question.java
/*
/* DESCRIPTION: java file that displays the details of a question once it is clicked from
/*              the home page
/*
/*
/* DATE       BY               DESCRIPTION
/* ========== ===============  =============
/* 11/26/2016 Ben Graham       Created the class
/* 11/27/2016 Ben Graham       connect individual questions to the questionList and implement
/*                              arrows
/*
/****************************************************************************************/

package lsu.team4330.justask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//class for displaying an individual questions details
public class Question extends AppCompatActivity {

    private String question;
    private int questionId;
    private User sender;
    private int time;

    //method that is called once the activity begins
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        String question = intent.getStringExtra("QUESTION");

        // Creates toolbar and handles back navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Displays Question
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setText(question);

        //Hardcoded recipient list for demo
        List<String> recipients = new ArrayList<>();
        recipients.add("Miles Vesper");
        recipients.add("Sam Dowd");
        recipients.add("Patrick Mancuso");
        recipients.add("John Schwartzenburg");

        // Setup Recipient list
        ListView recipientListView = (ListView) findViewById(R.id.recipient_list_view);
        RecipientListAdapter adapter = new RecipientListAdapter(this, R.layout.recipient_list_item_2, recipients);
        recipientListView.setAdapter(adapter);

    }

    Question() {
        // No Args Constructor
    }

    //details for an individual question
    Question(String question, int questionId, User sender, int time) {
        this.question = question;
        this.questionId = questionId;
        this.sender = sender;
        this.time = time;
    }

    //returns the question
    public String getQuestion() {
        return this.question;
    }

    //returns the question id
    public int getQuestionId() {
        return this.questionId;
    }

    //returns the user that sent the question
    public User getSender() {
        return this.sender;
    }

    //returns the time the question was sent
    public int getTime() {
        return this.time;
    }
}
