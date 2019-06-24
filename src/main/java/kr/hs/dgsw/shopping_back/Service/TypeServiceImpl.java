package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.ProductType;
import kr.hs.dgsw.shopping_back.Repository.SubTypeRepository;
import kr.hs.dgsw.shopping_back.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<ProductType> getAllTypes() {
        return this.typeRepository.findAll();
    }

    @Override
    public ProductType modifyType(ProductType type, Long id) {
        return this.typeRepository.findById(id)
                .map(ft -> {
                    if (type.getName() != null)
                        ft.setName(type.getName());
                    if (type.getImagePath() != null)
                        ft.setImagePath(type.getImagePath());

                    return this.typeRepository.save(ft);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteType(Long id) {
        return this.typeRepository.findById(id)
                .map(ft -> {
                    this.typeRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public ProductType addType(ProductType type) {
        return this.typeRepository.save(type);
    }
}
