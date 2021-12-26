package ru.mirea.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.work.models.Type;
import ru.mirea.work.models.User;

/**
 * Интерфейс для получения информации о пользователях из таблиц базы данных
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    Long deleteById(int id);
}
