package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> userList = readUsersFromFile("file.txt");
        writeUsersToJsonFile(userList, "user.json");
    }

    private static List<User> readUsersFromFile(String fileName) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                userList.add(new User(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    private static void writeUsersToJsonFile(List<User> userList, String jsonFileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper().enableDefaultTyping();
            String jsonString = objectMapper.writeValueAsString(userList);
            FileWriter writer = new FileWriter(jsonFileName);
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
