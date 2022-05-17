package com.example.bilabonnement.services;

import com.example.bilabonnement.models.DamageReport;
import com.example.bilabonnement.repositories.DamageReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*TODO Henter priserne fra damageRepository*/
/*TODO Sorter efter dato*/
@Service
public class DamageReportService {

    private DamageReportRepository damageReportRepository;

    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    public void addDamageReport(DamageReport damageReport) {
        damageReportRepository.addDamageReport(damageReport);
    }

    public List<DamageReport> showAllDamageReportsByChassisNumber(String chassisNumber) {
        List<DamageReport> damageReports = damageReportRepository.getAllDamageReports();
        return damageReports;
    }

    public DamageReport getDamageReportsById(String chassisNumber) {
        return damageReportRepository.getDamageReportByChassisNumber(chassisNumber);

    }
}
