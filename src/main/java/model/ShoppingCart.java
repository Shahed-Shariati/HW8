package model;

public class ShoppingCart  {
    private int id;
    private Customer customer;
    private double sum;

    public ShoppingCart(int id, Customer customer, double sum) {
        this.id = id;
        this.customer = customer;
        this.sum = sum;
    }

}
