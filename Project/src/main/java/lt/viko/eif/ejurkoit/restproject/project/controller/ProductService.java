package lt.viko.eif.ejurkoit.restproject.project.controller;

import lt.viko.eif.ejurkoit.restproject.project.controller.ProductRepository;
import lt.viko.eif.ejurkoit.restproject.project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service is used for getting product by ID
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
}
