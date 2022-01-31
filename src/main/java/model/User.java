package model;
 public class User {
  private int id;
  private int role;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String userName;
  private String passWord;

  public User(int id, int role, String firstName, String lastName, String phoneNumber, String address, String userName, String passWord) {
   this.id = id;
   this.role = role;
   this.firstName = firstName;
   this.lastName = lastName;
   this.phoneNumber = phoneNumber;
   this.address = address;
   this.userName = userName;
   this.passWord = passWord;
  }
 }
