package ch.ralfboltshauser.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private BmiCalculatorService bmiCalculatorService = BmiCalculatorService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = findViewById(R.id.calcBtn);

        TextInputEditText weight = findViewById(R.id.weightTextField);
        TextInputEditText height = findViewById(R.id.heightTextField);

        calcBtn.setOnClickListener(e -> {
            bmiCalculatorService.setHeight(Float.parseFloat(height.getText().toString()));

            bmiCalculatorService.setWeight(Float.parseFloat(weight.getText().toString()));
            Intent startResultActivity = new Intent(this, ResultActivity.class);
            startActivity(startResultActivity);
        });
    }
}