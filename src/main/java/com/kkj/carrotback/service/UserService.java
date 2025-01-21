package com.kkj.carrotback.service;

import com.kkj.carrotback.dto.UserDto;
import com.kkj.carrotback.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kkj.carrotback.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUserByUserLoginId(UserDto userDto) {
        User user = userRepository.findByUserLoginId(userDto.getUserLoginId());
        if(user != null) {
            if(Objects.equals(user.getUserPassword(), userDto.getUserPassword())) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
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
