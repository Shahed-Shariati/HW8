package utility;

public class Menu {
    private static String dotted = "---------------------------------------------------";
    public static void loginMenu(){
        System.out.println();
        System.out.println("1:Login");
        System.out.println("2:Sing up");
        System.out.println("3:Exit");
        System.out.println(dotted);

    }
    public static void adminMenu(){
        System.out.println();
        System.out.println("1:Add Product");
        System.out.println("2:Edit Product");
        System.out.println("3:Add Category");
        System.out.println("4:Add sub Category");
        System.out.println("5:Exit");
        System.out.println(dotted);
    }
}
