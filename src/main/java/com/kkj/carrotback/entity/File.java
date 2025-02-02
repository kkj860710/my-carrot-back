package com.kkj.carrotback.entity;

import com.kkj.carrotback.util.Common;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_FILE")
public class File extends BaseEntity {  // ✅ Basic 상속

    @Id
    @Column(name = "FILE_ID", nullable = false, unique = true)
    private String fileId;

    @Column(name = "FILE_ORIGIN_NAME", nullable = false)
    private String fileOriginName;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_PATH", nullable = false)
    private String filePath ;

    @Column(name = "FILE_TYPE", nullable = false)
    private String fileType;

    @Column(name = "FILE_SIZE", nullable = false)
    private Long fileSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;


    // 생성시 자동 userId 부여
    @PrePersist
    public void prePersistFile() {
        if (this.fileId == null || this.fileId.isEmpty()) {
            this.fileId = Common.generateUserId("FILE");
        }
    }
}
