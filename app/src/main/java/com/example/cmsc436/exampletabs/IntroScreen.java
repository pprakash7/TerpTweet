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

    CheckBox umd,db,loh,dots,umdcs,umpd,terrapins,libraries,see,green,bsos,stamp,grad,sga,health,reslife,ece,recwell,financial,intramural,
            compsci,smith,hungry,clark,senate,weather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button doneButton = (Button) findViewById(R.id.button2);
        umd = (CheckBox) findViewById(R.id.checkBox);
        db = (CheckBox) findViewById(R.id.checkBox2);
        loh =(CheckBox) findViewById(R.id.checkBox3);
        dots = (CheckBox) findViewById(R.id.checkBox4);
        umdcs = (CheckBox) findViewById(R.id.checkBox5);
        umpd =(CheckBox) findViewById(R.id.checkBox7);
        terrapins = (CheckBox) findViewById(R.id.checkBox8);
        libraries = (CheckBox) findViewById(R.id.checkBox9);
        see =(CheckBox) findViewById(R.id.checkBox10);
        green = (CheckBox) findViewById(R.id.checkBox11);
        bsos = (CheckBox) findViewById(R.id.checkBox12);
        stamp =(CheckBox) findViewById(R.id.checkBox13);
        grad = (CheckBox) findViewById(R.id.checkBox14);
        sga = (CheckBox) findViewById(R.id.checkBox15);
        health =(CheckBox) findViewById(R.id.checkBox16);
        reslife = (CheckBox) findViewById(R.id.checkBox17);
        ece = (CheckBox) findViewById(R.id.checkBox18);
        recwell =(CheckBox) findViewById(R.id.checkBox19);
        financial = (CheckBox) findViewById(R.id.checkBox20);
        intramural = (CheckBox) findViewById(R.id.checkBox21);
        compsci =(CheckBox) findViewById(R.id.checkBox22);
        smith = (CheckBox) findViewById(R.id.checkBox23);
        hungry = (CheckBox) findViewById(R.id.checkBox24);
        clark =(CheckBox) findViewById(R.id.checkBox25);
        senate = (CheckBox) findViewById(R.id.checkBox26);
        weather = (CheckBox) findViewById(R.id.checkBox27);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(IntroScreen.this,MainActivity.class);
                activity.putExtra("umd",umd.isChecked() +"");
                activity.putExtra("db",db.isChecked()+"");
                activity.putExtra("loh",loh.isChecked()+"");
                activity.putExtra("dots",dots.isChecked() +"");
                activity.putExtra("umdcs",umdcs.isChecked() +"");
                activity.putExtra("umpd",umpd.isChecked() +"");
                activity.putExtra("terrapins",terrapins.isChecked() +"");
                activity.putExtra("libraries",libraries.isChecked() +"");
                activity.putExtra("see",see.isChecked() +"");
                activity.putExtra("green",green.isChecked() +"");
                activity.putExtra("bsos",bsos.isChecked() +"");
                activity.putExtra("stamp",stamp.isChecked() +"");
                activity.putExtra("grad",grad.isChecked() +"");
                activity.putExtra("sga",sga.isChecked() +"");
                activity.putExtra("health",health.isChecked() +"");
                activity.putExtra("reslife",reslife.isChecked() +"");
                activity.putExtra("ece",ece.isChecked() +"");
                activity.putExtra("recwell",recwell.isChecked() +"");
                activity.putExtra("financial",financial.isChecked() +"");
                activity.putExtra("intramural",intramural.isChecked() +"");
                activity.putExtra("compsci",compsci.isChecked() +"");
                activity.putExtra("smith",smith.isChecked() +"");
                activity.putExtra("hungry",hungry.isChecked() +"");
                activity.putExtra("clark",clark.isChecked() +"");
                activity.putExtra("senate",senate.isChecked() +"");
                activity.putExtra("weather",weather.isChecked() +"");
                startActivityForResult(activity, 1);
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
        if(data.getStringExtra("dots").equals("true"))
            dots.setChecked(true);
        if(data.getStringExtra("umdcs").equals("true"))
            umdcs.setChecked(true);
        if(data.getStringExtra("umpd").equals("true"))
            umpd.setChecked(true);
        if(data.getStringExtra("terrapins").equals("true"))
            terrapins.setChecked(true);
        if(data.getStringExtra("libraries").equals("true"))
            libraries.setChecked(true);
        if(data.getStringExtra("see").equals("true"))
            see.setChecked(true);
        if(data.getStringExtra("green").equals("true"))
            green.setChecked(true);
        if(data.getStringExtra("bsos").equals("true"))
            bsos.setChecked(true);
        if(data.getStringExtra("stamp").equals("true"))
            stamp.setChecked(true);
        if(data.getStringExtra("grad").equals("true"))
            grad.setChecked(true);
        if(data.getStringExtra("sga").equals("true"))
            sga.setChecked(true);
        if(data.getStringExtra("health").equals("true"))
            health.setChecked(true);
        if(data.getStringExtra("reslife").equals("true"))
            reslife.setChecked(true);
        if(data.getStringExtra("ece").equals("true"))
            ece.setChecked(true);
        if(data.getStringExtra("recwell").equals("true"))
            recwell.setChecked(true);
        if(data.getStringExtra("financial").equals("true"))
            financial.setChecked(true);
        if(data.getStringExtra("intramural").equals("true"))
            intramural.setChecked(true);
        if(data.getStringExtra("compsci").equals("true"))
            compsci.setChecked(true);
        if(data.getStringExtra("smith").equals("true"))
            smith.setChecked(true);
        if(data.getStringExtra("hungry").equals("true"))
            hungry.setChecked(true);
        if(data.getStringExtra("clark").equals("true"))
            clark.setChecked(true);
        if(data.getStringExtra("senate").equals("true"))
            senate.setChecked(true);
        if(data.getStringExtra("weather").equals("true"))
            weather.setChecked(true);

    }

}