package lsu.team4330.justask;

/**
 * Created by milesvesper on 11/26/16.
 */

import android.app.NotificationManager;
import android.os.Bundle;
import android.app.Activity;

public class ShowNotificationDetailActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_responce);

        // Destroys notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);
    }
}
