package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.Metal;
import ru.mirea.work.repositories.MetalRepo;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с металлами в контроллер
 */
@Service
@RequiredArgsConstructor
public class MetalService {
    private MetalRepo metalRepo;

    @Autowired
    public MetalService(MetalRepo metalRepo) {
        this.metalRepo = metalRepo;
    }

    public List<Metal> getAllMetal() {
        return metalRepo.findAll();
    }

    public Metal getMetalById(int id) {
        return metalRepo.findById(id);
    }

    public void saveMetal(Metal metal) {
        metalRepo.save(metal);
    }

    public void deleteById(int id) {
        metalRepo.deleteById(id);
    }
}
