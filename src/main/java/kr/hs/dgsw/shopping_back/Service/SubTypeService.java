package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.ProductSubType;

import java.util.List;

public interface SubTypeService {
    ProductSubType addSubType(ProductSubType type);

    List<ProductSubType> getAllSubTypes();

    ProductSubType modifySubType(ProductSubType type, Long id);

    boolean deleteSubType(Long id);

    List<ProductSubType> getSubTypeByType(Long id);

    ProductSubType getSubType(Long id);
}
