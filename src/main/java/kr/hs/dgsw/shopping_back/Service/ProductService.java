package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(Product product);

    Product modifyProduct(Product product, Long id);

    boolean deleteProduct(Long id);
}
