package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.Purchase;
import ru.mirea.work.repositories.PurchaseRepo;

import java.util.List;

/**
 * Класс-сервис для передачи данных из таблицы Бд с добавленными изделями в контроллер
 */
@Service
@RequiredArgsConstructor
public class PurchaseService {

    private PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseService(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public Purchase getPurchaseByUserIdAndProductId(int userId, int productId) {
        return purchaseRepo.findByUserIdAndProductId(userId, productId);
    }

    public void savePurchase(Purchase purchase) {
        purchaseRepo.save(purchase);
    }


    public List<Purchase> getPurchasesByUserId(int userId) {
        return purchaseRepo.findAllByUserId(userId);
    }

    public Purchase getPurchaseById (int id) {
        return purchaseRepo.findById(id);
    }

    public void deletePurchaseById(int id) {
        purchaseRepo.deleteById(id);
    }

    public void deleteAllByUserId(int userId) {
        purchaseRepo.deleteAllByUserId(userId);
    }
}
