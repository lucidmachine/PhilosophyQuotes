package com.lucidmachinery.philosophyquotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Author auth = new Author("Foo", "McBar");
        Publication pub = new Publication("Pub 1", "http://google.com", auth);
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Text 1", pub));
        quotes.add(new Quote("Text 2", pub));
        quotes.add(new Quote("Text 3", pub));

        QuotesAdapter quotesAdapter = new QuotesAdapter(this, quotes);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(quotesAdapter);
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
}
