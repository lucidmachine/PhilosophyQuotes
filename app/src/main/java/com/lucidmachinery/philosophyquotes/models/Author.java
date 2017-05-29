package com.lucidmachinery.philosophyquotes.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Author {
    public String firstName;
    public String lastName;
    public String name;

    Author () {}

    Author (String firstName, String lastName, String name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
    }
}
