package com.example.cmsc436.exampletabs;

/**
 * Created by nouranyounis on 4/22/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class IntroScreen extends Activity {

    CheckBox umd;
    CheckBox db ;
    CheckBox loh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button doneButton = (Button) findViewById(R.id.button2);
        umd = (CheckBox) findViewById(R.id.checkBox);
        db = (CheckBox) findViewById(R.id.checkBox2);
        loh =(CheckBox) findViewById(R.id.checkBox3);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(IntroScreen.this,MainActivity.class);
                activity.putExtra("umd",umd.isChecked() +"");
                activity.putExtra("db",db.isChecked()+"");
                activity.putExtra("loh",loh.isChecked()+"");
                startActivityForResult(activity, 1);
                Log.i("TTWEET", "this worked");
            }
        });
    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data.getStringExtra("loh").equals("true"))
            loh.setChecked(true);
        if(data.getStringExtra("umd").equals("true"))
            umd.setChecked(true);
        if(data.getStringExtra("db").equals("true"))
            db.setChecked(true);
    }

}