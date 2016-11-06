package com.company;

/**
 * Created by roman on 30.10.16.
 */
public class Adres {
    private String country;
    private String city;
    private String street;

    @Override
    public String toString() {
        return "Adres{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
