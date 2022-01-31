package utility;



import database.DatabaseConnection;
import model.Customer;
import model.User;
import service.CustomerService;
import service.UserService;

import java.sql.Connection;
import static utility.Menu.*;

import java.text.ParseException;
import java.util.Scanner;

public class Application {
    private Scanner input = new Scanner(System.in);
    private Connection connection = DatabaseConnection.getInstance().getConnection();
    private UserService userService = new UserService(connection);
    private CustomerService customerService = new CustomerService(connection);

    public Application() {

        runApplication();
    }

    public void runApplication(){
        while (true){
            loginMenu();
            System.out.println("Choice");
            String input = getUserInput();
           switch (input){
               case "1":
                  login();
                   break;
               case "2":
                   singUp();
                   break;
               case "3":
                   return;
               default:
                   System.out.println();
           }
        }
    }

    private void login() {
        System.out.println("Enter user name and password (admin admin)");
        String[] input = getUserInput().trim().split(" +");
        try{
            if(input[0].equalsIgnoreCase("back")){
                System.out.println();
            }else if(input.length == 2){
               User user = userService.login(input[0],input[1]);
                if(user.getRole() == 1){

                }else if(user.getRole() == 2){
                    System.out.println("customer");
                }

            }else {
                System.out.println();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("your input is wrong");
        }catch (UserNotFoundException e){
            System.out.println("there is no user with this username");
        }

    }


    private void singUp(){
        System.out.println();
        System.out.println("Enter your name");
        String firstName = getUserInput();
        System.out.println("Enter your Last Name");
        String lastName = getUserInput();
        System.out.println("enter your phone number");
        String phoneNumber = getUserInput();
        System.out.println("enter your address");
        String address = getUserInput();
        System.out.println("Enter your username: ");
        String username = getUserInput();
        System.out.println("Enter your password: ");
        String password = getUserInput();
        System.out.println("Enter your balance: ");
        String balance = getUserInput();
        try {
          int userId = userService.save("2",firstName,lastName,phoneNumber,address,username,password);
          if(userId != 0){
           customerService.add(userId,balance);
              System.out.println("User Create Success");
          }else {
              System.out.println("Can t create user");
          }

        }catch (ValidationDigitPhoneNumber e){
            System.out.println("---------phone number is not digit------------");
        }catch (ValidationLengthPhoneNumber e)
        {
            System.out.println("---------phone number length is not valid------");
        }catch (NumberFormatException e){
            System.out.println("-------------your role or balance is wrong----------------");
        }

    }
    private String getUserInput() {
        return input.nextLine().trim();
    }
}
