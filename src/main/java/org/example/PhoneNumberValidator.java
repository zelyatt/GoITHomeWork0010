package org.example;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static void main(String[] args) {
        String filePath = "fileTest.txt";
        validatePhoneNumbers(filePath);
    }

    private static void validatePhoneNumbers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                validateAndPrintPhoneNumber(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateAndPrintPhoneNumber(String phoneNumber) {
        String regex = "\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println(phoneNumber);
        }
    }
}

