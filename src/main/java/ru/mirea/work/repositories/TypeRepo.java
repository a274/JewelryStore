package ru.mirea.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.work.models.Type;

/**
 * Интерфейс для получения информации о видах изделий из таблиц базы данных
 */
@Repository
public interface TypeRepo extends JpaRepository<Type, Integer> {
    Long deleteById(int id);
}
