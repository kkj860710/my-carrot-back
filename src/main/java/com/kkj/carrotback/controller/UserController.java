package com.kkj.carrotback.controller;

import com.kkj.carrotback.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.kkj.carrotback.service.UserService;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("createUser: {}", user);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/sign-in")
    public ResponseEntity<User> getUser(@RequestParam String id) {
        log.info("getUser: {}", id);
        User user = userService.getUserByUserLoginId(id);
        return ResponseEntity.ok(user);
    }

}
