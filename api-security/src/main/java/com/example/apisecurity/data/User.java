package com.example.apisecurity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

@ToString
@Getter
@Setter
public class User {
    @Id
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    private String email;
    private String password;

    public static User of(String firstName,String lastName,String email,
    String password){
        return new User(null,firstName,lastName,email,password);
    }
    public User(){

    }
    @PersistenceConstructor
    private User(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
