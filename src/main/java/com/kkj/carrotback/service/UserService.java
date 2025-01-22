package com.kkj.carrotback.service;

import com.kkj.carrotback.dto.UserDto;
import com.kkj.carrotback.entity.User;
import com.kkj.carrotback.repository.UserRepository;
import com.kkj.carrotback.bcrypt.Bcrypt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    private final Bcrypt bcrypt;

    public User getUserByUserLoginId(UserDto userDto) {
        User user = userRepository.findByUserLoginId(userDto.getUserLoginId());
        if(user != null) {
            if(bcrypt.isMatch(userDto.getUserPassword(), user.getUserPassword())) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public User createUser(User user) {
        user.setUserPassword(bcrypt.encrypt(user.getUserPassword()));
        return userRepository.save(user);
    }

}
