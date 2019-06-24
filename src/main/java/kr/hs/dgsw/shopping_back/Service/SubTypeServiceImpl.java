package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.ProductSubType;
import kr.hs.dgsw.shopping_back.Repository.SubTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubTypeServiceImpl implements SubTypeService{

    @Autowired
    private SubTypeRepository subTypeRepository;

    @Override
    public ProductSubType addSubType(ProductSubType subType) {
        return this.subTypeRepository.save(subType);
    }

    @Override
    public List<ProductSubType> getAllSubTypes() {
        return this.subTypeRepository.findAll();
    }

    @Override
    public ProductSubType modifySubType(ProductSubType subType, Long id) {
        return this.subTypeRepository.findById(id)
                .map(fst -> {
                    if (subType.getName() != null)
                        fst.setName(subType.getName());
                    if (subType.getTypeId() != null)
                        fst.setTypeId(subType.getTypeId());

                    return this.subTypeRepository.save(fst);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteSubType(Long id) {
        return this.subTypeRepository.findById(id)
                .map(fst -> {
                    this.subTypeRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<ProductSubType> getSubTypeByType(Long typeId) {
        return this.subTypeRepository.findAllByTypeId(typeId);
    }
}
