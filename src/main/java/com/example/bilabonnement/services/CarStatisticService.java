package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.CarMakeStatistic;
import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.CarStatisticRepository;
import com.example.bilabonnement.repositories.DamageReportRepository;
import com.example.bilabonnement.repositories.DamageRepository;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;

import java.util.List;

@Service
public class CarStatisticService {

    private CarStatisticRepository carStatisticRepository;
    private DamageReportRepository damageReportRepository;
    private DamageRepository damageRepository;

    public CarStatisticService(CarStatisticRepository carStatisticRepository, DamageReportRepository damageReportRepository, DamageRepository damageRepository) {
        this.carStatisticRepository = carStatisticRepository;
        this.damageReportRepository = damageReportRepository;
        this.damageRepository = damageRepository;
    }

    public List<CarMakeStatistic> getCarMakeStatistics() {
        LocalTime start = LocalTime.now();
        System.out.println(start);

        List<CarMakeStatistic> carMakeStatistics = carStatisticRepository.getCarMakes();
        setAverageLeasePeriodPerMonthPerCarMake(carMakeStatistics);
        setAverageLeasePricePerMonthPerCarMake(carMakeStatistics);
        setStatusPerCarMake(carMakeStatistics);
        setMostPopularColorPerCarMake(carMakeStatistics);
        setMostPopularModelPerCarMake(carMakeStatistics);
        setAverageDamagesPerDamageReportPerCarMake(carMakeStatistics);

        LocalTime end = LocalTime.now();
        System.out.println(end);

        return carMakeStatistics;
    }

    private List<CarMakeStatistic> setAverageLeasePeriodPerMonthPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        List<Double> averageLeasePeriods = carStatisticRepository.getAverageLeasePeriodsPerCarMake();

        int counter = 0;
        for (CarMakeStatistic cms : carMakeStatistics) {
            cms.setAverageLeasePeriod(averageLeasePeriods.get(counter));
            counter++;

        }
        return carMakeStatistics;
    }

    private List<CarMakeStatistic> setAverageLeasePricePerMonthPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        List<Double> averagePricesPerMonth = carStatisticRepository.getAverageLeasePricePerMonthPerCarMake();

        int counter = 0;
        for (CarMakeStatistic cms : carMakeStatistics) {
            cms.setAveragePricerPerMonth(averagePricesPerMonth.get(counter));
            counter++;

        }
        return carMakeStatistics;

    }

    private List<CarMakeStatistic> setStatusPerCarMake(List<CarMakeStatistic> carMakeStatistics) {
        HashMap<String, HashMap<String, Integer>> statusPerCarMake = carStatisticRepository.getCarMakesAndStatus();

        for (CarMakeStatistic cms : carMakeStatistics) {
            int numberOfAvailableCars = statusPerCarMake.get(cms.getCarMake()).get("available");
            cms.setNumberOfAvailableCars(numberOfAvailableCars);

            int numberOfReservedCars = statusPerCarMake.get(cms.getCarMake()).get("reserved");
            cms.setNumberOfRentedCars(numberOfReservedCars);

            int numberOfWorkshopCars = statusPerCarMake.get(cms.getCarMake()).get("workshop");
            cms.setNumberOfWorkshopCars(numberOfWorkshopCars);
        }

        return carMakeStatistics;
    }

    public List<CarMakeStatistic> setMostPopularColorPerCarMake(List<CarMakeStatistic> carMakeStatistics) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (CarMakeStatistic cms : carMakeStatistics) {
            List<Car> carsByCarMake = carStatisticRepository.getAllCarsByCarMake(cms.getCarMake());

            for (Car car : carsByCarMake) {
                if (hashMap.get(car.getColor()) == null) {
                    hashMap.put(car.getColor(), 1);
                } else {
                    int colorCounter = hashMap.get(car.getColor());
                    colorCounter++;
                    hashMap.put(car.getColor(), colorCounter);
                }
            }
            cms.setMostPopularColor(Collections.max(hashMap.keySet()));

            hashMap.clear();
        }

        return carMakeStatistics;
    }

    public List<CarMakeStatistic> setMostPopularModelPerCarMake(List<CarMakeStatistic> carMakeStatistics) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (CarMakeStatistic cms : carMakeStatistics) {
            List<Car> carsByCarMake = carStatisticRepository.getAllCarsByCarMake(cms.getCarMake());

            for (Car car : carsByCarMake) {
                if (hashMap.get(car.getModel()) == null) {
                    hashMap.put(car.getModel(), 1);
                } else {
                    int modelCounter = hashMap.get(car.getModel());
                    modelCounter++;
                    hashMap.put(car.getModel(), modelCounter);
                }
            }
            cms.setMostPopularModel(Collections.max(hashMap.keySet()));

            hashMap.clear();

        }
        return carMakeStatistics;
    }

    public List<CarMakeStatistic> setAverageDamagesPerDamageReportPerCarMake(List<CarMakeStatistic> carMakeStatistics) {

        double numberOfDamageReportsPerCarMake = 0;
        double numberOfDamagesPerDamageReport = 0;


        for (CarMakeStatistic cms : carMakeStatistics) {
            List<Car> allCarsByCarMakears = carStatisticRepository.getAllCarsByCarMake(cms.getCarMake());

            for (Car car : allCarsByCarMakears) {
                List<DamageReport> damageReportsPerCarMake = damageReportRepository.getAllDamageReports(car.getChassisNumber());
                numberOfDamageReportsPerCarMake = numberOfDamageReportsPerCarMake + damageReportsPerCarMake.size();

                for (DamageReport damageReport : damageReportsPerCarMake) {
                    List<Damage> damagesPerDamageReport = damageRepository.getAllDamages(damageReport.getId());
                    numberOfDamagesPerDamageReport = numberOfDamagesPerDamageReport + damagesPerDamageReport.size();
                }
            }
            if (numberOfDamageReportsPerCarMake != 0) {
                double averageDamagesPerDamageReport = numberOfDamagesPerDamageReport / numberOfDamageReportsPerCarMake;

                double roundedAverageDamagesPerDamageReport = DoubleRounder.round(averageDamagesPerDamageReport, 2);

                cms.setAverageDamagesPerDamageReport(roundedAverageDamagesPerDamageReport);
            }
            numberOfDamageReportsPerCarMake = 0;
            numberOfDamagesPerDamageReport = 0;

        }
        return carMakeStatistics;
    }
}
