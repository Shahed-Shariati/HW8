package service;

import model.Category;
import model.Product;
import repository.ProductRepository;
import utility.ProductListNotFoundException;
import utility.ProductNotFound;

import java.sql.Connection;
import java.util.List;

public class ProductService implements Service<Product>{
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


    @Override
    public Product find(int id) {

        Product product = productRepository.find(id);
        if(product == null){
            throw new ProductNotFound("Product not found");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
         return productRepository.findAll();
    }

    @Override
    public void upDate(Product product) {
        productRepository.upDate(product);
    }

    public List<Product> findAllByCategoryId(int id){
        List<Product> productList = productRepository.findAllByCategoryId(id);
        if(productList == null){
            throw new ProductListNotFoundException();
        }
        return productList;
    }
}
