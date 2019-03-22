package com.practice.olegtojgildin.broadcastreciverpractice_meet_4;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by olegtojgildin on 22/03/2019.
 */

public class MyIntentService extends IntentService {

    private static final String EXTRA_UPDATE = "Update";

    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(getResources().getString(R.string.filter_send_messages));
        broadcastIntent.putExtra(EXTRA_UPDATE, intent != null && intent.getBooleanExtra(EXTRA_UPDATE, false));
        sendBroadcast(broadcastIntent, getResources().getString(R.string.permission_send_messages));
    }

    public static Intent newIntentForUpdate(Context context) {
        Intent intent = newIntent(context);
        intent.putExtra(EXTRA_UPDATE, true);
        return intent;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyIntentService.class);
    }
}