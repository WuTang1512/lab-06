package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist,
     * otherwise it throws an Exception
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns whether or not a city exists in the list
     * @param city
     *      This is the city to check for
     * @return
     *      Returns True if the city exists, otherwise False
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes specified city from the list if it exists
     * @param city
     *      This is the city to be deleted
     *      Throws an exception if the city does not exist
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("This city does not exist in the list");
        }
            cities.remove(city);
    }

    /**
     * This counts the number of cities in the list
     * @param list
     *      This is the CityList to count the cities from
     * @return
     *      Returns the number of cities in the list
     */
    public int countCities(CityList list) {
        return list.cities.size();
    }

}
