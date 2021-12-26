package ru.mirea.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.work.models.Product;

import java.util.List;

/**
 * Интерфейс для получения информации об изделиях из таблиц базы данных
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAllByTypesId(int typesId);

    List<Product> findAllByTypesIdAndMetalId(int typesId, int metalId);

    Product findById(int id);

    Long deleteById(int id);
}
