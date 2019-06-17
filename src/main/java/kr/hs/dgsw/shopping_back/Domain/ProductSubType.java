package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductSubType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long typeId;

    @Column(nullable = false)
    private String name;
}
