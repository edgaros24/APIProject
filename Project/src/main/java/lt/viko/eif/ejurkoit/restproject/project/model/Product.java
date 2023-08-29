package lt.viko.eif.ejurkoit.restproject.project.model;

import jakarta.persistence.*;

/**
 * Main object of the project
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String name;
    protected int price;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TypeID")
    protected Type type;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CategoryID")
    protected Category category;

    /**
     *
     * @param name String name of the product
     * @param price int price of the product
     * @param type class of the type
     * @param category class of the category
     */
    public Product(String name, int price, Type type, Category category) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.category = category;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
