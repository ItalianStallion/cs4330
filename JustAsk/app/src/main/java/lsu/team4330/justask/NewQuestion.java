package lsu.team4330.justask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/*
Class for creating new questions to send to selected users in recipientListView.
 */
public class NewQuestion extends AppCompatActivity {

    public static final String ACTION_YES = "lsu.team4330.justask.NewQuestion.actionYes";
    public static final String ACTION_NO = "lsu.team4330.justask.NewQuestion.actionNo";
    public static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);

        // Creates toolbar and handles back navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText questionEditText = (EditText) findViewById(R.id.question_edit_text);

        // String list stub for demoing
        //TODO: Replace with an ArrayList of Users or user information
        List<String> recipients = new ArrayList<>();
        recipients.add("Alan Turing");
        recipients.add("Grace Hopper");
        recipients.add("Ada Lovelace");
        recipients.add("Nash Mahmoud");

        // Adapts Users to Recipient List
        ListView recipientListView = (ListView)findViewById(R.id.recipient_list_view);
        RecipientListAdapter adapter = new RecipientListAdapter(this, R.layout.recipient_list_item, recipients);
        recipientListView.setAdapter(adapter);

        // Retrieves a database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NO);
        filter.addAction(ACTION_YES);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(ACTION_YES)) {
                    actionYes();
                } else if (intent.getAction().equals(ACTION_NO)) {
                    actionNo();
                }
            }
        };

        registerReceiver(receiver, filter);
    }

    public void sendQuestion(View view) {
        showNotification(view);
    }

    public void cancel(View view) {
        finish();
    }

    public void showNotification(View v) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        EditText questionEditText = (EditText) findViewById(R.id.question_edit_text);
        String question = questionEditText.getText().toString();

        // Creates intents for yes and no actions; Intents point to actionYes and actionNo in our BroadcastReceiver
        PendingIntent yesPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_YES), 0);
        PendingIntent noPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_NO), 0);

        // Notification setup for incoming questions
        NotificationCompat.Builder mbuilder =
                new NotificationCompat.Builder(this)
                        .setTicker("JustAsk Question!")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("John Smith")
                        .setContentText(question)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .addAction(R.drawable.ic_yes_black_24dp, "Yes", yesPendingIntent)
                        .addAction(R.drawable.ic_no_black_24dp, "No", noPendingIntent);

        notificationManager.notify(NOTIFICATION_ID, mbuilder.build());
    }

    public void actionYes() {
        Log.d("NewQuestion", "actionYes");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTIFICATION_ID);
    }

    public void actionNo() {
        Log.d("NewQuestion", "actionNo");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
