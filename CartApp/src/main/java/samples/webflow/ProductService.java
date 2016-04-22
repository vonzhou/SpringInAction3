package samples.webflow;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题记录:@Service("productService")得到的productService在flow执行的时候出现了异常:
 * org.springframework.expression.spel.SpelEvaluationException: EL1008E:(pos 0): Property or field 'productService' cannot be found on object of type 'org.springframework.webflow.engine.impl.RequestControlContextImpl' - maybe not public?
 * 然后显示的在flow中创建productService变量就OK了.
 *
 * 注意要实现Serializable接口,否则 java.io.NotSerializableException: samples.webflow.ProductService
 *
 * Created by vonzhou on 16/4/21.
 */
//@Service("productService")
public class ProductService implements Serializable {
    private static final long serialVersionUID = 1951520003958305899L;
    /*products 用于存放多个商品 */
    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public ProductService() {
        products.put(1, new Product(1, "Bulldog", 1000));
        products.put(2, new Product(2, "Chihuahua", 1500));
        products.put(3, new Product(3, "Labrador", 2000));
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products.values());
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}
