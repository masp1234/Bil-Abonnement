package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void deleteCarById(int id) {
        carRepository.deleteCarById(id);
    }

    public List<Car> showAllCarsBySearch(String search) {
        List<Car> cars = carRepository.getAllCars();
        String searchLowercase = search.toLowerCase();
        String[] searchArray = searchLowercase.split(" ");
        ArrayList<Car> display = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = checkSearch(cars.get(i),searchArray);
            if(car != null) display.add(car);

        }
        return display;
    }

    public static Car checkSearch(Car car, String[] search){

        for (int i = 0; i < search.length; i++) {
            if(!(car.getChassisNumber().toLowerCase().contains(search[i])
                    || car.getMake().toLowerCase().contains(search[i])
                    || car.getColor().toLowerCase().contains(search[i])
                    || car.getRegistrationNumber().toLowerCase().contains(search[i])
                    || car.getEquipmentLevel().toLowerCase().contains(search[i]))) return null;

        }
        return car;
    }
}
