package com.lucidmachinery.philosophyquotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        QuotesAdapter quotesAdapter = new QuotesAdapter(this, getQuotes());

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

    private ArrayList<Quote> getQuotes () {
        return getDummyQuotes();
    }

    private ArrayList<Quote> getDummyQuotes() {
        Author auth = new Author("Foo", "McBar");
        Author auth2 = new Author("Baz", "Bashington");
        Publication pub = new Publication("Pub 1", "http://google.com", auth);
        Publication pub2 = new Publication("Pub 2", "http://example.com", auth2);
        ArrayList<Quote> quotes = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            quotes.add(new Quote("Text "+i, i % 2 == 0 ? pub : pub2));
        }

        return quotes;
    }
}
