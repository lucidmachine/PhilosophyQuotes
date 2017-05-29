package com.lucidmachinery.philosophyquotes;

import android.support.annotation.NonNull;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * A quote.
 * @author lucidmachine
 */
@IgnoreExtraProperties
class Quote {
    /** The full body text of the quote. */
    private final @NonNull String text;

    /** The publication from which the quote is taken. */
    private @NonNull Publication publication;

    /**
     * @param text The full body text of the quote.
     * @param publication The publication from which the quote is taken.
     */
    public Quote(@NonNull String text, @NonNull Publication publication) {
        this.text = text;
        this.publication = publication;
    }

    /**
     * @return The full body text of the quote.
     */
    public @NonNull String getText() {
        return text;
    }

    /**
     * @return The Publication from which the quote is taken.
     */
    @NonNull Publication getPublication() {
        return publication;
    }

    /**
     * @param publication The Publication from which the quote is taken.
     */
    public void setPublication(@NonNull Publication publication) {
        this.publication.removeQuote(this);
        this.publication = publication;
        this.publication.addQuote(this);
    }

    /**
     * @return The Quote as a String.
     */
    @Override
    public String toString() {
        return text + " - " + publication.getAuthor().getFirstName() + " "
                + publication.getAuthor().getLastName() + ", " + publication.getTitle() + " ("
                + publication.getLink() + ")";
    }
}
