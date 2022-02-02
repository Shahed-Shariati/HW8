package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    private static Connection connection = DatabaseConnection.getInstance().getConnection();
    private static PreparedStatement preparedStatement;
    public CreateTable(){
    //createTableRole();
   // createTableUser();
  //  insertIntoRole();
  //  createTableCustomer();
   // createTableCategory();
    //  createTableProduct();
        createTableShoppingCart();
         createTableItemCart();
    }





  private void createTableUser()
  {
      String query = "CREATE TABLE IF NOT EXISTS users(\n" +
              "                id SERIAL PRIMARY KEY,\n" +
              "                role_id INTEGER,\n" +
              "                first_name VARCHAR(100),\n" +
              "                last_name VARCHAR(100),\n" +
              "                phone_number VARCHAR(20),\n" +
              "                address VARCHAR(200)," +
              "                user_name VARCHAR (50)," +
              "                password VARCHAR (50),\n" +
              "                FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE );";
      try {
          preparedStatement = connection.prepareStatement(query);
          preparedStatement.execute();
          preparedStatement.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }

    private void createTableRole(){
        String createTableRoleQuery = "CREATE TABLE IF NOT EXISTS role(\n" +
                "    id SERIAL PRIMARY KEY ,\n" +
                "    role_name VARCHAR (50)\n" +
                ");";
        try {
            preparedStatement = connection.prepareStatement(createTableRoleQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }

    }
    private void insertIntoRole()
    {
        String insertQuery = "insert into role(role_name) values ('Administrator'),('customer');";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }


    private void createTableCustomer()
    {

        String query = "CREATE TABLE IF NOT EXISTS customer(" +
                "id SERIAL PRIMARY KEY," +
                "user_id INTEGER," +
                "balance DOUBLE PRECISION," +
                "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE );" +
                "";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   private void createTableCategory(){
        String query = """
                 CREATE TABLE IF NOT EXISTS category(
                 id SERIAL PRIMARY KEY,
                 ctaegory_name VARCHAR (50),
                 category_id INTEGER ,
                 FOREIGN KEY (category_id) REFERENCES  category(id) ON DELETE CASCADE 
                 );
                """;
       try {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   private void createTableProduct(){
        String query = """
                  CREATE TABLE IF NOT EXISTS product(
                  id SERIAL PRIMARY KEY,
                  product_name VARCHAR(70), 
                  price DOUBLE PRECISION,
                  stock INTEGER ,
                  category_id INTEGER ,
                  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE 
                  );     
                """;
       try {
           preparedStatement = connection.prepareStatement(query);
           preparedStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

    private void createTableShoppingCart(){
        String query = """
                  CREATE TABLE IF NOT EXISTS Shopping(
                  id SERIAL PRIMARY KEY,
                  customer_id INTEGER , 
                  total DOUBLE PRECISION,
                  status INTEGER ,
                  FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE 
                  );     
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void createTableItemCart(){
        String query = """
                  CREATE TABLE IF NOT EXISTS itemcart(
                  id SERIAL PRIMARY KEY,
                  product_id INTEGER , 
                  cart_id INTEGER ,
                  quantity INTEGER ,
                  sum DOUBLE PRECISION,
                  FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE, 
                  FOREIGN KEY (cart_id) REFERENCES shopping(id) ON DELETE CASCADE 
                  );     
                """;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    }

