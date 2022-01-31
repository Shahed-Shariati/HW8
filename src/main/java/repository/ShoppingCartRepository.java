package repository;

import model.ShoppingCart;

import java.util.List;

public class ShoppingCartRepository implements Repository<ShoppingCart>{
    @Override
    public int save(ShoppingCart shoppingCart) {
        return 0;
    }

    @Override
    public void upDate(ShoppingCart shoppingCart) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public ShoppingCart find(int id) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }
}
