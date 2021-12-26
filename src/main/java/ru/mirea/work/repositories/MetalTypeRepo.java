package ru.mirea.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.work.models.MetalType;

import java.util.List;

/**
 * Интерфейс для получения информации о связи между металлами и видами изделий из таблиц базы данных
 */
@Repository
public interface MetalTypeRepo extends JpaRepository<MetalType, Integer> {

    List<MetalType> findAllByTypesId(int typesId);

    Long deleteById(int id);
}
