package com.lucidmachinery.philosophyquotes;

import java.util.ArrayList;
import java.util.List;

/**
 * The author of a publication.
 * @author lucidmachine
 */
class Author {
    /** The first name of the author. */
    private final String firstName;

    /** The last name of the author. */
    private final String lastName;

    /** A list of publications published by the author. */
    private List<Publication> publications;

    /**
     * @param firstName The first name of the author.
     * @param lastName The last name of the author.
     */
    Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.publications = new ArrayList<>();
    }

    /**
     * @return The first name of the author.
     */
    String getFirstName() {
        return firstName;
    }

    /**
     * @return The last name of the author.
     */
    String getLastName() {
        return lastName;
    }

    /**
     * @return A list of publications published by the author.
     */
    public List<Publication> getPublications() {
        return this.publications;
    }

    /**
     * Adds a publication to the list of publications published by the author.
     * @param publication A publication published by the author.
     */
    void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    /**
     * Removes a publication from the list of publications published by the author.
     * @param publication A publication not published by the author.
     */
    void removePublication(Publication publication) {
        this.publications.remove(publication);
    }

    /**
     * @return The Author as a String.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
