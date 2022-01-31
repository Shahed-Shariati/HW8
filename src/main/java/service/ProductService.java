package service;

import model.Category;
import model.Product;
import repository.ProductRepository;

import java.sql.Connection;

public class ProductService {
    private Connection connection;
    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(Connection connection) {
        this.connection = connection;
        this.productRepository = new ProductRepository(connection);
        this.categoryService = new CategoryService(connection);
    }

    public int save(String name,String price,String stock,String categoryId){
        double priceDouble = Double.parseDouble(price);
        int stockInt = Integer.parseInt(stock);
        Category category = categoryService.find(categoryId);
        Product product = new Product(1,name,priceDouble,stockInt,category);
        return productRepository.save(product);
    }
}
