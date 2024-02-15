package org.fasttrackit;

import jdk.jfr.DataAmount;

@DataAmount

public class Quote {
    private final int id;
    private final String author;
    private final String quote;
    private Boolean favourite;

    public Quote(int id, String author, String quote, boolean favourite) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.favourite = favourite;

    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    @Override
    public String toString() {
        return "Quote " +  "id " + id + ", author " + author  + ", quote " + quote + " favourite " + favourite;
    }

    public void setFavourite(boolean favourite) {

    }

    public boolean isFavourite() {
        return false;
    }
}
