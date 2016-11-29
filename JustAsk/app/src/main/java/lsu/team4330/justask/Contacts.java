/****************************************************************************************/
/*
/* FILE NAME: Contacts.java
/*
/* DESCRIPTION: java file for the corresponding contacts xml file. Functionality for the
/*              contacts tab of the application
/*
/* DATE       BY                  DESCRIPTION
/* ========== ==================  =============
/* 11/26/2016 John Shwartzenburg  Created the class
/* 11/26/2016 Ben Graham          added notification icon to login screen
/*
/****************************************************************************************/

package lsu.team4330.justask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

//Class for the contacts tab
public class Contacts extends AppCompatActivity {

    //begins the execution for contacts
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
        List<String> recipients = new ArrayList<>();
        recipients.add("Miles Vesper");
        recipients.add("Sam Dowd");
        recipients.add("Patrick Mancuso");
        recipients.add("John Schwartzenburg");

        // Adapts Users to Recipient List
        ListView contactListView = (ListView)findViewById(R.id.recipient_list_view);
        RecipientListAdapter adapter = new RecipientListAdapter(this, R.layout.contacts_list_item, recipients);
        contactListView.setAdapter(adapter);

        // Retrieves a database reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
    }
}
