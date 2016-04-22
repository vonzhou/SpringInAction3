package samples.webflow;

import java.io.Serializable;

/**
 * Created by vonzhou on 16/4/21.
 */
public class CartItem implements Serializable {
    private static final long serialVersionUID = 8388627124326126637L;
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return this.quantity * this.product.getPrice();
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
