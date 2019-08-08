package gareth.andrews.memorybuster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);
    }

    public void onClick(View view){
        Intent i = new Intent(LoserActivity.this, MainActivity.class);
        startActivity(i);
    }
}
