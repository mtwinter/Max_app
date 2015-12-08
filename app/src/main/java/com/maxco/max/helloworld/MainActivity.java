package com.maxco.max.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    static TextView t;

    public static int points = 0;
    //points = 0;
    public static int autoPoints = 0;
   //autoPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t = (TextView)findViewById(R.id.t);

        final Button click = (Button) findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View increase) {
                // Perform action on click
            }
        });

        final Button autoclick = (Button) findViewById(R.id.autoclick);
        autoclick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View increaseAuto) {
                // Perform action on click
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onclick (View increase){
        points++;
        String p =Integer.toString(points);
        t.setText("Clicks : " + p);
    }




}
