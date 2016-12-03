package lsu.team4330.justask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = "MainActivity";
    private FirebaseUser currentUser;
    private DatabaseReference ref;
    public static AppCompatActivity main;
    private FirebaseListAdapter<Question> adapter;
    private ListView questionListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);

        //Activity for passing to settings on logout
        //TODO: find more elegant solution
        main = this;

        // If user isn't logged in go to login activity
        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference("questions");

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


        adapter = new FirebaseListAdapter<Question>(this, Question.class, R.layout.question_list_item, ref) {
            @Override
            protected void populateView(View view, Question question, int position) {

                if (view == null) {
                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    view = layoutInflater.inflate(R.layout.question_list_item, null);
                }

                TextView questionTextView = (TextView) view.findViewById(R.id.question_text_view);
                TextView senderTextView = (TextView) view.findViewById(R.id.sender_text_view);
                TextView timeTextView = (TextView) view.findViewById(R.id.time_text_view);
                ImageView imageView = (ImageView) view.findViewById(R.id.image_view);

                questionTextView.setText(question.getQuestion());
                senderTextView.setText(question.getSender().getDisplayName());
                timeTextView.setText(question.getTime());

                // if currentUser is sender, message is outgoing
                if(question.getSender().getUid().equals(currentUser.getUid())) {
                    imageView.setImageResource(R.drawable.ic_arrow_outgoing_black_50dp);
                }
                else {
                    imageView.setImageResource(R.drawable.ic_arrow_incoming_black_50dp);
                }
            }
        };

        // ListView setup
        questionListView = (ListView) findViewById(R.id.question_list_view);
        questionListView.setAdapter(adapter);

        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Question item = (Question) questionListView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                // TODO: change putExtra to questionId; Use id to pull recipient list in QuestionActivity.class
                intent.putExtra("QUESTION", item.getQuestion());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
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

    public void newQuestion(View view) {
        Intent intent = new Intent(this, NewQuestion.class);
        startActivity(intent);
    }
}

