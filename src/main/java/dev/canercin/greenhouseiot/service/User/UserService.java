package dev.canercin.greenhouseiot.service.User;

import dev.canercin.greenhouseiot.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUsername(String username);
    UserDetailsService userDetailsService();
<<<<<<< HEAD
=======
    void deleteUser(String id);
>>>>>>> 6670f8a (get last 10 record added)
}