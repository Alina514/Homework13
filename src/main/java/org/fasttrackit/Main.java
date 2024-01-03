package org.fasttrackit;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file", "quote(2).txt"));
        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        Quote quote1 = new Quote(2, "Buddha", "Work out your own salvation.Do not depend on others",false);
        System.out.println("ID: " + quote1.getId());
        System.out.println("Author: " + quote1.getAuthor());
        System.out.println("Quote: " + quote1.getQuote());
        System.out.println("This is the favourite? " + quote1.getFavourite());
//getAllQuote
        List<Quote> quoteList = new ArrayList<>();
        quoteList.add(new Quote(1, "Napoleon Hill", "First ", false));
        quoteList.add(new Quote(2, "Tony Robbinson", "Second ", true));
        quoteList.add(new Quote(3, "Larry Elder", "Third ", true));

        QuoteServices quoteService = new QuoteServices(quoteList);
        List<String> allQuotes = quoteService.getAllQuotes();
        for (String quote : allQuotes) {
            System.out.println(quote);
        }

 //getAllAuthors
        String targetAuthor = "Buddha";
        List<Quote> authorQuotes = quoteService.getQuotesForAuthor(targetAuthor);
        System.out.println("Quotes for Author " + targetAuthor + ": He who experiences the unity of life sees his own Self");
        for (Quote quote : authorQuotes) {
            System.out.println(quote.getQuote());
        }

 //getAuthors
        List<String> distinctAuthors = quoteService.getAuthors();
        System.out.println("Distinct Authors:");
        for (String author : distinctAuthors) {
            System.out.println(author);
        }

 //setfavourite
        int targetId = 2;
        boolean newFavouriteStatus = true;
        quoteService.setFavourite(targetId, newFavouriteStatus);

        System.out.println("Updated Quotes:");
        for (Quote quote : quoteList) {
            System.out.println(quote);
        }

//getfavourite
        List<Quote> favouriteQuotes = quoteService.getFavourites();
        System.out.println("Favorite Quotes: Buddha");
        for (Quote quote : favouriteQuotes) {
            System.out.println(quote);
        }

 //random
        String randomQuote = quoteService.getRandomQuote();
        System.out.println("Random Quote:");
        System.out.println(randomQuote);
    }
}
