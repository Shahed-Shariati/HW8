package service;

import model.ShoppingCart;
import repository.ShoppingCartRepository;

import java.sql.Connection;
import java.util.List;

public class ShoppingService implements Service<ShoppingCart>{
    private Connection connection;
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingService(Connection connection) {
        this.connection = connection;
        this.shoppingCartRepository = new ShoppingCartRepository(connection);
    }

    public int save(ShoppingCart shoppingCart){
       return  shoppingCartRepository.save(shoppingCart);
      }



    @Override
    public ShoppingCart find(int id) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }

    @Override
    public void upDate(ShoppingCart shoppingCart) {

    }
}
