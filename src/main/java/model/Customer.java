package model;

import java.util.ArrayList;

public class Customer extends User{
    private int id;
    private double balance;
    private ArrayList<ShoppingCart> shoppingCarts;
    public Customer(int id, int role, String firstName, String lastName, String phoneNumber, String address, String userName, String passWord,double balance,int customerid) {
        super(id, role, firstName, lastName, phoneNumber, address, userName, passWord);
        this.balance = balance;
        this.id = customerid;
        this.shoppingCarts = new ArrayList<>();
    }



    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ArrayList<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
