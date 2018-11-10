//Customer.java

//Customers to be stored in file as array list of customers

public class Customer {

    private String registrationNumber;
    private String loginPassword;
    private String name;
    private String phone;
    private String email;
    private GUI menu;

    //Getters
    public String getRegistrationNumber() {
        return registrationNumber;
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
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public Customer(String registrationNumber, String loginPassword, String name, String phone, String email, GUI menu){
        setRegistrationNumber(registrationNumber);
        setLoginPassword(loginPassword);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setMenu(menu);
    }


    public String toString(){
        return "Registration Number: " + getRegistrationNumber() + "\nPassword: " + getLoginPassword();
    }


}