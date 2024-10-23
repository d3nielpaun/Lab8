package com.example.lab8;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
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
        CustomList cityList = MockCityList();
        City city = new City("Edmonton", "Alberta");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

}
