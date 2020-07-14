package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int actualScore = 0;
    boolean repeatServe = false;
    boolean rightAnswerFour = false;
    EditText pointNumberEditText;
    EditText setNumberEditText;
    Editable addedPointNumber;
    Editable addedSetNumber;
    CheckBox redRubberCheck;
    CheckBox blackRubberCheck;
    CheckBox brownRubberCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointNumberEditText = (EditText) findViewById(R.id.number_of_points_edit_text);
        setNumberEditText = (EditText) findViewById(R.id.number_of_sets_edit_text);
        redRubberCheck = (CheckBox) findViewById(R.id.red_rubber_check);
        blackRubberCheck = (CheckBox) findViewById(R.id.black_rubber_check);
        brownRubberCheck = (CheckBox) findViewById(R.id.brown_rubber_check);
    }

    public void onQuestionTwoRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.you_radio:
            case R.id.enemy_radio:
                if (checked)
                    repeatServe = false;
                    break;
            case R.id.repeat_radio:
                if (checked)
                    repeatServe = true;
                    break;
        }
    }

    public boolean rubberCheck(View view) {
        return ((CheckBox) view).isChecked();
    }

    public void onQuestionFiveRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.no_radio:
                if (checked)
                    rightAnswerFour = false;
                break;
            case R.id.yes_radio:
                if (checked)
                    rightAnswerFour = true;
                break;

        }
    }

    public void calculateResults(View view) {


        score = 0;

        addedPointNumber = pointNumberEditText.getText();
        if (addedPointNumber.toString().equals("11")) {
            score += 1;
        }

        if (repeatServe) {
            score += 1;
        }

        if (rubberCheck(redRubberCheck)&&rubberCheck(blackRubberCheck)&&!rubberCheck(brownRubberCheck)) {
            score += 1;
        }

        addedSetNumber = setNumberEditText.getText();
        if (addedSetNumber.toString().equals("3")) {
            score += 1;
        }

        if (rightAnswerFour) {
            score += 1;
        }

        actualScore = score;
        score = 0;
        displayScore(actualScore);
    }

    public void displayScore(int score) {

        if (score != 1){
            Toast.makeText(getApplicationContext(), "You answered " + score + " questions right!",
                    Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(getApplicationContext(), "You answered " + score + " question right!",
                   Toast.LENGTH_SHORT).show();
        }
    }
}
