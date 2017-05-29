package com.lucidmachinery.philosophyquotes.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Publication {
    public String authorName;
    public String link;
    public String title;

    Publication () {}

    Publication (String authorName, String link, String title) {
        this.authorName = authorName;
        this.link = link;
        this.title = title;
    }
}
