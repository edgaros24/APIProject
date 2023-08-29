package lt.viko.eif.ejurkoit.restproject.project.model;

import jakarta.persistence.*;

/**
 * Represents category of product
 *
 * @author Edgar
 * @see Product
 * @since 1.0
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
protected int id;
protected String category;


    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
