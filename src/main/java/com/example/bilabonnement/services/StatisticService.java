package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Lease;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.LeaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class StatisticService {

    private CarRepository carRepository;
    private LeaseRepository leaseRepository;

    public StatisticService(CarRepository carRepository, LeaseRepository leaseRepository){
        this.carRepository = carRepository;
        this.leaseRepository = leaseRepository;
    }



    public ArrayList<String> getCarNamesStatistics(){
        HashSet<String> hashset = new HashSet<>();

        List<Car> cars = carRepository.getAllCars();

        //put'er alle de maps der er brug for
        for (Car c:cars) {
            hashset.add(c.getMake().toLowerCase());
        }
        //laver en arraylist, som vi kan sorterer med collections.sort
        ArrayList<String> hashes = new ArrayList<>(hashset);
        Collections.sort(hashes);
        return hashes;
    }

    public int[][] getCarStatistics(){

        List<Car> cars = carRepository.getAllCars();

        ArrayList<String> hashes = getCarNamesStatistics();

        //laver et 2d array
        int[][] list = new int[hashes.size()+1][6];
        int counter = 0;
        int workshop = 0;
        int reserved = 0;
        int available = 0;
        int averageRentPrMonth = 0;
        int fullAverageRentPrMonth = 0;
        int leaseCounter = 0;
        int averageLeasing = 0;
        int fullAverageLeasing = 0;
        //sætter alle på deres pladser
        for (String make:hashes) {
            for (Car car:cars) {
                if(make.equalsIgnoreCase(car.getMake())){
                    if(car.getStatus().equals("available")){ list[counter][0]++; available++;}
                    if(car.getStatus().equals("workshop")){ list[counter][2]++; workshop++;}
                    if(car.getStatus().equals("reserved")) {
                        list[counter][1]++;
                        reserved++;
                        leaseCounter++;
                        Lease lease = leaseRepository.findlease(car.getRegistrationNumber());
                        averageRentPrMonth = lease.getPrice() + averageRentPrMonth;
                        fullAverageRentPrMonth = lease.getPrice() + fullAverageRentPrMonth;

                        //fundet på https://beginnersbook.com/2017/10/java-8-calculate-days-between-two-dates/
                        LocalDate startDate = LocalDate.parse(lease.getStartDate());
                        LocalDate endDate = LocalDate.parse(lease.getEndDate());
                        averageLeasing = (int) ChronoUnit.DAYS.between(startDate,endDate) + averageLeasing;
                        fullAverageLeasing = (int) ChronoUnit.DAYS.between(startDate,endDate) + fullAverageLeasing;
                    }
                }
            }
            list[counter][3] = averageRentPrMonth;
            list[counter][4] = averageLeasing;
            counter++;
            averageRentPrMonth = 0;
            averageLeasing = 0;
        }
        //det er samlet kolonne
        list[hashes.size()][0] = available;
        list[hashes.size()][1] = reserved;
        list[hashes.size()][2] = workshop;
        list[hashes.size()][3] = fullAverageRentPrMonth / leaseCounter;
        list[hashes.size()][4] = fullAverageLeasing / leaseCounter;




        //Lige nu ledig, udlejet, på værksted, gennemsnitlig pris per måned, gennemsnitlig lejeperiode





        System.out.println(hashes);
        for (int i = 0; i<list.length; i++){
            for (int j = 0; j<list[i].length; j++){
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
        return list;

    }







}
