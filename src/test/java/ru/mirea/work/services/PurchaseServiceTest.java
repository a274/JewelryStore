package ru.mirea.work.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.work.models.Purchase;
import ru.mirea.work.repositories.PurchaseRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceTest {
    @InjectMocks
    private PurchaseService purchaseService;
    @Mock
    private PurchaseRepo purchaseRepo;
    @Captor
    private ArgumentCaptor<Purchase> captor;

    private Purchase purchase1, purchase2, purchase3;
    @BeforeEach
    void setUp() {
        purchase1 = new Purchase();
        purchase1.setId(1);
        purchase1.setUserId(1);
        purchase1.setProductId(1);
        purchase1.setProductCount(1);

        purchase2 = new Purchase();
        purchase2.setId(2);
        purchase2.setUserId(1);
        purchase2.setProductId(2);
        purchase2.setProductCount(1);

        purchase3 = new Purchase();
        purchase3.setId(3);
        purchase3.setUserId(2);
        purchase3.setProductId(1);
        purchase3.setProductCount(1);
    }

    @Test
    void getPurchaseByUserIdAndProductId() {
        Mockito.when(purchaseRepo.findByUserIdAndProductId(1 ,1)).thenReturn(purchase1);
        assertEquals(purchase1, purchaseRepo.findByUserIdAndProductId(1, 1));
    }

    @Test
    void savePurchase() {
        purchaseService.savePurchase(purchase1);
        Mockito.verify(purchaseRepo).save(captor.capture());
        Purchase captured = captor.getValue();
        assertEquals(1, captured.getId());
    }

    @Test
    void getPurchasesByUserId() {
        Mockito.when(purchaseRepo.findAllByUserId(1)).thenReturn(List.of(purchase1, purchase2));
        assertEquals(List.of(purchase1, purchase2), purchaseRepo.findAllByUserId(1));
    }

    @Test
    void getPurchaseById() {
        Mockito.when(purchaseRepo.findById(3)).thenReturn(purchase3);
        assertEquals(purchase3, purchaseRepo.findById(3));
    }

    @Test
    void deletePurchaseById() {
        purchaseService.deletePurchaseById(1);
        Mockito.verify(purchaseRepo).deleteById(1);
    }

    @Test
    void deleteAllByUserId() {
        purchaseService.deleteAllByUserId(1);
        Mockito.verify(purchaseRepo).deleteAllByUserId(1);
    }
}