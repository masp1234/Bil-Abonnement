package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.DamageReportRepository;
import com.example.bilabonnement.repositories.DamageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*TODO Henter priserne fra damageRepository*/
/*TODO Sorter efter dato*/
@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;
    private DamageRepository damageRepository;
    private CarRepository carRepository;

    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository, DamageRepository damageRepository) {
        this.damageReportRepository = damageReportRepository;
        this.carRepository = carRepository;
        this.damageRepository = damageRepository;
    }

    public void addDamageReport(DamageReport damageReport) {
        LocalDate localDate = LocalDate.now();
        String localDateString = localDate.toString();
        damageReport.setDate(localDateString);
        damageReportRepository.addDamageReport(damageReport);
    }

    public List<DamageReport> showAllDamageReportsByChassisNumber(String chassisNumber) {
        List<DamageReport> damageReports = damageReportRepository.getAllDamageReports(chassisNumber);
        int price = 0;
        for (DamageReport damageReport: damageReports){
            ArrayList<Damage> damages = (ArrayList<Damage>) damageRepository.getAllDamages(damageReport.getId());
            for (Damage damage: damages){
                price = price + damage.getPrice();
            }
            damageReport.setTotalPrice(price);
            price = 0;
        }
        return damageReports;
    }

    public DamageReport getDamageReportById(int id) {
        return damageReportRepository.getDamageReportById(id);

    }
    public Car getCarById(String chassisNumber) {
        return carRepository.getCarById(chassisNumber);
    }
}
