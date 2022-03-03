package com.ding.pojo;

public class User {
    private Integer id;
    private String sname; // 昵称
    private String username; // 账号
    private String password;
    private String email;
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(){

    }
    public User(Integer id, String sname, String username, String password, String email) {
        this.id = id;
        this.sname = sname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
