package com.lucidmachinery.philosophyquotes;

import java.util.ArrayList;
import java.util.List;

/**
 * A publication in which a quote appears.
 * @author lucidmachine
 */
class Publication {
    /** The title of the publication. */
    private final String title;

    /** The affiliate link to the publication. */
    private final String link;

    /** The author of the publication. */
    private Author author;

    /** A list of quotes in this publication. */
    private List<Quote> quotes;


    /**
     * @param title The title of the publication.
     * @param link The affiliate link to the publication.
     * @param author The author of the publication.
     */
    Publication(String title, String link, Author author) {
        this.title = title;
        this.link = link;
        this.author = author;
        this.quotes = new ArrayList<>();
    }

    /**
     * @return link The affiliate link to the publication.
     */
    String getLink() {
        return link;
    }

    /**
     * @return The title of the publication.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The author of the publication.
     */
    Author getAuthor() {
        return this.author;
    }

    /**
     * @param author The author of the publication.
     */
    public void setAuthor(Author author) {
        if (this.author != null) {
            this.author.removePublication(this);
        }
        this.author = author;
        this.author.addPublication(this);
    }

    /**
     * @return A list of quotes in this publication.
     */
    public List<Quote> getQuotes() {
        return this.quotes;
    }

    /**
     * @param quote A quote to be added to the list of quotes in this publication.
     */
    void addQuote(Quote quote) {
        this.quotes.add(quote);
    }

    /**
     * @param quote A quote to be removed from the list of quotes in this publication.
     */
    void removeQuote(Quote quote) {
        this.quotes.remove(quote);
    }

    /**
     * @return The Publication as a String.
     */
    @Override
    public String toString() {
        return title + " (" + link + ")";
    }
}
