package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.ProductType;

import java.util.List;

public interface TypeService {
    List<ProductType> getAllTypes();

    ProductType modifyType(ProductType type, Long id);

    boolean deleteType(Long id);

    ProductType addType(ProductType type);
}
