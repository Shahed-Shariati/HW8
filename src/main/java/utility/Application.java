package utility;



import database.DatabaseConnection;
import model.Category;
import model.User;
import service.*;

import java.sql.Connection;
import static utility.Menu.*;

import java.util.List;
import java.util.Scanner;

public class Application {
    private Scanner input = new Scanner(System.in);
    private Connection connection = DatabaseConnection.getInstance().getConnection();
    private UserService userService = new UserService(connection);
    private CustomerService customerService = new CustomerService(connection);
    private AdministratorService administratorService = new AdministratorService(connection);
    private CategoryService categoryService = new CategoryService(connection);
    private ProductService productService = new ProductService(connection);

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
                   administratorMenu();
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
        }catch (NullPointerException e){
            System.out.println();
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

    private void administratorMenu(){
        while (true){
           adminMenu();
            String input = getUserInput();
            switch (input){
                case "1":
                   addProduct();
                    break;
                case "2":
                    break;
                case "3":
                    addCategory();
                    break;
                case "4":
                   addSubCategory();
                    break;
                case "5":
                    return;
            }
        }
    }


    private void addCategory(){
        System.out.println("Enter your category name:");
        String categoryName = getUserInput();
        if(categoryName.equalsIgnoreCase("Back")){
            System.out.println();
        }else {
            try{
                administratorService.saveCategoryParent("1", categoryName);
            }catch (NumberFormatException e){
                System.out.println("Id is wrong");
            }
        }
    }
    private void addSubCategory(){
        showParentCategory();
        System.out.println("Choice your parent category");
        String parentId = getUserInput();
        System.out.println("Enter your category name");
        String categoryName = getUserInput();
        try{
             administratorService.saveSubCategory("1",categoryName,parentId);
        }catch (NumberFormatException e){
            System.out.println("id is wrong");
        }catch (CategoryParentNotFound e){
            System.out.println(" Parent Category is not found");
        }


    }
    private void showParentCategory(){
        try {
            List<Category> categories = categoryService.findAll();
            for (Category item:categories) {
                System.out.println(item);

            }
        }catch (CategoryListNotFound e){
            System.out.println("List Not Found");
        }


    }
    private void addProduct(){
        System.out.println("Enter product name");
        String name = getUserInput();
        System.out.println("Enter price");
        String price = getUserInput();
        System.out.println("Enter stock");
        String stock = getUserInput();
        showSubCategory();
        System.out.println("Choice category");
        String categoryId = getUserInput();
        try {
         productService.save(name,price,stock,categoryId);
        }catch (NumberFormatException e){
            System.out.println("input is wrong");
        }catch (CategoryNotFound e){
            System.out.println("Category not found");
        }


    }
    private void showSubCategory(){
        try {
            List<Category> categories = categoryService.findSubCategory();
            for (Category item:categories) {
                System.out.println(item);

            }
        }catch (CategoryListNotFound e){
            System.out.println("List Not Found");
        }
    }

    private void editProduct(){
        
    }
    private String getUserInput() {
        return input.nextLine().trim();
    }
}
