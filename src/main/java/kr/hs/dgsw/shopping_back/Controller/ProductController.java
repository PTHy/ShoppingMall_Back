package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getAllProducts () {
        return this.productService.getAllProducts();
    }

    @PostMapping("/api/products")
    public Product addProduct (@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @PutMapping("/api/products/{id}")
    public Product modifyProduct (@RequestBody Product product, @PathVariable Long id) {
        return this.productService.modifyProduct(product, id);
    }

    @DeleteMapping("/api/products/{id}")
    public boolean deleteProduct (@PathVariable Long id) {
        return this.productService.deleteProduct(id);
    }
}
