package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository implements Repository<Product>{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(Product product) {
        String query = """
                INSERT INTO product (product_name,price,stock,category_id)
                VALUES (?,?,?,?) RETURNING id;
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getStock());
            preparedStatement.setInt(4,product.getCategory().getId());
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
