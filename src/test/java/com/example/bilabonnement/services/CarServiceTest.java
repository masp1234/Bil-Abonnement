package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService testService;
    private ArrayList<Car> carList;


    /*Martin*/
    @Test
    void sortByCriteria() {

        //act
        List<Car> sortedCars = testService.sortByCriteria(carList, "reserved");

        assertTrue(sortedCars.size() == 1,
                "should be true, since there is only one reserved car in carList");



    }

/*Martin
* Daniel*/
    @Test
    void checkSearch() {

        //arrange
        // skal være lowercase, da checksearch sætter alt til lowercase
        String[] searchWords = {"ford", "green", "super advanced"};
        Car car = carList.get(0);
        System.out.println("this is the car: " + car);

        //act
        Car resultCar = testService.checkSearch(car, searchWords);

        System.out.println("Det her er resultCar = " + resultCar);

        //assert
       assertNotNull(resultCar, "It's null");


        /*
        assertNotNull(resultCar, "Should not be null," +
                " since there is a Ford in the list of cars");*/
    }

    /*Martin*/
    @BeforeEach
    void initCarList() {
        carList = new ArrayList<>();
        carList.add(new Car("1", "fsf",
                "Ford", "2323F", "green",
                "super advanced",
                6000.50, 22.3,
                "available", "dfsdf"));

        carList.add(new Car("1", "fsf",
                "Mercedes", "2323F", "Yellow",
                "super advanced",
                6000.50, 22.3,
                "reserved", "dfsdf"));

        carList.add(new Car("1", "fsf",
                "Skoda", "2323F", "Black",
                "super advanced",
                6000.50, 22.3,
                "available", "dfsdf"));

        carList.add(new Car("1", "fsf",
                "Kia", "2323F", "Grey",
                "super advanced",
                6000.50, 22.3,
                "available", "dfsdf"));

        carList.add(new Car("1", "fsf",
                "Toyota", "2323F", "Chrome",
                "super advanced",
                6000.50, 22.3,
                "værksted", "dfsdf"));

        carList.add(new Car("1", "fsf",
                "Rolls Royce", "2323F", "red",
                "super advanced",
                6000.50, 22.3,
                "værksted", "dfsdf"));
    }
}