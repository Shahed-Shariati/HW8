package model;

public class Customer extends User{

    public Customer(int id, int role, String firstName, String lastName, String phoneNumber, String address, String userName, String passWord) {
        super(id, role, firstName, lastName, phoneNumber, address, userName, passWord);
    }
}
