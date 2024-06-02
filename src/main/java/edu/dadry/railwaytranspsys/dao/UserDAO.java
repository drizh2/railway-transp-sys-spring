package edu.dadry.railwaytranspsys.dao;

import edu.dadry.railwaytranspsys.model.User;
import edu.dadry.railwaytranspsys.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
