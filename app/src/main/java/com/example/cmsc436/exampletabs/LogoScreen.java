package com.example.cmsc436.exampletabs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class LogoScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_intro);
        TextView tx = (TextView)findViewById(R.id.logoText);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/UATerrafont.ttf");
        tx.setTypeface(custom_font);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent in = new Intent(LogoScreen.this, IntroScreen.class);
                LogoScreen.this.startActivity(in);
                LogoScreen.this.finish();
            }
        }, 3000);
    }
}
