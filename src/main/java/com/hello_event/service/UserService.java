package com.hello_event.service;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.exception.UserNotFoundException;
import com.hello_event.model.User;
import com.hello_event.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getAll() {
        var users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return users;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
    public User delete(Long id) throws UserNotFoundException {
        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return user;
    }
}
