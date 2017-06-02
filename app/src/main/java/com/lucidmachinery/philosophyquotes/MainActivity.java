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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

import com.lucidmachinery.philosophyquotes.models.Quote;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Quote> mQuotes = new ArrayList<>();
    private static final int MAX_RESULTS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load layout
        setContentView(R.layout.activity_main);

        // Add toolbar to top
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add quotes data to main content list view
        final QuotesAdapter quotesAdapter = new QuotesAdapter(this, mQuotes);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(quotesAdapter);

        // Query Firebase quotes DB
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date today = cal.getTime();
        String todayStr = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).
                format(today);
        Query quotesQuery = FirebaseDatabase.getInstance()
                .getReference("quotes")
                .orderByChild("date")
                .endAt(todayStr)
                .limitToLast(MAX_RESULTS);

        // Listen for Quotes updates
        ValueEventListener quotesListener = new ValueEventListener() {

            /**
             * Update the list of Quotes in the view when the Firebase quotes change.
             * @param dataSnapshot Changed quote data.
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mQuotes.clear();

                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Quote quote = snap.getValue(Quote.class);
                    mQuotes.add(quote);
                }
                Collections.reverse(mQuotes);

                quotesAdapter.notifyDataSetChanged();
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
        quotesQuery.addValueEventListener(quotesListener);
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
