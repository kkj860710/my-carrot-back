package com.kkj.carrotback.service;

import com.kkj.carrotback.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kkj.carrotback.repository.UserRepository;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUserByUserLoginId(String id) {
        return userRepository.findByUserLoginId(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

}
