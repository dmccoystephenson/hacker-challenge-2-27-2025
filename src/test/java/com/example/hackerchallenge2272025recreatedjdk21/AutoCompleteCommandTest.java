package com.example.hackerchallenge2272025recreatedjdk21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AutoCompleteCommandTest {

    @Test
    void test_autocomplete_promptExample() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "de";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("dog");
        possibleStrings.add("deer");
        possibleStrings.add("deal");

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[deer, deal]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }

    @Test
    void test_autocomplete_noPossibleStrings() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "a";
        List<String> possibleStrings = new ArrayList<>();

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }

    @Test
    void test_autocomplete_queryStringLongerThanPossibleMatch() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "dealio";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("deal");

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }

    @Test
    void test_autocomplete_emptyQueryString() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("dog");
        possibleStrings.add("deer");
        possibleStrings.add("deal");

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }

    @Test
    void test_autocomplete_longWord() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "supercal";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("super");
        possibleStrings.add("supercalifragilisticexpialidocious");
        possibleStrings.add("supper");

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[supercalifragilisticexpialidocious]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }

    @Test
    void test_autocomplete_fullWordMatch() {
        // prepare
        AutoCompleteCommand autoCompleteCommand = new AutoCompleteCommand();
        String queryString = "apple";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("apple");
        possibleStrings.add("apricot");
        possibleStrings.add("apostle");
        possibleStrings.add("banana");

        // execute
        List<String> matchedStrings = autoCompleteCommand.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[apple]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }
}