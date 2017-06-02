package com.lucidmachinery.philosophyquotes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.lucidmachinery.philosophyquotes.models.Quote;

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
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quote, parent, false);
        }
        final View finalConvertView = convertView;

        // Get child views
        TextView tvQuoteAuthor = (TextView) convertView.findViewById(R.id.quote_author);
        TextView tvQuoteText = (TextView) convertView.findViewById(R.id.quote_text);
        ImageView publicationButtonView = (ImageView) convertView.findViewById(R.id.source_button);

        // Get data
        final Quote quote = getItem(position);

        // Put data in view
        tvQuoteAuthor.setText(quote != null ? quote.authorName != null ? quote.authorName: "" : "");
        tvQuoteText.setText(quote != null ? quote.text != null ? quote.text : "" : "");
        publicationButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quote != null
                        && quote.publicationLink != null
                        && !quote.publicationLink.isEmpty()) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(quote.publicationLink));
                    finalConvertView.getContext().startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
