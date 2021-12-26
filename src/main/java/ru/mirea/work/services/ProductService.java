package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.Product;
import ru.mirea.work.repositories.ProductRepo;


import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с изделиями в контроллер
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAllProductsByTypesId(int typesId) {
        return productRepo.findAllByTypesId(typesId);
    }

    public List<Product> getAllProductsByTypesIdAndMetalId(int typesId, int metalId) {
        return productRepo.findAllByTypesIdAndMetalId(typesId, metalId);
    }

    public Product getProduct(int id){
        return productRepo.findById(id);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public void deleteById(int id){
        productRepo.deleteById(id);
    }
}
