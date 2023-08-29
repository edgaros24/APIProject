package lt.viko.eif.ejurkoit.restproject.project.controller;

import lt.viko.eif.ejurkoit.restproject.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Represents repository of the category
 * @see Category
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int categoryId);

}
