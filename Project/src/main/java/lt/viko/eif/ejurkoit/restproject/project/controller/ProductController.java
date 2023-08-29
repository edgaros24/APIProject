package lt.viko.eif.ejurkoit.restproject.project.controller;


import lt.viko.eif.ejurkoit.restproject.project.model.Category;
import lt.viko.eif.ejurkoit.restproject.project.model.Product;
import lt.viko.eif.ejurkoit.restproject.project.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class is used for the GET, POST, PUT, DELETE methods
 */
@RestController
@RequestMapping("/products")
public class ProductController {
private final ProductRepository productRepository;
private final TypeRepository typeRepository;
private final CategoryRepository categoryRepository;

@Autowired
    public ProductController(ProductRepository productRepository,
                             TypeRepository typeRepository,
                             CategoryRepository categoryRepository){
    this.productRepository = productRepository;
    this.typeRepository = typeRepository;
    this.categoryRepository = categoryRepository;
}
@GetMapping
    public List<Product> getAllProducts(){
    return productRepository.findAll();
}
//Shows the products that are cheaper than any number
    @GetMapping("/cheaper-than")
    public List<Product> getProductsCheaperThan(@RequestParam int priceLimit) {
        return productRepository.findByPriceLessThan(priceLimit);
    }


    @GetMapping("/by-category")
    public List<Product> getProductsByCategory(@RequestParam int categoryId) throws ChangeSetPersister.NotFoundException {
        Category category = categoryRepository.findById(categoryId);
        if (category == null) {
            throw new ChangeSetPersister.NotFoundException();
        }

        return productRepository.findByCategory(category);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO productRequest) {
        // Create a new Product entity from the DTO
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());

        // Retrieve Type and Category objects based on the IDs
        Type type = typeRepository.findById(productRequest.getTypeId());
        Category category = categoryRepository.findById(productRequest.getCategoryId());

        product.setType(type);
        product.setCategory(category);

        // Save the product to the repository
        Product savedProduct = productRepository.save(product);

        // Return the saved product in the response with CREATED status
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
//This method updates the price of the product
    @PutMapping("/{id}/update-price")
    public ResponseEntity<String> updateProductPrice(@PathVariable int id, @RequestParam int newPrice) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Update the price of the existingProduct
            existingProduct.setPrice(newPrice);

            // Save the updated product
            productRepository.save(existingProduct);

            return ResponseEntity.ok("Product price updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//Deletes a product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // Delete the product
            productRepository.delete(product);

            return ResponseEntity.ok("Product deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
