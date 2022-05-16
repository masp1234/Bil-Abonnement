package com.example.bilabonnement.services;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.DamageReportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;

    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    public void addDamageReport(DamageReport damageReport) {
        damageReportRepository.addDamageReport(damageReport);
    }

    /*
    public List<DamageReport> showAllDamageReportsByChassisNumber(String chassisNumber) {
        ArrayList<DamageReport> damageReports = (ArrayList<DamageReport>) damageReportRepository.getAllDamageReports();

    } */

    public DamageReport getDamageReportsById(String id) {
        return damageReportRepository.getDamageReportById(id);

    }
}
