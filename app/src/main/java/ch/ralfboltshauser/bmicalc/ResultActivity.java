package ch.ralfboltshauser.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.LocalServerSocket;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView bmiTextView;
    private TextView bmiRangeTextView;

    BmiService bmiService;
    boolean serviceBound = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BmiService.LocalBinder binder = (BmiService.LocalBinder) service;
            bmiService = binder.getService();
            serviceBound = true;

            setResultTexts();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            serviceBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(e -> {
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BmiService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        serviceBound = false;
    }

    private void setResultTexts() {
        bmiTextView = findViewById(R.id.bmiTextView);
        bmiRangeTextView = findViewById(R.id.bmiRangeTextView);

        bmiTextView.setText(String.valueOf(bmiService.getBmi()));

        bmiRangeTextView.setText(String.valueOf(bmiService.getBmiClassification()));
    }
}