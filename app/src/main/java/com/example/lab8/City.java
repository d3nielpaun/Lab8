package com.example.lab8;

import java.util.Objects;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * This checks if this City is equal to another object (same city and province)
     *
     * @param o The object to compare
     *
     * @return Boolean if this City is equal to the parameter
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City otherCity = (City) o;
        return city.equals(otherCity.city) &&
                province.equals(otherCity.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
