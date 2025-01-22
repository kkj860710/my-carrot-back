package com.kkj.carrotback.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Size(max = 50)
    @Column(name = "USER_LOGIN_ID", nullable = false, length = 500)
    private String userLoginId;

    @Column(name = "USER_PASSWORD", nullable = false, length = 500)
    private String userPassword;

    @Size(max = 50)
    @Column(name = "USER_EMAIL", length = 50)
    private String userEmail;

    @Size(max = 30)
    @NotNull
    @Column(name = "USER_NAME", nullable = false, length = 30)
    private String userName;

    @Size(max = 20)
    @Column(name = "USER_PHONE_NO", length = 2)
    private String userPhoneNo;


    @Column(name = "USER_BIRTH_DATE")
    private Instant userBirthDate;


    @Column(name = "CREATE_DATE", nullable = false)
    private Instant userCreateDate;

    @Column(name = "LAST_UPDATE")
    private Instant userLastDate;

    @Column(name = "ROLE", nullable = false)
    private String role;

//    생성시 자동 시간 입력, 프론트에서 처리 필요 없음
    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.userCreateDate = now;
        this.userLastDate = now;

        // userId 무작위 생성
        if(this.userId == null || this.userId.isEmpty()) {
            this.userId = generateUserId();
        }

    }

    private String generateUserId() {
        // 날짜 부분 생성
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        // 유니크한 넘버 생성
        String uniqueNumber = String.format("%04d", (int) (Math.random() * 10000));
        return "USER" + date + uniqueNumber;
    }

    // 업데이트시 자동 시간 업데이트, 프론트에서 처리 필요 없음
    @PreUpdate
    public void preUpdate() {
        this.userLastDate = Instant.now();
    }

}
