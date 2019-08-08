package gareth.andrews.memorybuster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WinnerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
    }

    public void onClick(View view){
        Intent i = new Intent(WinnerActivity.this, MainActivity.class);
        startActivity(i);
    }
}
