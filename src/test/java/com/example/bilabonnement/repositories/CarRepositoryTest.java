package com.example.bilabonnement.repositories;

import com.example.bilabonnement.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository testRepository;
    private Car car;

    @BeforeEach
    public void testSetUp() {
        car = new Car();
        car.setRegistrationNumber("22");
        car.setChassisNumber("dfdsfsf");
        car.setMake("Toyota");
        car.setModel("c25");
        car.setEquipmentLevel("advanced");
        car.setRegistrationFee(12000);
        car.setEmission(22.5);
        car.setColor("rød");
        System.out.println("Den laver et car objekt inden hver metode");
    }

    @Test
    void getCarById() {
        // arrange
        testRepository.addCar(car);

        // act
        Car resultCar = testRepository.getCarById(car.getRegistrationNumber());

        // assert
        assertEquals(car, resultCar, "Should return true, because it is the same car");

        //cleanup
        testRepository.deleteCarById(car.getRegistrationNumber());

    }
        @Test
    void addCar() {
            // arrange

            assertNull(testRepository.getCarById(car.getRegistrationNumber()), "Should be null, because the car does not exist yet");

            testRepository.addCar(car);

            // act
            Car resultCar = testRepository.getCarById(car.getRegistrationNumber());

            // assert
            assertEquals(car, resultCar), "Should return true, as it is the same car");

            //cleanup
            testRepository.deleteCarById(car.getRegistrationNumber());
        }


}