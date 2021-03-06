/****************************************************************************************/
/*
/* FILE NAME: MainActivity.java
/*
/* DESCRIPTION: main activity for app, including the drawer to switch to other tabs and
/*                the home screen (a list of all questions)
/*
/*
/* DATE       BY               DESCRIPTION
/* ========== ===============  =============
/* 11/1/2016  Ben Graham       Created the class
/* 11/24/2016 Ben Graham       added question layout
/* 11/26/2016 Miles Vesper     add notification method
/* 11/27/2016 Ben Graham       implement arrows on list
/* 11/27/2016 Ben Graham       Connected question list to their activities
/* 11/27/2016 Ben Graham       add settings page
/*
/****************************************************************************************/

package lsu.team4330.justask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

//class for the homepage activity
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //method that is called when the homepage is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);

        // Sets up toolbar and action buttons for it
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Creates drawer and sets listener for drawer events
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Sets up NavigationView for the DrawerLayout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Hardcoded questionList to populate MainActivity question_list_view
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("Are you free for lunch?", 123, new User("Ben Graham", 1),1130));
        questionList.add(new Question("Poker tonight?", 123, new User("Ben Graham", 2),630));
        questionList.add(new Question("Who wants to hang out after class?", 123, new User("Miles Vesper", 3),1200));
        questionList.add(new Question("Study in the library?", 123, new User("John Schwartzenburg", 4),1800));
        questionList.add(new Question("Did you commit to the repo today?", 123, new User("Patrick Mancuso", 5),2030));

        // ListView setup
        final ListView questionListView = (ListView) findViewById(R.id.question_list_view);
        QuestionListAdapter adapter = new QuestionListAdapter(this, R.layout.question_list_item, questionList);
        questionListView.setAdapter(adapter);

        //opens activity for individual question
        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Question item = (Question) questionListView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, Question.class);
                // TODO: change putExtra to questionId; Use id to pull recipient list in Question.class
                intent.putExtra("QUESTION", item.getQuestion());
                startActivity(intent);
            }
        });

    }

    //returns to the homepage from another tab
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //creates side menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Handle navigation view item clicks here.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = new Intent();

        if (id == R.id.nav_question) {
            // Handle question tab click
            intent = new Intent(this, MainActivity.class);
        } else if (id == R.id.nav_contacts) {
            intent = new Intent(this, Contacts.class);
        } else if (id == R.id.nav_settings) {
            intent = new Intent(this, Settings.class);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        startActivity(intent);
        return true;
    }

    //method that opens the new question creation activity
    public void newQuestion(View view) {
        Intent intent = new Intent(this, NewQuestion.class);
        startActivity(intent);
    }

}
