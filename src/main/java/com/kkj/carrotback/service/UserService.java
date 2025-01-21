package com.kkj.carrotback.service;

import com.kkj.carrotback.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kkj.carrotback.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUserByUserLoginId(String id) {
        return userRepository.findByUserLoginId(id);
    }


    public User createUser(User user) {
        if (!userRepository.findAll().isEmpty()) {
            user.setRole("USER");
        } else {
            user.setRole("ADMIN");
        }
        return userRepository.save(user);
    }

}
