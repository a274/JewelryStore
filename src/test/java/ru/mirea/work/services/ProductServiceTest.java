package ru.mirea.work.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.work.models.Product;
import ru.mirea.work.repositories.ProductRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepo productRepo;
    @Captor
    private ArgumentCaptor<Product> captor;

    private Product product1, product2, product3;
    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setId(1);
        product1.setTypesId(1);
        product1.setMetalId(1);
        product1.setName("product1");
        product1.setPrice(100);
        product1.setWeight(10);
        product1.setDescription("description");

        product2 = new Product();
        product2.setId(2);
        product2.setTypesId(1);
        product2.setMetalId(1);
        product2.setName("product2");
        product2.setPrice(100);
        product2.setWeight(10);
        product2.setDescription("description");

        product3 = new Product();
        product3.setId(3);
        product3.setTypesId(2);
        product3.setMetalId(1);
        product3.setName("product3");
        product3.setPrice(100);
        product3.setWeight(10);
        product3.setDescription("description");
    }

    @Test
    void getAllProductsByTypesId() {
        Mockito.when(productRepo.findAllByTypesId(1)).thenReturn(List.of(product1, product2));
        assertEquals(2, productRepo.findAllByTypesId(1).size());
    }

    @Test
    void getAllProductsByTypesIdAndMetalId() {
        Mockito.when(productRepo.findAllByTypesIdAndMetalId(1, 1)).thenReturn(List.of(product1, product2));
        assertEquals(2, productRepo.findAllByTypesIdAndMetalId(1, 1).size());
    }

    @Test
    void getProduct() {
        Mockito.when(productRepo.findById(3)).thenReturn(product3);
        assertEquals(product3, productRepo.findById(3));
    }

    @Test
    void getAll() {
        Mockito.when(productRepo.findAll()).thenReturn(List.of(product1, product2, product3));
        assertEquals(List.of(product1, product2, product3), productRepo.findAll());
    }

    @Test
    void saveProduct() {
        productService.saveProduct(product1);
        Mockito.verify(productRepo).save(captor.capture());
        Product captured = captor.getValue();
        assertEquals("product1", captured.getName());
    }

    @Test
    void deleteById() {
        productService.deleteById(1);
        Mockito.verify(productRepo).deleteById(1);
    }
}