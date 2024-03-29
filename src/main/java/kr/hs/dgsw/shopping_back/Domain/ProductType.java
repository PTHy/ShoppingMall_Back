package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String imagePath;
}
