package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.Type;
import ru.mirea.work.repositories.TypeRepo;


import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с видами изделий в контроллер
 */
@Service
@RequiredArgsConstructor
public class TypeService {
    private TypeRepo typeRepo;

    @Autowired
    public TypeService( TypeRepo typeRepo){
        this.typeRepo = typeRepo;
    }

    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    public void saveType(Type type) {
        typeRepo.save(type);
    }

    public void deleteById(int id) {
        typeRepo.deleteById(id);
    }
}
