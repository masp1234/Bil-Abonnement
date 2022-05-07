package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {

    @MockBean
    private CarRepository testRepository;

    @Test
    void getCarById() {
        // arrange
        Car car = new Car(100, "223", "Toyota", "C25",
                "Sort", "ABCD1234", "Advanced",
                15000, 30.5, 0);

        testRepository.addCar(car);

        // act
        Car resultCar = testRepository.getCarById(car.getId());



        // assert
        assertTrue(car.getId() == resultCar.getId(), "Should be the same car and therefore the result should be true" );


    }
}