package kr.hs.dgsw.shopping_back.Repository;

import kr.hs.dgsw.shopping_back.Domain.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<ProductType, Long> {
}
