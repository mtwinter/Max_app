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
import android.os.AsyncTask;

public class MainActivity extends AppCompatActivity {
    static TextView t;
    static Button autoclick;
    public static boolean threadEnabled = false;



    public static double points = 0;
    //points = 0;
    public static int autoPoints = 0;
    //autoPoints = 0;
    public static double price = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t = (TextView) findViewById(R.id.t);
        autoclick = (Button) findViewById(R.id.autobutton);


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

    public void onclick(View increase) {
        points++;
        String p = Double.toString(points);
        t.setText("Clicks : " + p);
    }

    public void AutoBuy(View view) {
        if (points >= price) {
            points = points - price;
            autoPoints++;
            price = price * 1.1;
            autoclick.setText("+1/SEC COST:" + Double.toString(price));
            String p = Double.toString(points);
            t.setText("Clicks : " + p);
        }
        if (threadEnabled == false) {
            tick.start();
            threadEnabled = true;
        }
    }

    Thread tick = new Thread() {
        @Override
        public void run() {
            while (true) {
                points = points + autoPoints;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String p = Double.toString(points);
                        t.setText("Clicks : " + p);
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

        ;

    };
}
