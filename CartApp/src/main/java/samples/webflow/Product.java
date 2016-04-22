package samples.webflow;

import java.io.Serializable;

/**
 * Created by vonzhou on 16/4/21.
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1951520003958305899L;
    private int id;
    private String description;
    private int price;

    public Product(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
