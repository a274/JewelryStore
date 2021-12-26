package ru.mirea.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.work.models.Metal;

/**
 * Интерфейс для получения информации о металле изделия из таблиц базы данных
 */
@Repository
public interface MetalRepo extends JpaRepository<Metal, Integer> {
    Metal findById(int id);

    Long deleteById(int id);
}
