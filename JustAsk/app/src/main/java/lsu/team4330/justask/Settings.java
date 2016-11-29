/****************************************************************************************/
/*
/* FILE NAME: Settings.java
/*
/* DESCRIPTION: java file for the settings layout, only allows the user to logout of Facebook
/*
/*
/* DATE       BY               DESCRIPTION
/* ========== ===============  =============
/* 11/28/2016 Ben Graham       Created the class
/*
/****************************************************************************************/

package lsu.team4330.justask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.login.LoginManager;

//settings java class
public class Settings extends AppCompatActivity {

    //called when the layout is opened in app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Creates toolbar with back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //logs out of facebook when the 'logout' button is tapped
    public void logOut(View v) {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
