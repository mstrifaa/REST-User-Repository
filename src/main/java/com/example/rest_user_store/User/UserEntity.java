package com.example.rest_user_store.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @SequenceGenerator(  //what do they do??
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Integer id;
    private String firstname;
    private String lastname;
    private String password;
    private String phone;

    public UserEntity(){}

    public UserEntity(String firstname, String lastname, String password, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "id: "+getId()+ "\n" +
                "name: "+ getFirstname()+" " +getLastname()+ "\n" +
                "phone: " +getPhone();
    }
}
