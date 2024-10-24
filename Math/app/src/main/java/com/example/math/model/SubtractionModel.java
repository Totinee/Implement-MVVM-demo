package com.example.math.model;

/**
 * @author Hasneen Tamanna Totinee
 * @version 1.0
 *
 * SubtractionModel class represents the data for subtraction operations.
 */

public class SubtractionModel {
    private Integer input1;  // First integer number input
    private Integer input2;  // Second integer number input
    private Integer result;  // Result of integer number subtraction

    private Double doubleInput1;  // First double input
    private Double doubleInput2;  // Second double input
    private Double doubleResult;  // Result of double number subtraction

    // Default constructor
    public SubtractionModel() {}

    /**
     * Constructor for subtraction between two integer numbers
     *
     * @param input1 this is the first integer value for subtraction
     * @param input2 this is the second integer value for subtraction
     * @param result this is the result of subtracting second int number from first int number
     */
    public SubtractionModel(int input1, int input2, int result) {
        this.input1 = input1;
        this.input2 = input2;
        this.result = result;
    }

    /**
     * Constructor for subtraction between two double numbers
     *
     * @param input1 this is the first double value for subtraction
     * @param input2 this is the second double value for subtraction
     * @param result this is the result of subtracting second double number from first double number
     */
    public SubtractionModel(double input1, double input2, double result) {
        this.doubleInput1 = input1;
        this.doubleInput2 = input2;
        this.doubleResult = result;
    }

    public Integer getInput1() {
        return input1;
    }

    public Integer getInput2() {
        return input2;
    }

    public Integer getResult() {
        return result;
    }

    public Double getDoubleInput1() {
        return doubleInput1;
    }

    public Double getDoubleInput2() {
        return doubleInput2;
    }

    public Double getDoubleResult() {
        return doubleResult;
    }
}
