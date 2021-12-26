package ru.mirea.work.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.work.models.MetalType;
import ru.mirea.work.repositories.MetalTypeRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MetalTypeServiceTest {
    @InjectMocks
    private MetalTypeService metalTypeService;
    @Mock
    private MetalTypeRepo metalTypeRepo;
    @Captor
    private ArgumentCaptor<MetalType> captor;


    private MetalType metalType1, metalType2, metalType3;
    @BeforeEach
    void setUp() {
        metalType1 = new MetalType();
        metalType1.setId(1);
        metalType1.setTypesId(1);

        metalType2 = new MetalType();
        metalType2.setId(2);
        metalType2.setTypesId(2);

        metalType3 = new MetalType();
        metalType3.setId(3);
        metalType3.setTypesId(2);
    }

    @Test
    void getMetalByTypeId() {
        Mockito.when(metalTypeRepo.findAllByTypesId(2)).thenReturn(List.of(metalType2, metalType3));
        assertEquals(2, metalTypeRepo.findAllByTypesId(2).size());
    }

    @Test
    void getAll() {
        Mockito.when(metalTypeRepo.findAll()).thenReturn(List.of(metalType1, metalType2, metalType3));
        assertEquals(3, metalTypeRepo.findAll().size());
    }

    @Test
    void saveMetalType() {
        metalTypeService.saveMetalType(metalType1);
        Mockito.verify(metalTypeRepo).save(captor.capture());
        MetalType captured = captor.getValue();
        assertEquals(1, captured.getId());
    }

    @Test
    void deleteById() {
        metalTypeService.deleteById(1);
        Mockito.verify(metalTypeRepo).deleteById(1);
    }
}