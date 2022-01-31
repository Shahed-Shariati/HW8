package model;

public class Customer extends User{
    private int id;
    private double balance;
    public Customer(int id, int role, String firstName, String lastName, String phoneNumber, String address, String userName, String passWord,double balance) {
        super(id, role, firstName, lastName, phoneNumber, address, userName, passWord);
        this.balance = balance;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
