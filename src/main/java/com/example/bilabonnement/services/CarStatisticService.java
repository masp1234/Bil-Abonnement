package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.repositories.CarStatisticRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarStatisticService {

    private CarStatisticRepository carStatisticRepository;

    public CarStatisticService(CarStatisticRepository carStatisticRepository) {
        this.carStatisticRepository = carStatisticRepository;
    }

    public List<CarMakeStatistic> getCarMakeStatistics() {
        List<CarMakeStatistic> carMakeStatistics = carStatisticRepository.getCarMakes();
        setAverageLeasePeriodPerMonthPerCarMake(carMakeStatistics);
        setAverageLeasePricePerMonthPerCarMake(carMakeStatistics);

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
            cms.setAveragePricerPerMonth(averagePricesPerMonth.get(0));
            counter++;
            System.out.println(cms);
        }

        return carMakeStatistics;

    }
    private List<CarMakeStatistic> setStatusPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        List<List<Integer>> statusPerCarMake = new ArrayList<>();




        return carMakeStatistics;
    }






}
