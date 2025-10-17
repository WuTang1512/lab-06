package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for the City class.
     * @param city
     *      City name
     * @param province
     *      Province name
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the city name.
     * @return
     *      City name
     */
    String getCityName() {
        return this.city;
    }

    /**
     * Returns the province name.
     * @return
     *      Province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares this City object with another City object for ordering
     * based on the city name.
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Compares this City object with another City object for equality
     * based on the city and province names.
     * @param o
     *      The City object to compare with.
     * @return
     *      True if the cities and provinces are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city1 = (City) o;
        return city.equals(city1.getCityName()) &&
               province.equals(city1.getProvinceName());
    }

    /**
     * Generates a hash code value for the City object based on city, province
     * @return
     *      A hash code value for the City object.
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(city, province);
    }
}
