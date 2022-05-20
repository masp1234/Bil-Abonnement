package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Car;
import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.CarRepository;
import com.example.bilabonnement.repositories.DamageReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*TODO Henter priserne fra damageRepository*/
/*TODO Sorter efter dato*/
@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;
    private CarRepository carRepository;

    public DamageReportService(DamageReportRepository damageReportRepository, CarRepository carRepository) {
        this.damageReportRepository = damageReportRepository;
        this.carRepository = carRepository;
    }

    public void addDamageReport(DamageReport damageReport) {
        LocalDate localDate = LocalDate.now();
        String localDateString = localDate.toString();
        damageReport.setDate(localDateString);
        damageReportRepository.addDamageReport(damageReport);
    }

    public List<DamageReport> showAllDamageReportsByChassisNumber(String chassisNumber) {
        List<DamageReport> damageReports = damageReportRepository.getAllDamageReports(chassisNumber);
        return damageReports;
    }

    public DamageReport getDamageReportsById(int id) {
        return damageReportRepository.getDamageReportByChassisNumber(id);

    }

    public Car getCarById(String chassisNumber) {
        return carRepository.getCarById(chassisNumber);
    }
}
