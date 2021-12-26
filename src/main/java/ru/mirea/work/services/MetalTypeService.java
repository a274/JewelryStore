package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.MetalType;
import ru.mirea.work.repositories.MetalTypeRepo;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд со связями между металлами и видами изделий в контроллер
 */
@Service
@RequiredArgsConstructor
public class MetalTypeService {
    private MetalTypeRepo metalTypeRepo;

    @Autowired
    public MetalTypeService(MetalTypeRepo metalTypeRepo) {
        this.metalTypeRepo = metalTypeRepo;
    }

    public List<MetalType> getMetalByTypeId(int typeId) {
        return metalTypeRepo.findAllByTypesId(typeId);
    }

    public List<MetalType> getAll() {
        return metalTypeRepo.findAll();
    }

    public void saveMetalType(MetalType metalType){ metalTypeRepo.save(metalType);}

    public void deleteById(int id){ metalTypeRepo.deleteById(id);}
}
