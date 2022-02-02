package model;

import java.util.ArrayList;

public class ShoppingCart  {
    private Integer id;
    private Customer customer;
    private Double sum;
    private ArrayList<ItemCart> itemCarts;

    public ShoppingCart(Integer id, Customer customer, double sum) {
        this.id = id;
        this.customer = customer;
        this.sum = sum;
        this.itemCarts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public ArrayList<ItemCart> getItemCarts() {
        return itemCarts;
    }

    public void setItemCarts(ArrayList<ItemCart> itemCarts) {
        this.itemCarts = itemCarts;
    }
}
