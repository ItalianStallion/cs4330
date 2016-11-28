package lsu.team4330.justask;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

//TODO: If logged in launch MainActivity, else launch Login.
public class Login extends FragmentActivity {
    private CallbackManager callbackManager;
    private TextView info;
    private LoginButton loginButton;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.justask_large_silhouette);


        loginButton = (LoginButton) findViewById(R.id.login_button);

        info = (TextView) findViewById(R.id.info);
        TextView justAsk = (TextView) findViewById(R.id.just_ask);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Damion-Regular.ttf");
        justAsk.setTypeface(type);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                info.setText(
                        "User ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel()
            {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException error)
            {
                info.setText("Login attempt failed.");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
