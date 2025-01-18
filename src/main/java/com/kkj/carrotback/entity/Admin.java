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
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_ADMIN")
public class Admin {

    @Id
    @Column(name = "ADMIN_ID", nullable = false)
    private String adminId;

    @Size(max = 50)
    @NotNull
    @Column(name = "ADMIN_LOGIN_ID", nullable = false, length = 50)
    private String admId;

    @Size(max = 50)
    @NotNull
    @Column(name = "ADM_PWD", nullable = false, length = 50)
    private String admPwd;

    @Size(max = 20)
    @Column(name = "ADM_PHONE_NO", length = 20)
    private String admPhoneNo;

    @Column(name = "ADM_BIRTH_DATE")
    private Instant admBirthDate;

    @NotNull
    @Column(name = "CREATE_DATE", nullable = false)
    private Instant admCreateDate;

    @Column(name = "LAST_DATE")
    private Instant admLastDate;
}
