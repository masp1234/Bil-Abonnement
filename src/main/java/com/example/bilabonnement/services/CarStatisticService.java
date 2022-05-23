package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.CarStatisticRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CarStatisticService {

    private CarStatisticRepository carStatisticRepository;
    private CarRepository carRepository;

    public CarStatisticService(CarStatisticRepository carStatisticRepository) {
        this.carStatisticRepository = carStatisticRepository;
    }

    public List<CarMakeStatistic> getCarMakeStatistics() {
        List<CarMakeStatistic> carMakeStatistics = carStatisticRepository.getCarMakes();
        setAverageLeasePeriodPerMonthPerCarMake(carMakeStatistics);
        setAverageLeasePricePerMonthPerCarMake(carMakeStatistics);
        setStatusPerCarMake(carMakeStatistics);

        return carMakeStatistics;
    }

    private List<CarMakeStatistic> setAverageLeasePeriodPerMonthPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
       List<Double> averageLeasePeriods = carStatisticRepository.getAverageLeasePeriodsPerCarMake();

       int counter = 0;
        for (CarMakeStatistic cms: carMakeStatistics) {
            cms.setAverageLeasePeriod(averageLeasePeriods.get(counter));
            counter++;
            System.out.println(cms);
        }
        return carMakeStatistics;
    }

    private List<CarMakeStatistic> setAverageLeasePricePerMonthPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        List<Double> averagePricesPerMonth = carStatisticRepository.getAverageLeasePricePerMonthPerCarMake();

        int counter = 0;
        for (CarMakeStatistic cms: carMakeStatistics) {
            cms.setAveragePricerPerMonth(averagePricesPerMonth.get(counter));
            counter++;
            System.out.println(cms);
        }
        return carMakeStatistics;

    }
    private List<CarMakeStatistic> setStatusPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        HashMap<String, HashMap<String, Integer>> statusPerCarMake = carStatisticRepository.getCarMakesAndStatus();

        for (CarMakeStatistic cms: carMakeStatistics) {
            int numberOfAvailableCars = statusPerCarMake.get(cms.getCarMake()).get("available");
            cms.setNumberOfAvailableCars(numberOfAvailableCars);

            int numberOfReservedCars = statusPerCarMake.get(cms.getCarMake()).get("reserved");
            cms.setNumberOfRentedCars(numberOfReservedCars);

            int numberOfWorkshopCars = statusPerCarMake.get(cms.getCarMake()).get("workshop");
            cms.setNumberOfWorkshopCars(numberOfWorkshopCars);
        }


        return carMakeStatistics;
    }
    private List<CarMakeStatistic> setMostPopularColorPerCarMake(List<CarMakeStatistic>  carMakeStatistics) {
        List<Car> cars = carRepository.getAllCars();





        return carMakeStatistics;
    }






}
