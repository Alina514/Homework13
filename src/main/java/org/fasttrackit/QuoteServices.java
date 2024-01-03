package org.fasttrackit;

import java.util.*;

public class QuoteServices {
    private final List<Quote> quotes;
    private Random random;

    public QuoteServices(List<Quote> quotes) {
        this.quotes = quotes;
        this.random = new Random();
    }
    public List<String> getAllQuotes() {
        List<String> allQuotes = new ArrayList<>();
        for (Quote quote : quotes) {
            allQuotes.add(quote.getQuote());
        }
        return allQuotes;
    }
    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> authorQuotes = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getAuthor().equals(author)) {
                authorQuotes.add(quote);
            }
        }
        return authorQuotes;
    }

    public List<String> getAuthors() {
        Set<String> uniqueAuthors = new HashSet<>();
        for (Quote quote : quotes) {
            uniqueAuthors.add(quote.getAuthor());
        }
        return new ArrayList<>(uniqueAuthors);
    }
    public void setFavourite(int id, boolean favourite) {
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavourite(favourite);
                return;
            }
        }
    }
    public List<Quote> getFavourites() {
        List<Quote> favouriteQuotes = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.isFavourite()) {
                favouriteQuotes.add(quote);
            }
        }
        return favouriteQuotes;
    }
    public String getRandomQuote() {
        if (quotes.isEmpty()) {
            return "No quotes available.";
        }
        int randomIndex = random.nextInt(quotes.size());
        Quote randomQuote = quotes.get(randomIndex);
        return randomQuote.toString();
    }
}
