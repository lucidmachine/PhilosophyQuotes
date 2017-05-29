package com.lucidmachinery.philosophyquotes.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Quote {
    public String authorName;
    public String publicationLink;
    public String publicationTitle;
    public String text;

    public Quote () {}

    public Quote (String authorName, String publicationLink, String publicationTitle, String text) {
        this.authorName = authorName;
        this.publicationLink = publicationLink;
        this.publicationTitle = publicationTitle;
        this.text = text;
    }
}
