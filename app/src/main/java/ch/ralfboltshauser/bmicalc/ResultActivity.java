package ch.ralfboltshauser.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView bmiTextView;
    private TextView bmiRangeTextView;

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
        bmiTextView = findViewById(R.id.bmiTextView);
        bmiRangeTextView = findViewById(R.id.bmiRangeTextView);
        bmiTextView.setText(String.valueOf(MainActivity.bmiCalculatorService.getBmi()));
        bmiRangeTextView.setText(String.valueOf(MainActivity.bmiCalculatorService.getBmiClassification()));
    }
}