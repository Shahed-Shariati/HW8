package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements Repository<User>{

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int save(User user) {
        String query = "INSERT INTO users(role_id,first_name,last_name,phone_number,address,user_name,password)" +
                "VALUES (?,?,?,?,?,?,?) RETURNING id";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user.getRole());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getPhoneNumber());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getUserName());
            preparedStatement.setString(7,user.getPassWord());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void upDate(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User findByUserName(String userName){
     String query = "SELECT * FROM users WHERE user_name = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new User(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
