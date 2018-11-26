//Customer.java

//Customers to be stored in file as array list of customers

import javax.swing.*;
import java.io.Serializable;

public class Customer implements Serializable { //JB added code to ensure Customer objects could be saved successfully

    private String userName;
    private String loginPassword;
    private String name;
    private String phone;
    private String email;
    private float accountBalance;


    //Getters
    public String getUserName() {
        return userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getName() { return name; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public float getAccountBalance() {
        return accountBalance;
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) {

        if(phone.length() != 10 && phone.matches("[a-zA-Z]+")){
            setPhone(JOptionPane.showInputDialog(null,"Please re-enter your phone number: (Should be 10 numbers)"));
        }else{

        }
        this.phone = phone;

    }



    public void setEmail(String email) { this.email = email; }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    //No arg Constructor

    public Customer() {
        this("No Registration Entered","No Password Entered","name","No Phone Number Listed","No Email found",0f);
    }

    public Customer(String userName, String loginPassword, String name, String phone, String email, float accountBalance){
        setUserName(userName);
        setLoginPassword(loginPassword);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAccountBalance(accountBalance);
    }


    public String toString(){
        return /*"Name: "  + getName() +  "\nPhone Number: "  + getPhone() + "\nEmail" + getEmail() + */"User Name: " + getUserName() + "\nPassword: " + getLoginPassword();
    }



}