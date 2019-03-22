package com.practice.olegtojgildin.broadcastreciverpractice_meet_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by olegtojgildin on 22/03/2019.
 */

public class MyReceiver extends BroadcastReceiver {

    private static final String EXTRA_UPDATE = "Update";

    private MyReceiverCallback mCallback;

    public MyReceiver(MyReceiverCallback callback) {
        mCallback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        StateManager stateManager = StateManager.getInstance();
        if (intent != null && intent.getBooleanExtra(EXTRA_UPDATE, false))
            stateManager.updateState();
        mCallback.onResponse(String.valueOf(stateManager.getState()));
    }
}