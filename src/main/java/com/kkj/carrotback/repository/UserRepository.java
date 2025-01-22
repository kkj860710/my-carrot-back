package com.kkj.carrotback.repository;

import com.kkj.carrotback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUserLoginId(String userLoginId);

}
