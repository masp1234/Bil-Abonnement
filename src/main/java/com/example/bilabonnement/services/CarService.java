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

    public List<Car> showAllCarsBySearch(String search, String sortCriteria) {
        ArrayList<Car> cars = (ArrayList<Car>) carRepository.getAllCars();
        String searchLowercase = search.toLowerCase();
        String[] searchArray = searchLowercase.split(" ");
        ArrayList<Car> display = new ArrayList<>();
        ArrayList<Car> carsBySortCriteria = sortByCriteria(cars, sortCriteria);

        for (Car car:carsBySortCriteria) {
            Car selectedCar = checkSearch(car,searchArray);
            if(selectedCar != null) display.add(selectedCar);
        }

        return display;
    }

    private ArrayList<Car> sortByCriteria(ArrayList<Car> cars, String sortCriteria){
        ArrayList<Car> carsBySortCriteria = new ArrayList<>();
        if(sortCriteria.equals("all")) return cars;
        for (Car car:cars) {
            if(car.getStatus().equals(sortCriteria)) carsBySortCriteria.add(car);
        }
        return carsBySortCriteria;
    }

    private Car checkSearch(Car car, String[] search){
        for (String s:search) {
            if(!(car.getChassisNumber().toLowerCase().contains(s)
                    || car.getMake().toLowerCase().contains(s)
                    || car.getColor().toLowerCase().contains(s)
                    || car.getRegistrationNumber().toLowerCase().contains(s)
                    || car.getEquipmentLevel().toLowerCase().contains(s)
                    || car.getModel().toLowerCase().contains(s)
                    || Double.toString(car.getEmission()).contains(s)
                    || Double.toString(car.getRegistrationFee()).contains(s))) return null;
        }

        return car;
    }


}
