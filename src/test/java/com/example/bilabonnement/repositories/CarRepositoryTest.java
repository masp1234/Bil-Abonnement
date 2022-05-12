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

    @Autowired
    private CarRepository testRepository;

    @Test
    void getCarById() {
        // arrange
       Car car = new Car();
       car.setRegistrationNumber("22");
       car.setChassisNumber("dfdsfsf");
       car.setMake("Toyota");
       car.setModel("c25");
       car.setEquipmentLevel("advanced");
       car.setRegistrationFee(12000);
       car.setEmission(22.5);
       car.setColor("rød");

        testRepository.addCar(car);

        // act
        Car resultCar = testRepository.getCarById(car.getRegistrationNumber());

        // assert
        assertTrue(car.getRegistrationNumber().equalsIgnoreCase(resultCar.getRegistrationNumber()), "Should be the same car and therefore the result should be true" );

        //cleanup
        testRepository.deleteCarById(car.getRegistrationNumber());

        //assert



    }
}