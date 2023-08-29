package lt.viko.eif.ejurkoit.restproject.project.model;

import jakarta.persistence.*;

/**
 * Represents type (dog, cat) of the product
 *
 * @author Edgar
 * @see Product
 * @since 1.0
 */
@Entity
@Table
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String type;

    /**
     *
     * @param id id of type
     * @param type String type of animal
     */
    public Type(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Type() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
