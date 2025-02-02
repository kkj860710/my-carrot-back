package com.kkj.carrotback.entity;

import com.kkj.carrotback.util.Common;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class User extends BaseEntity {  // ✅ Basic 상속

    @Id
    @Column(name = "USER_ID", nullable = false, unique = true)
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
    @Column(name = "USER_PHONE_NO", length = 20)
    private String userPhoneNo;

    @Column(name = "USER_BIRTH_DATE")
    private Instant userBirthDate;

    @Column(name = "ROLE", nullable = false)
    private String role;

    // 생성시 자동 userId 부여
    @PrePersist
    public void prePersistUser() {
        if (this.userId == null || this.userId.isEmpty()) {
            this.userId = Common.generateUserId("USER");
        }
    }
}
