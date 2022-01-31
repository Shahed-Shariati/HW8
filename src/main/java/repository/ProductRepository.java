package repository;

import model.Product;

import java.util.List;

public class ProductRepository implements Repository<Product>{
    @Override
    public int save(Product product) {
        return 0;
    }

    @Override
    public void upDate(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
