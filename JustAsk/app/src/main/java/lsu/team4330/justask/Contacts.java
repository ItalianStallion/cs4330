package lsu.team4330.justask;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/*
Class for creating new questions to send to selected users in recipientListView.
 */
public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Creates toolbar with back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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





}
