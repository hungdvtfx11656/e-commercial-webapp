package model;

public class Account {

    private String usr, pwd;
    /*
    Role set:
    0 - Admin
    1 - Standard customer
     */
    private int role;
    private String name, address, phone;
    /*
    Check set:
    0 - Logged in
    1 - Logged out
     */
    private int check;

    public Account() {
        this.role = 1;
        this.check = 1;
    }

    public Account(String usr, String pwd, String name, String address, String phone) {
        super();
        this.usr = usr;
        this.pwd = pwd;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

}
