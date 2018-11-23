//Customer.java

//Customers to be stored in file as array list of customers

import java.io.Serializable;

public class Customer implements Serializable { //JB added code to ensure Customer objects could be saved successfully

    private String userName;
    private String loginPassword;
    private String name;
    private String phone;
    private String email;
    private GUI menu;

    //Getters
    public String getUserName() {
        return userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getNsme() { return name; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public GUI getMenu() {
        return menu;
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setEmail(String email) { this.email = email; }

    public void setMenu(GUI menu) {
        this.menu = menu;
    }

    //No arg Constructor

    public Customer() {
        this("No Registration Entered","No Password Entered","name","No Phone Number Listed","No Email found",null);
    }

    public Customer(String userName, String loginPassword, String name, String phone, String email, GUI menu){
        setUserName(userName);
        setLoginPassword(loginPassword);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setMenu(menu);
    }


    public String toString(){
        return "Registration Number: " + getUserName() + "\nPassword: " + getLoginPassword();
    }


}