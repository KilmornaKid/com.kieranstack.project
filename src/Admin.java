public class Admin {
    private String adminName;
    private String adminPassword;

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Admin(){
        this("No Username","1234");
    }

    public  Admin(String adminName, String adminPassword){
        setAdminName(adminName);
        setAdminPassword(adminPassword);
    }

    public String toString(){
        return "Admin Username: " + getAdminName() + "Admin Password: " + getAdminPassword();
    }
}
