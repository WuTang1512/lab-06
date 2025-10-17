package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private void addCities(CityList cityList) {
        City city1 = new City("Vancouver", "British Columbia");
        City city2 = new City("Salmon Arm", "British Columbia");
        City city3 = new City("Victoria", "British Columbia");
        City city4 = new City("Winnipeg", "Manitoba");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city retuned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCities() {
        CityList cityList = mockCityList();
        City city0 = new City("Edmonton", "AB");
        City city1 = new City("Yellowknife", "Northwest Territories");

        // Checks to see if cityList.hasCity(city) returns false as the city has not
        // been added yet
        assertFalse(cityList.hasCity(city1));

        cityList.add(city1);
        // Checks to see if cityList.hasCity(city) returns True after adding the city to the list
        assertTrue(cityList.hasCity(city1));

        // Checks to see if cityList.hasCity(city) returns False after creating a new city variable
        // with the same city name but mismatched province name as existing city in the list
        assertFalse(cityList.hasCity(city0));

        // checking to see if the default city within cityList returns True
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        City dne_city = new City("Toronto", "Ontario");

        cityList.delete(city);
        // tests to see if the city that is initialized within cityList is deleted
        assertEquals(0, cityList.getCities().size());

        addCities(cityList);
        assertEquals(4, cityList.getCities().size());

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(dne_city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities(cityList));

        cityList.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, cityList.countCities(cityList));

        addCities(cityList);
        assertEquals(4, cityList.countCities(cityList));
    }

}
