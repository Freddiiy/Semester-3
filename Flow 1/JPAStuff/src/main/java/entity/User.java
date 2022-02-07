package entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String fname;

    private String lname;

    // Column behøves ikke med mindre din value her er anderledes end på databasen.
    @Column(name = "pw", nullable = false)
    private String password;

    private String phone;

    private String address;

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public User(String fname, String lname, String phone, String address) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
    }

    public User(String fname, String lname, String password, String phone, String address) {
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getName() {
        return new String[]{fname, lname};
    }

    public String[] getDetails() {
        return new String[]{phone, address};
    }
}
