package com.example.hackerchallenge2272025recreatedjdk21;

import java.util.ArrayList;
import java.util.List;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class AutoCompleteCommand {

    /**
     * Given a query string and a set of all possible query strngs, return all strings in the set that have the query strng as a prefix.
     * @param queryString The query string
     * @param possibleStrings The set of all possible query strings
     * @return All strings in the set that have the query string as a prefix
     */
    @ShellMethod("Autocomplete given a query string and a set of all possible query strings.")
    public List<String> autocomplete(String queryString, List<String> possibleStrings) {
        List<String> matchedStrings = new ArrayList<>();
        for (String possibleString : possibleStrings) {
            if (!possibleString.contains(queryString)) {
                // not a match, possibleString must contain queryString
                continue;
            }
            if (isPrefix(queryString, possibleString)) {
                matchedStrings.add(possibleString);
            }
        }
        return matchedStrings;
    }

    private boolean isPrefix(String possiblePrefix, String targetString) {
        for (int i = 0; i < possiblePrefix.length(); i++) {
            char queryStringChar = possiblePrefix.charAt(i);
            char possibleStringChar = targetString.charAt(i);
            if (queryStringChar != possibleStringChar) {
                // not a match, character discrepancy detected
                break;
            }
            if (i == possiblePrefix.length() - 1) {
                // end of query string reached, match detected
                return true;
            }
        }
        return false;
    }
}
