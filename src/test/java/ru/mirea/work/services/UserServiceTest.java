package ru.mirea.work.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.work.models.User;
import ru.mirea.work.repositories.UserRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepo userRepo;
    @Captor
    private ArgumentCaptor<User> captor;

    private User user1, user2, user3;
    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1);
        user1.setEmail("email");
        user1.setUsername("user1");
        user1.setPassword("password");
        user1.setRole("role");

        user2 = new User();
        user2.setId(2);
        user2.setEmail("email");
        user2.setUsername("user2");
        user2.setPassword("password");
        user2.setRole("role");

        user3 = new User();
        user3.setId(3);
        user3.setEmail("email");
        user3.setUsername("user3");
        user3.setPassword("password");
        user3.setRole("role");
    }

    @Test
    void loadUserByUsername() {
        Mockito.when(userRepo.findByUsername("user3")).thenReturn(user3);
        assertEquals(user3, userRepo.findByUsername("user3"));
    }

    @Test
    void create() {
        String email = "email", username = "username", password = "password";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userService.saveUser(user);
        Mockito.verify(userRepo).save(captor.capture());
        User captured = captor.getValue();
        assertEquals("username", captured.getUsername());
    }

    @Test
    void getAll() {
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user1, user2, user3));
        assertEquals(List.of(user1, user2, user3), userRepo.findAll());
    }

    @Test
    void saveUser() {
        userService.saveUser(user1);
        Mockito.verify(userRepo).save(captor.capture());
        User captured = captor.getValue();
        assertEquals("user1", captured.getUsername());
    }

    @Test
    void deleteUser() {
        userService.deleteUser(2);
        Mockito.verify(userRepo).deleteById(2);
    }
}