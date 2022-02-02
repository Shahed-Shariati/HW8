package repository;

import model.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShoppingCartRepository implements Repository<ShoppingCart>{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ShoppingCartRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(ShoppingCart shoppingCart) {
        String query = """
                INSERT INTO shopping (customer_id,total) VALUES (?,?) RETURNING id;
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,shoppingCart.getCustomer().getId());
            preparedStatement.setDouble(2,shoppingCart.getSum());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void upDate(ShoppingCart shoppingCart) {
     String query = """
             UPDATE shopping SET  total = ? WHERE id = ?;
             """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,shoppingCart.getSum());
            preparedStatement.setInt(2,shoppingCart.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
