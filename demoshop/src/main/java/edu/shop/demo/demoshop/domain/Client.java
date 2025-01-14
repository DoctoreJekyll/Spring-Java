package edu.shop.demo.demoshop.domain;


public class Client {

    private String userName;
    private String password;
    private String name;

    public Client(String username, String password, String name)
    {
        this.userName = username;
        this.password = password;
        this.name = name;
    }

    public Client()
    {

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

}
