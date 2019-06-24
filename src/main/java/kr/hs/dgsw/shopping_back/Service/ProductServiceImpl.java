package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product modifyProduct(Product product, Long id) {
        return this.productRepository.findById(id)
                .map(fp -> {
                    if (product.getBuyInfo() != null)
                        fp.setBuyInfo(product.getBuyInfo());
                    if (product.getCost() != null)
                        fp.setCost(product.getCost());
                    if (product.getDetailInfo() != null)
                        fp.setDetailInfo(product.getDetailInfo());
                    if (product.getTypeId() != null)
                        fp.setTypeId(product.getTypeId());
                    if (product.getSubTypeId() != null)
                        fp.setSubTypeId(product.getSubTypeId());

                    return this.productRepository.save(fp);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return this.productRepository.findById(id)
                .map(fp -> {
                    this.productRepository.deleteById(id);
                    return true;
                })
                .orElse( false );
    }
}
