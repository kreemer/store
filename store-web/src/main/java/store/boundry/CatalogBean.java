package store.boundry;

import store.control.repository.ProductRepository;
import store.entity.product.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CatalogBean implements Serializable {

    @EJB
    private ProductRepository productRepository;

    private String searchTerm;
    private List<Product> products = new ArrayList<>();

    public String search() {
        products = productRepository.findProductsByName(searchTerm);
        return "index.xhtml";
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
