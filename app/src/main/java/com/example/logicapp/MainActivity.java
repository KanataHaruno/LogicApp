package com.example.logicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // Change the logical operand
    // Record entry
    // Use the method to check for right answers when the button is pressed !!!
    // Reset the app

    private final String trueStatement = "T";
    private final String falseStatement = "F";
    private final int numberOfOperands = 4;

    private TextView logicSwitch;
    private TextView operand;

    private Button check;

    private EditText firstEntry;
    private EditText secondEntry;
    private EditText thirdEntry;
    private EditText fourthEntry;

    private boolean answer;
    private int operandValue;

    private String trueTrue;
    private String trueFalse;
    private String falseTrue;
    private String falseFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set title at the top and operand at top of right column
        logicSwitch = findViewById(R.id.textViewLogicSwitch);
        operand = findViewById(R.id.textViewOperand);
        check = findViewById(R.id.buttonCheck);

        changeOperand();

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Get the user input
                inputStatement();

                // Check if input is correct
                checkInput();

                // Give feedback and reset the operand
                feedback();
            }
        });




    }


    // Checks the user input
    private void inputStatement() {

        //First entry A and B are true
        firstEntry = findViewById(R.id.logicTrueTrue);
        trueTrue = firstEntry.getText().toString();

        //Second entry, A is true, B is false
        secondEntry = findViewById(R.id.logicTrueFalse);
        trueFalse = secondEntry.getText().toString();

        //Third entry, A is false, B is true
        thirdEntry = findViewById(R.id.logicFalseTrue);
        falseTrue = thirdEntry.getText().toString();

        //Fourth entry,  A and B are false
        fourthEntry = findViewById(R.id.logicFalseFalse);
        falseFalse = fourthEntry.getText().toString();
    }


    // All operands as methods
    private boolean conjunction() {
        // AND
        if (trueTrue.equals(trueStatement) &&
                trueFalse.equals(falseStatement) &&
                falseTrue.equals(falseStatement) &&
                falseFalse.equals(falseStatement)) answer = true;
        else answer = false;
        return answer;
    }

    private boolean disjunction() {
        // OR
        if (trueTrue.equals(trueStatement) &&
                trueFalse.equals(trueStatement) &&
                falseTrue.equals(trueStatement) &&
                falseFalse.equals(falseStatement)) answer = true;
        else answer = false;
        return answer;
    }

    private boolean implication() {
        // IF
        if (trueTrue.equals(trueStatement) &&
                trueFalse.equals(trueStatement) &&
                falseTrue.equals(falseStatement) &&
                falseFalse.equals(trueStatement)) answer = true;
        else answer = false;
        return answer;
    }

    private boolean equivalence() {
        // IF and only IF
        if (firstEntry.equals(trueStatement) &&
                secondEntry.equals(falseStatement) &&
                thirdEntry.equals(falseStatement) &&
                fourthEntry.equals(trueStatement)) answer = true;
        else answer = false;
        return answer;
    }


    // Switch case to send random operand and check
    public void changeOperand() {
        operandValue = new Random().nextInt(numberOfOperands) + 1;

        switch (operandValue) {
            case 1:
                // AND
                logicSwitch.setText("∧");
                operand.setText("Conjunction");
                break;

            case 2:
                // OR
                logicSwitch.setText("∨");
                operand.setText("Disjunction");

                break;

            case 3:
                // IF
                logicSwitch.setText("⇒");
                operand.setText("Implication");
                break;

            case 4:
                // IF and only IF
                logicSwitch.setText("⇔");
                operand.setText("Equivalence");
                break;
        }
    }

    public void checkInput(){
        if (operandValue == 1) conjunction();
        if (operandValue == 2) disjunction();
        if (operandValue == 3) implication();
        if (operandValue == 4) equivalence();

    }

    private void feedback() {
        if (answer) Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        else if (!answer) Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        changeOperand();
    }

}

