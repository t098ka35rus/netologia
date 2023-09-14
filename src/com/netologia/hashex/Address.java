package com.netologia.hashex;

import java.util.Objects;

public class Address {
    protected String country;
    protected String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public boolean equals(Object obj) {
        Address o = (Address) obj;
        return country.equals(o.country) && city.equals(o.city);
    }
}
