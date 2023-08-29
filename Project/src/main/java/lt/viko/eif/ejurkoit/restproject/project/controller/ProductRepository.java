package lt.viko.eif.ejurkoit.restproject.project.controller;

import lt.viko.eif.ejurkoit.restproject.project.model.Category;
import lt.viko.eif.ejurkoit.restproject.project.model.Product;
import lt.viko.eif.ejurkoit.restproject.project.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Represents repositories for the products
 * @see Product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(int maxPrice);
    List<Product> findByCategory(Category category);
    List<Product> findByType(Type type);
}
