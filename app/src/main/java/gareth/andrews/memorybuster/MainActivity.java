package gareth.andrews.memorybuster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    private Button buttonFirst = null;
    private Button buttonSecond = null;
    private TextView textViewRemainingTurns = null;
    private int score = 0;
    private int remainingTurns = 35;
    //private final String remaining = getResources().getString(R.string.main_turns_left);
    private final String remaining = "Turns Left: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewRemainingTurns = findViewById(R.id.textViewRemainingTurns);
        textViewRemainingTurns.setText(remaining + remainingTurns);
        setUpButtons();
    }

    private void setUpButtons(){
        int min = 1; //inclusive
        int max = 24; //inclusive
        Random random = new Random();
        ArrayList<Integer> usedButtons = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            int num = random.nextInt(max - min + 1) + min;
            while(usedButtons.contains(num))
                num = random.nextInt(max - min + 1) + min;
            Button button1 = findViewById(getResources().getIdentifier("button" + num, "id", this.getPackageName()));
            usedButtons.add(num);
            while(usedButtons.contains(num))
                num = random.nextInt(max - min + 1) + min;
            Button button2 = findViewById(getResources().getIdentifier("button" + num, "id", this.getPackageName()));
            usedButtons.add(num);
            button1.setText(i+"");
            button1.setTextSize(0);
            button2.setText(i+"");
            button2.setTextSize(0);
        }
    }

    public void onClick(View view){
        Button buttonClicked = (Button)view;
        if(buttonFirst == null){
            buttonFirst = buttonClicked;
            buttonFirst.setTextSize(18); //ToDo make size relative to screen
            buttonFirst.setClickable(false);
        } else if(buttonSecond == null){
            buttonSecond = buttonClicked;
            buttonSecond.setTextSize(18); //ToDo make size relative to screen
            //I do not set second button to be unclickable, since instructions will require the player
            //to click a third button to check the score.
        } else{
            remainingTurns--;
            if(remainingTurns == -1){
                Intent i = new Intent(MainActivity.this, LoserActivity.class);
                startActivity(i);
            } else if(buttonFirst.getText().equals(buttonSecond.getText())){
                score++;
                if(score >= 12){
                    Intent i = new Intent(MainActivity.this, WinnerActivity.class);
                    startActivity(i);
                }
                buttonFirst.setText("["+buttonFirst.getText()+"]");
                buttonSecond.setText("["+buttonSecond.getText()+"]");
                buttonSecond.setClickable(false);
            } else{
                buttonFirst.setTextSize(0);
                buttonFirst.setClickable(true);
                buttonSecond.setTextSize(0);
            }
            textViewRemainingTurns.setText(remaining + remainingTurns);
            buttonFirst = null;
            buttonSecond = null;
        }
    }
}
