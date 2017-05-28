package com.lucidmachinery.philosophyquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter to place Quote data into a View.
 */
class QuotesAdapter extends ArrayAdapter<Quote> {
    /**
     * @param context The current context.
     * @param quotes A list of quotes to be placed into the View.
     */
    QuotesAdapter(Context context, ArrayList<Quote> quotes) {
        super(context, 0, quotes);
    }

    /**
     * Gets a View into which the Quote data has been loaded.
     * @param position Index of the Quote to be loaded into the View in the Quotes array.
     * @param convertView The View into which we are to load the Quote.
     * @param parent ViewGroup to which the View into which we are loading Quote data shall be attached.
     * @return The View into which we loaded the Quote.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quote, parent, false);
        }
        TextView tvQuoteAuthor = (TextView) convertView.findViewById(R.id.quote_author);
        TextView tvQuoteText = (TextView) convertView.findViewById(R.id.quote_text);

        // Get data
        Quote quote = getItem(position);

        // Put data in view
        tvQuoteAuthor.setText(quote.getPublication().getAuthor().toString());
        tvQuoteText.setText(quote.getText());

        return convertView;
    }
}
