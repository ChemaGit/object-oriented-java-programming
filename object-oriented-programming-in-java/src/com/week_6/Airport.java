package com.week_6;

public class Airport implements Comparable<Airport>{
    private String city;
    private String country;
    private String code3;

    public Airport(String city, String country, String code3){
        setCity(city);
        setCountry(country);
        setCode3(code3);
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city.replaceAll("\"", "");
    }

    public String getCountry() {
        return country;
    }

    private void setCountry(String country) {
        this.country = country.replaceAll("\"", "");
    }

    public String getCode3() {
        return code3;
    }

    private void setCode3(String code3) {
        this.code3 = code3.replaceAll("\"", "");
    }

    @Override
    public String toString() {
        return "Airport{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", code3='" + code3 + '\'' +
                '}';
    }

    @Override
    public int compareTo(Airport airport) {
        return this.getCity().compareTo(airport.getCity());
    }
}
