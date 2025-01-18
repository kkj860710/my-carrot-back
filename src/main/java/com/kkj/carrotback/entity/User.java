package com.kkj.carrotback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "USER_LOGIN_ID", nullable = false, length = 50)
    private String userLoginId;

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

    @NotNull
    @Column(name = "USER_BIRTH_DATE", nullable = false)
    private Instant userBirthDate;

    @NotNull
    @Column(name = "CREATE_DATE", nullable = false)
    private Instant userCreateDate;

    @Column(name = "LAST_DATE")
    private Instant userLastDate;

}
