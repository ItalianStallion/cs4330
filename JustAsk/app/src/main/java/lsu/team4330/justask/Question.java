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

public class Question extends AppCompatActivity {

    private String question;
    private String questionId;
    private User sender;
    private int time;

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

    Question(String question, String questionId, User sender, int time) {
        this.question = question;
        this.questionId = questionId;
        this.sender = sender;
        this.time = time;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getQuestionId() {
        return this.questionId;
    }

    public User getSender() {
        return this.sender;
    }

    public int getTime() {
        return this.time;
    }

}
