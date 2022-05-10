package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    private CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(String id) {
        return carRepository.getCarById(id);
    }

    public void updateCar(Car car) {
        carRepository.updateCar(car);
    }

   public List<Car> showAllCars(){
     return carRepository.getAllCars();
   }


    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    public void deleteCarById(String id) {
        carRepository.deleteCarById(id);
    }
}
