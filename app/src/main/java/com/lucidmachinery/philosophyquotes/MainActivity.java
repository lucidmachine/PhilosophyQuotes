package com.lucidmachinery.philosophyquotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import com.lucidmachinery.philosophyquotes.models.Quote;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Quote> mQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load layout
        setContentView(R.layout.activity_main);

        // Add toolbar to top
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add quotes data to main content list view
        QuotesAdapter quotesAdapter = new QuotesAdapter(this, mQuotes);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(quotesAdapter);

        // Add Firebase quotes DB listener and event handlers
        DatabaseReference quotesReference = FirebaseDatabase.getInstance().getReference("quotes");
        ValueEventListener quotesListener = new ValueEventListener() {

            /**
             * Update the list of Quotes in the view when the Firebase quotes change.
             * @param dataSnapshot Changed quote data.
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Quote quote = snap.getValue(Quote.class);
                    mQuotes.add(quote);
                }
            }

            /**
             * Log Firebase DB error.
             * @param databaseError Firebase DB error.
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("AppCompatActivity", "loadQuote:onCancelled", databaseError.toException());
            }
        };
        quotesReference.addValueEventListener(quotesListener);
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
