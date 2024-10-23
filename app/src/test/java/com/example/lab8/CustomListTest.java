package com.example.lab8;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * creates city object
     * checks if city is in list (should be false)
     * adds city to list
     * checks if city is in list (should now be true)
     */
    @Test
    void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }


    /**
     * creates city object and adds it to list
     * checks that the city is in the list (should be true)
     * deletes the city
     * checks if the city is in the list again (should be false)
     * then creates another city object and doesn't add it to the list
     * tries to delete city (exception should be thrown)
     */
    @Test
    void deleteTest() {
        list = MockCityList();
        City city1 = new City("Calgary", "Alberta");
        list.add(city1);
        assertTrue(list.hasCity(city1));
        list.delete(city1);
        assertFalse(list.hasCity(city1));

        City city2 = new City("Toronto", "Ontario");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            list.delete(city2);
        });
        assertEquals("City not in list", exception.getMessage());
    }


}
