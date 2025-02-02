package com.kkj.carrotback.entity;

import com.kkj.carrotback.util.Common;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_PRODUCT")
public class Product extends BaseEntity {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "PRODUCT_TITLE", nullable = false)
    private String productTitle;

    @Column(name = "PRODUCT_DESCRIPTION", nullable = false)
    private String productDescription;

    // 숫자로 분간, 카테고리 정하기.
    @Column(name = "PRODUCT_CATEGORY", nullable = false)
    private Long productCategory;

    @Column(name = "PRODUCT_LATITUDE")
    private float productLatitude;

    @Column(name = "PRODUCT_LONGITUDE")
    private float productLongitude;

    @Column(name = "PRODUCT_PRICE")
    private Long productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<File> fileList = new ArrayList<>();

    // ✅ 생성시 자동 userId 부여
    @PrePersist
    public void prePersistUser() {
        if (this.productId == null || this.productId.isEmpty()) {
            this.productId = Common.generateUserId("PRODUCT");
        }
    }
}
