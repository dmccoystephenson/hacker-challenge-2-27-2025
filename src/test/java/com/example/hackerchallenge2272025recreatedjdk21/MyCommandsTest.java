package com.example.hackerchallenge2272025recreatedjdk21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MyCommandsTest {

    @Test
    void autocomplete_promptExample() {
        // prepare
        MyCommands myCommands = new MyCommands();
        String queryString = "de";
        List<String> possibleStrings = new ArrayList<>();
        possibleStrings.add("dog");
        possibleStrings.add("deer");
        possibleStrings.add("deal");

        // execute
        List<String> matchedStrings = myCommands.autocomplete(queryString, possibleStrings);

        // verify
        String expectedMatchedStrings = "[deer, deal]";
        assertEquals(expectedMatchedStrings, matchedStrings.toString());
    }
}