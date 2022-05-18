package com.example.bilabonnement.services;

import com.example.bilabonnement.models.Damage;
import com.example.bilabonnement.repositories.DamageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {
    private DamageRepository damageRepository;

    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    public List<Damage> getAllDamages(int id){
        return damageRepository.getAllDamages(id);
    }
    public void addDamage(Damage damage){
        damageRepository.addDamage(damage);
    }

    public void deleteById(int id){
        damageRepository.deleteById(id);
    }
}
