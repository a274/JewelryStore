package ru.mirea.work.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.work.models.User;
import ru.mirea.work.repositories.UserRepo;

import java.util.List;

/**
 * Класс-сервис для передачи данных из табилцы Бд с пользователями в контроллер
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    /**
     * Интерфейс-репозиторий получающий данные из таблицы БД с пользователями
     */
    private UserRepo userRepo;
    /**
     * Реализация кодера паролей, который использует функцию сильного хэширования BCrypt
     */
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepo.findByUsername(s);
    }

    public void create(String email, String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(bCryptPasswordEncoder.encode(password));
        u.setEmail(email);
        u.setRole("USER");
        userRepo.save(u);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public  void saveUser(User user){
        userRepo.save(user);
    }

    public void deleteUser(int id){
        userRepo.deleteById(id);
    }
}
