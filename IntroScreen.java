package com.example.cmsc436.exampletabs;

/**
 * Created by nouranyounis on 4/22/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class IntroScreen extends Activity {

    CheckBox umd,db,loh,dots,umdcs,umpd,terrapins,libraries,see,green,bsos,stamp,grad,sga,health,reslife,ece,recwell,financial,intramural,
            compsci,smith,hungry,clark,senate,weather;

    SharedPreferences sharedPref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        sharedPref = getPreferences(Context.MODE_PRIVATE);

        Button doneButton = (Button) findViewById(R.id.button2);
        umd = (CheckBox) findViewById(R.id.checkBox);
        umd.setChecked(sharedPref.getBoolean("umd", false));
        db = (CheckBox) findViewById(R.id.checkBox2);
        db.setChecked(sharedPref.getBoolean("db",false));
        loh =(CheckBox) findViewById(R.id.checkBox3);
        loh.setChecked(sharedPref.getBoolean("loh",false));
        dots = (CheckBox) findViewById(R.id.checkBox4);
        dots.setChecked(sharedPref.getBoolean("dots",false));
        umdcs = (CheckBox) findViewById(R.id.checkBox5);
        umdcs.setChecked(sharedPref.getBoolean("umdcs",false));
        umpd =(CheckBox) findViewById(R.id.checkBox7);
        umpd.setChecked(sharedPref.getBoolean("umpd",false));
        terrapins = (CheckBox) findViewById(R.id.checkBox8); 
        terrapins.setChecked(sharedPref.getBoolean("terrapins",false));
        libraries = (CheckBox) findViewById(R.id.checkBox9);
        libraries.setChecked(sharedPref.getBoolean("libraries",false));
        see =(CheckBox) findViewById(R.id.checkBox10);
        see.setChecked(sharedPref.getBoolean("see",false));
        green = (CheckBox) findViewById(R.id.checkBox11);
        green.setChecked(sharedPref.getBoolean("green",false));
        bsos = (CheckBox) findViewById(R.id.checkBox12);
        bsos.setChecked(sharedPref.getBoolean("bsos",false));
        stamp =(CheckBox) findViewById(R.id.checkBox13);
        stamp.setChecked(sharedPref.getBoolean("stamp",false));
        grad = (CheckBox) findViewById(R.id.checkBox14);
        grad.setChecked(sharedPref.getBoolean("grad",false));
        sga = (CheckBox) findViewById(R.id.checkBox15);
        sga.setChecked(sharedPref.getBoolean("sga",false));
        health =(CheckBox) findViewById(R.id.checkBox16);
        health.setChecked(sharedPref.getBoolean("health",false));
        reslife = (CheckBox) findViewById(R.id.checkBox17);
        reslife.setChecked(sharedPref.getBoolean("reslife",false));
        ece = (CheckBox) findViewById(R.id.checkBox18);
        ece.setChecked(sharedPref.getBoolean("ece",false));
        recwell =(CheckBox) findViewById(R.id.checkBox19);
        recwell.setChecked(sharedPref.getBoolean("recwell",false));
        financial = (CheckBox) findViewById(R.id.checkBox20);
        financial.setChecked(sharedPref.getBoolean("financial",false));
        intramural = (CheckBox) findViewById(R.id.checkBox21);
        intramural.setChecked(sharedPref.getBoolean("intramural",false));
        compsci =(CheckBox) findViewById(R.id.checkBox22);
        compsci.setChecked(sharedPref.getBoolean("compsci",false));
        smith = (CheckBox) findViewById(R.id.checkBox23);
        smith.setChecked(sharedPref.getBoolean("smith",false));
        hungry = (CheckBox) findViewById(R.id.checkBox24);
        hungry.setChecked(sharedPref.getBoolean("hungry",false));
        clark =(CheckBox) findViewById(R.id.checkBox25);
        clark.setChecked(sharedPref.getBoolean("clark",false));
        senate = (CheckBox) findViewById(R.id.checkBox26);
        senate.setChecked(sharedPref.getBoolean("senate",false));
        weather = (CheckBox) findViewById(R.id.checkBox27);
        weather.setChecked(sharedPref.getBoolean("weather",false));

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(IntroScreen.this,MainActivity.class);
                SharedPreferences.Editor editor = sharedPref.edit();
                activity.putExtra("umd",umd.isChecked() +"");
                editor.putBoolean("umd", umd.isChecked());
                activity.putExtra("db", db.isChecked() + "");
                editor.putBoolean("db", db.isChecked());
                activity.putExtra("loh", loh.isChecked() + "");
                editor.putBoolean("loh", loh.isChecked());
                activity.putExtra("dots", dots.isChecked() + "");
                editor.putBoolean("dots", dots.isChecked());
                activity.putExtra("umdcs", umdcs.isChecked() + "");
                editor.putBoolean("umdcs", umdcs.isChecked());
                activity.putExtra("umpd", umpd.isChecked() + "");
                editor.putBoolean("umpd", umpd.isChecked());
                activity.putExtra("terrapins", terrapins.isChecked() + "");
                editor.putBoolean("terrapins", terrapins.isChecked());
                activity.putExtra("libraries", libraries.isChecked() + "");
                editor.putBoolean("libraries", libraries.isChecked());
                activity.putExtra("see", see.isChecked() + "");
                editor.putBoolean("see", see.isChecked());
                activity.putExtra("green", green.isChecked() + "");
                editor.putBoolean("green", green.isChecked());
                activity.putExtra("bsos", bsos.isChecked() + "");
                editor.putBoolean("bsos", bsos.isChecked());
                activity.putExtra("stamp", stamp.isChecked() + "");
                editor.putBoolean("stamp", stamp.isChecked());
                activity.putExtra("grad", grad.isChecked() + "");
                editor.putBoolean("grad", grad.isChecked());
                activity.putExtra("sga", sga.isChecked() + "");
                editor.putBoolean("sga", sga.isChecked());
                activity.putExtra("health", health.isChecked() + "");
                editor.putBoolean("health", health.isChecked());
                activity.putExtra("reslife", reslife.isChecked() + "");
                editor.putBoolean("reslife", reslife.isChecked());
                activity.putExtra("ece", ece.isChecked() + "");
                editor.putBoolean("ece", ece.isChecked());
                activity.putExtra("recwell", recwell.isChecked() + "");
                editor.putBoolean("recwell", recwell.isChecked());
                activity.putExtra("financial", financial.isChecked() + "");
                editor.putBoolean("financial", financial.isChecked());
                activity.putExtra("intramural", intramural.isChecked() + "");
                editor.putBoolean("intramural", intramural.isChecked());
                activity.putExtra("compsci", compsci.isChecked() + "");
                editor.putBoolean("compsci", compsci.isChecked());
                activity.putExtra("smith", smith.isChecked() + "");
                editor.putBoolean("smith", smith.isChecked());
                activity.putExtra("hungry", hungry.isChecked() + "");
                editor.putBoolean("hungry", hungry.isChecked());
                activity.putExtra("clark", clark.isChecked() + "");
                editor.putBoolean("clark", clark.isChecked());
                activity.putExtra("senate", senate.isChecked() + "");
                editor.putBoolean("senate", senate.isChecked());
                activity.putExtra("weather", weather.isChecked() + "");
                editor.putBoolean("weather", weather.isChecked());
                editor.commit();
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