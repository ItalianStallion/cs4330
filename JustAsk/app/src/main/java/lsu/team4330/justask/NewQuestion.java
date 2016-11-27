package lsu.team4330.justask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
        List<String> strings = new ArrayList<>();
        String str = "Alan Turing";
        strings.add(str);
        String str2 = "Grace Hopper";
        strings.add(str2);

        // Adapts Users to Recipient List
        ListView recipientListView = (ListView)findViewById(R.id.recipient_list_view);
        RecipientListAdapter adapter = new RecipientListAdapter(this, R.layout.recipient_list_item, strings);
        recipientListView.setAdapter(adapter);

        // Retrieves a database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();


    }

    public void sendQuestion(View view) {
        showNotification(view);
    }

    public void cancel(View view) {
        finish();
    }

    public void showNotification(View v) {
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, new Intent(this, ShowNotificationDetailActivity.class), 0);
        Resources r = getResources();
        NotificationCompat.Builder mbuilder =
                new NotificationCompat.Builder(this)
                        .setTicker("JustAsk Question!")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Question!")
                        .setContentText("You have a new question in JustAsk")
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .addAction(R.drawable.ic_yes_black_24dp, "Yes", pIntent)
                        .addAction(R.drawable.ic_no_black_24dp, "No", pIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, mbuilder.build());
    }
}
