package com.arakelyan.springdemo.classes;

import java.util.LinkedHashMap;

public class NewStudent {

    private String name;
    private String surname;
    private String country;

    private LinkedHashMap<String, String> countryOptions;

    private String favoriteLanguage;

    private String[] operatingSystems;

    public NewStudent() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("AM", "Armenia");
        countryOptions.put("US", "United States");
        countryOptions.put("RU", "Russia");
        countryOptions.put("FR", "France");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}
