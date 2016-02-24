package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private Library library;

    @Before
    public void setup(){
        this.books = new ArrayList<>();
        this.printStream = mock(PrintStream.class);
        this.dateTimeFormatter = mock(DateTimeFormatter.class);
        this.library = new Library(books, printStream, dateTimeFormatter);
    }


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        library.listBooks();
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String title1 = "title1";
        String title2 = "title2";
        books.add(title1);
        books.add(title2);
        library.listBooks();
        verify(printStream).println("title1");
        verify(printStream).println("title2");
    }

 
    @Test
    public void shouldWelcomeUser() {
        DateTime time = new DateTime();
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("");
        library.welcome(time);
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("2016-02-24T01:29:28.874-05:00");
        library.welcome(time);
        verify(printStream).println("Welcome to the library! The current time is 2016-02-24T01:29:28.874-05:00");

    }
}