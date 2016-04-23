package com.example.cmsc436.exampletabs;

/**
 * Created by nouranyounis on 4/22/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class IntroScreen extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Button doneButton = (Button) findViewById(R.id.button2);
        final CheckBox umd = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox db = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox loh = (CheckBox) findViewById(R.id.checkBox3);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(IntroScreen.this,MainActivity.class);
                activity.putExtra("umd",umd.isChecked()+"");
                activity.putExtra("db",db.isChecked()+"");
                activity.putExtra("loh",loh.isChecked()+"");
                startActivity(activity);

            }
        });
    }

}