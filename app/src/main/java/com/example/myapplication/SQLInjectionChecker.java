package com.example.myapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLInjectionChecker {

    public static boolean hasSQLInjection(String input) {
        // Regular expression pattern to match potential SQL injection
        String sqlPattern = "(?i)\\b(SELECT|INSERT|UPDATE|DELETE|DROP|UNION|TRUNCATE|AND|OR|WHERE|GROUP BY|ORDER BY|JOIN|\\s+)\\b.*[;]+.*";

        Pattern pattern = Pattern.compile(sqlPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String userInput = "Some input"; // Replace this with your actual user input

        if (hasSQLInjection(userInput)) {
            System.out.println("Input contains potential SQL injection!");
            // Handle the case where SQL injection is detected
        } else {
            System.out.println("Input is safe from SQL injection.");
            // Proceed with using the input in your application
        }
    }
}

