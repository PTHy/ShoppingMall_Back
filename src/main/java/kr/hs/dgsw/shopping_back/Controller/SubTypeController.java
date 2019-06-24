package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.ProductSubType;
import kr.hs.dgsw.shopping_back.Domain.ProductType;
import kr.hs.dgsw.shopping_back.Service.SubTypeService;
import kr.hs.dgsw.shopping_back.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubTypeController {

    @Autowired
    private SubTypeService subTypeService;

    @GetMapping("/api/products/sub-types")
    public List<ProductSubType> subTypes() {
        return subTypeService.getAllSubTypes();
    }

    @GetMapping("/api/products/types/{typeId}/sub-types")
    public List<ProductSubType> subTypesByType(@PathVariable Long typeId) {
        return subTypeService.getSubTypeByType(typeId);
    }

    @PostMapping("/api/products/sub-types")
    public ProductSubType addSubType(@RequestBody ProductSubType subType) {
        return subTypeService.addSubType(subType);
    }

    @PutMapping("/api/products/sub-types/{id}")
    public ProductSubType modifySubType(@RequestBody ProductSubType subType, @PathVariable Long id) {
        return subTypeService.modifySubType(subType, id);
    }

    @DeleteMapping("/api/products/sub-types/{id}")
    public boolean deleteSubType(@PathVariable Long id) {
        return subTypeService.deleteSubType(id);
    }
}
