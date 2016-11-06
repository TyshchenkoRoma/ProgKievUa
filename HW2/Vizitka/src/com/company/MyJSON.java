package com.company;

import java.util.ArrayList;

/**
 * Created by roman on 30.10.16.
 */
public class MyJSON {
    private String name;
    private String surname;
    private ArrayList<String> phones;
    private ArrayList<String> sites;
    private Adres address;

    @Override
    public String toString() {
        return "MyJSON{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + phones +
                ", sites=" + sites +
                ", address=" + address +
                '}';
    }
}
