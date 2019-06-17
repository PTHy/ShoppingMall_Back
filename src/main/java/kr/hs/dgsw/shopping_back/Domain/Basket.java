package kr.hs.dgsw.shopping_back.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long productId;
}
