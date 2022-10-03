package com.example.rest_user_store.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

@Entity
@Table(name = "users")
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

    private String tags;

    private Integer expiry;

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

    public String[] getTags(){
        return this.tags.split(",");
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setTags(String[] tags){
        this.tags = tags.toString();
    }

    public void setExpiry(Integer expiry){
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "id: "+getId()+ "\n" +
                "name: "+ getFirstname()+" " +getLastname()+ "\n" +
                "phone: " + getPhone();
    }
}
