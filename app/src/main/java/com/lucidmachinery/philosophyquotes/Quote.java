package com.lucidmachinery.philosophyquotes;

/**
 * A quote.
 * @author lucidmachine
 */
public class Quote {
    /** The full body text of the quote. */
    private String text;

    /** The publication from which the quote is taken. */
    private Publication publication;

    /**
     * @param text The full body text of the quote.
     * @param publication The publication from which the quote is taken.
     */
    public Quote(String text, Publication publication) {
        this.text = text;
        this.publication = publication;
    }

    /**
     * @return The full body text of the quote.
     */
    public String getText() {
        return text;
    }

    /**
     * @return The Publication from which the quote is taken.
     */
    public Publication getPublication() {
        return publication;
    }

    /**
     * @param publication The Publication from which the quote is taken.
     */
    public void setPublication(Publication publication) {
        if (this.publication != null) {
            this.publication.removeQuote(this);
        }
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
