package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.LeaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarService {

    private CarRepository carRepository;
    private LeaseRepository leaseRepository;


    public CarService(CarRepository carRepository, LeaseRepository leaseRepository) {
        this.carRepository = carRepository;
        this.leaseRepository = leaseRepository;
    }

    /*Martin*/
    public Car getCarById(String id) {
        return carRepository.getCarById(id);
    }

    /*Renas*/
   public List<Car> showAllCars(){
     return carRepository.getAllCars();
   }

    /*Renas*/

    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    /*Daniel*/
    public List<Car> searchCars(String search, String sortCriteria) {
        ArrayList<Car> cars = (ArrayList<Car>) carRepository.getAllCars();
        String searchLowercase = search.toLowerCase();
        String[] searchArray = searchLowercase.split(" ");
        ArrayList<Car> display = new ArrayList<>();
        if(!sortCriteria.equals("all")) {
            cars = sortByCriteria(cars, sortCriteria);
        }
        for (Car car:cars) {
            Car selectedCar = checkSearch(car,searchArray);
            if(selectedCar != null) display.add(selectedCar);
        }

        return display;
    }

    /*Martin
    * Daniel*/
    public ArrayList<Car> sortByCriteria(ArrayList<Car> cars, String sortCriteria){
        ArrayList<Car> carsBySortCriteria = new ArrayList<>();
        for (Car car:cars) {
            if(car.getStatus().equals(sortCriteria)) carsBySortCriteria.add(car);
        }
        return carsBySortCriteria;
    }

    /*Martin
    * Daniel*/
    public Car checkSearch(Car car, String[] search){
        for (String s:search) {
            if(!car.toString().toLowerCase().contains(s)) return null;
        }

        return car;
    }

    //Den skifter status med den besked man sender
    /*Daniel
    * Martin*/
    public void updateStatus(String regNumber) {
        Car car = carRepository.getCarById(regNumber);
        String updatedStatus = "reserved";

        switch (car.getStatus()) {
            case "reserved":
                updatedStatus = "workshop";
                leaseRepository.deleteBy(regNumber);
                break;

            case "workshop":
                updatedStatus = "available";
                break;

            case "available":
                updatedStatus = "reserved";
                break;
        }
        carRepository.updateStatus(regNumber, updatedStatus);
    }

}
