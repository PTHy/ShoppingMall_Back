package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private String name;

    private String detailInfo;

    private String buyInfo;

    @Column(nullable = false)
    private Long typeId;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Long subTypeId;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
