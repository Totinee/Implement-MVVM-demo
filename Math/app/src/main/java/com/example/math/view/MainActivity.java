package com.example.math.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.math.R;
import com.example.math.viewmodel.SubtractionViewModel;

/**
 *
 * @author Hasneen Tamanna Totinee
 * @version 1.0
 *
 * This class is performs subtraction between integer and double values
 * and saves the results to Firebase.
 */
public class MainActivity extends AppCompatActivity {

    private SubtractionViewModel viewModel; // ViewModel for managing subtraction operations
    private EditText input1EditText, input2EditText, input1DoubleEditText, input2DoubleEditText; // Input fields for user entries
    private Button calculateButton; // Button to trigger the calculation
    private TextView resultTextView;
    private RadioGroup subtractionType; // RadioGroup to select subtraction type

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To initialize the ViewModel
        viewModel = new ViewModelProvider(this).get(SubtractionViewModel.class);

        // To initialize views
        input1EditText = findViewById(R.id.input1);
        input2EditText = findViewById(R.id.input2);
        input1DoubleEditText = findViewById(R.id.input1Double);
        input2DoubleEditText = findViewById(R.id.input2Double);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
        subtractionType = findViewById(R.id.subtractionType);

        // To set an OnCheckedChangeListener to toggle visibility based on selected radio button
        subtractionType.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.intSubtraction) {
                // To show integer input fields and hide double input fields
                input1EditText.setVisibility(View.VISIBLE);
                input2EditText.setVisibility(View.VISIBLE);
                input1DoubleEditText.setVisibility(View.GONE);
                input2DoubleEditText.setVisibility(View.GONE);
            } else if (checkedId == R.id.doubleSubtraction) {
                // To show double input fields and hide integer input fields
                input1EditText.setVisibility(View.GONE);
                input2EditText.setVisibility(View.GONE);
                input1DoubleEditText.setVisibility(View.VISIBLE);
                input2DoubleEditText.setVisibility(View.VISIBLE);
            }
        });

        // To perform subtraction and save result to Firebase
        calculateButton.setOnClickListener(v -> {
            // To determine which type of subtraction to perform based on selected radio button
            if (subtractionType.getCheckedRadioButtonId() == R.id.intSubtraction) {
                String input1String = input1EditText.getText().toString();
                String input2String = input2EditText.getText().toString();

                if (!input1String.isEmpty() && !input2String.isEmpty()) {
                    int input1 = Integer.parseInt(input1String);
                    int input2 = Integer.parseInt(input2String);
                    int result = input1 - input2;

                    // To save the integer subtraction result to Firebase
                    viewModel.saveResult(input1, input2, result);

                    // To display integer subtraction result
                    Toast.makeText(MainActivity.this, "Integer Result: " + result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                }
            } else if (subtractionType.getCheckedRadioButtonId() == R.id.doubleSubtraction) {
                String input1DoubleString = input1DoubleEditText.getText().toString();
                String input2DoubleString = input2DoubleEditText.getText().toString();

                if (!input1DoubleString.isEmpty() && !input2DoubleString.isEmpty()) {
                    double input1Double = Double.parseDouble(input1DoubleString);
                    double input2Double = Double.parseDouble(input2DoubleString);
                    double resultDouble = input1Double - input2Double;

                    // To save the double subtraction result to Firebase
                    viewModel.saveDoubleResult(input1Double, input2Double, resultDouble);

                    // To display double subtraction result
                    Toast.makeText(MainActivity.this, "Double Result: " + resultDouble, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
