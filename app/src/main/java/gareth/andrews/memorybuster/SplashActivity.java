package gareth.andrews.memorybuster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void onClick(View view){
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
    }
}
