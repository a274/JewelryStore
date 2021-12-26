package ru.mirea.work.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.work.models.Metal;
import ru.mirea.work.repositories.MetalRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MetalServiceTest {
    @InjectMocks
    private MetalService metalService;
    @Mock
    private MetalRepo metalRepo;
    @Captor
    private ArgumentCaptor<Metal> captor;

    private Metal metal1, metal2;
    @BeforeEach
    void setUp() {
        metal1 = new Metal();
        metal1.setId(1);
        metal1.setName("Metal1");

        metal2 = new Metal();
        metal2.setId(2);
        metal2.setName("Metal2");
    }

    @Test
    void getAllMetal() {
        Mockito.when(metalRepo.findAll()).thenReturn(List.of(metal1, metal2));
        assertEquals(2, metalRepo.findAll().size());
    }

    @Test
    void getMetalById() {
        Mockito.when(metalRepo.findById(1)).thenReturn(metal1);
        assertEquals(metal1, metalRepo.findById(1));
    }

    @Test
    void saveMetal() {
        metalService.saveMetal(metal1);
        Mockito.verify(metalRepo).save(captor.capture());
        Metal capturedMetal = captor.getValue();
        assertEquals("Metal1", capturedMetal.getName());
    }

    @Test
    void deleteById() {
        metalService.deleteById(1);
        Mockito.verify(metalRepo).deleteById(1);
    }
}