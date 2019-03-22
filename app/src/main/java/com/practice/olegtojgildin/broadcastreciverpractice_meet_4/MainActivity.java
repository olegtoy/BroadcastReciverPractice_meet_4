package com.practice.olegtojgildin.broadcastreciverpractice_meet_4;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mStateTextView;
    private Button mUpdateStateButton;

    private MyReceiver mReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        initReceivers();
    }

    private void initViews() {
        mStateTextView = findViewById(R.id.state_text_view);
        mUpdateStateButton = findViewById(R.id.update_state_button);
    }

    private void initListeners() {
        mUpdateStateButton.setOnClickListener(v -> updateState());
    }

    private void updateState() {
        startService(MyIntentService.newIntentForUpdate(MainActivity.this));
    }

    private void initReceivers() {
        mReceiver = new MyReceiver(response -> mStateTextView.setText(response));
        mIntentFilter = new IntentFilter(getResources().getString(R.string.filter_send_messages));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter, getResources().getString(R.string.permission_send_messages), null);
        getState();
    }

    private void getState() {
        startService(MyIntentService.newIntent(MainActivity.this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}