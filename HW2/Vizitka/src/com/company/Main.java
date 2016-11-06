package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String PATH = "/home/roman/ROMA/JAVA/ProgKievUa/HW2/Vizitka/src/com/company/json.txt";
        Gson gson = new GsonBuilder().create();
        MyJSON myJSON = gson.fromJson(parsRequest(PATH), MyJSON.class);
        System.out.println(myJSON);
    }

    public static String parsRequest(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
