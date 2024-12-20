package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("full_name")
    private String full_name;

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
    //LOMBOK DOESN'T WORK FOR OTHER FIELD ,
    // WORKS JUST FOR FULL NAME AND IT PRINTS TWICE IN THE JSON RESPONSE
//    public String getFullName() {
//        return full_name;
//    }



}
