package repository;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepository implements Repository<Customer>{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CustomerRepository(Connection connection) {
        this.connection = connection;
    }


    public int add(int userId,double balance){
        String query = "INSERT INTO customer (user_id,balance) VALUES (?,?) RETURNING id";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            preparedStatement.setDouble(2,balance);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int save(Customer customer) {

        String query = "INSERT INTO customer (user_id,balance) VALUES (?,?) RETURNING id";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setDouble(2,customer.getBalance());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void upDate(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Customer find(int id) {
        String query = """
                SELECT * FROM customer  WHERE  id= ?;
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapTo(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    public Customer findByUserId(int id){
        String query = """
                SELECT * FROM customer INNER JOIN users u on u.id = customer.user_id
                                                         WHERE u.id = ?;
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
             return mapTo(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    private Customer mapTo(ResultSet resultSet){
        try {
            while (resultSet.next()) {
                return new Customer(resultSet.getInt(4),
                        resultSet.getInt("role_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("address"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        resultSet.getDouble("balance"),
                        resultSet.getInt(1));
            }
        }catch (SQLException e){
           e.printStackTrace();
        }
        return null;
    }
}
