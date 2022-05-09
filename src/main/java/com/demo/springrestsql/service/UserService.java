package com.demo.springrestsql.service;

import com.demo.springrestsql.model.User;
import com.demo.springrestsql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        User test = userRepository.save(user);
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}