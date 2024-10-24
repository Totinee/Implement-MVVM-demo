package com.example.math.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.math.model.SubtractionModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 *
 * @author Hasneen Tamanna Totinee
 * @version 1.0
 *
 * SubtractionViewModel class manages subtraction operations and interacts with Firebase for storing or retrieving data.
 */

public class SubtractionViewModel extends ViewModel {

    private final DatabaseReference databaseReference;

    // Constructor that initializes the Firebase reference
    public SubtractionViewModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference("SubtractionResults");
    }

    /**
     * It is the method to save result of integer subtraction into Firebase
     *
     * @param input1 this is the first integer number input
     * @param input2 this is the second integer number input
     * @param result this is the result of subtraction between first int number and second int number
     */
    public void saveResult(int input1, int input2, int result) {
        String id = databaseReference.push().getKey();  // To generate a unique key
        if (id != null) {
            SubtractionModel data = new SubtractionModel(input1, input2, result);
            databaseReference.child(id).setValue(data).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d("Firebase", "Data saved successfully");
                } else {
                    Log.e("Firebase", "Data saving failed", task.getException());
                }
            });
        }
    }

    /**
     * It is the method to save result of double subtraction into Firebase
     *
     * @param input1 this is the first double number input
     * @param input2 this is the second double number input
     * @param result this is the result of subtraction between first double number and second double number
     */
    public void saveDoubleResult(double input1, double input2, double result) {
        String id = databaseReference.push().getKey();  // To generate a unique key
        if (id != null) {
            // To directly use double values without casting
            SubtractionModel data = new SubtractionModel(input1, input2, result);
            databaseReference.child(id).setValue(data).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d("Firebase", "Double data saved successfully");
                } else {
                    Log.e("Firebase", "Double data saving failed", task.getException());
                }
            });
        }
    }
}
