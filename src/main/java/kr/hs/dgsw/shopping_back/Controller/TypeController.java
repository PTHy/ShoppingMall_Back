package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.ProductType;
import kr.hs.dgsw.shopping_back.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/api/products/types")
    public List<ProductType> types() {
        return typeService.getAllTypes();
    }

    @GetMapping("/api/products/types/{id}")
    public ProductType getType(@PathVariable Long id) {
        return typeService.getType(id);
    }

    @PostMapping("/api/products/types")
    public ProductType addType(@RequestBody ProductType type) {
        return typeService.addType(type);
    }

    @PutMapping("/api/products/types/{id}")
    public ProductType modifyType(@RequestBody ProductType type, @PathVariable Long id) {
        return typeService.modifyType(type, id);
    }

    @DeleteMapping("/api/products/types/{id}")
    public boolean deleteType(@PathVariable Long id) {
        return typeService.deleteType(id);
    }
}
