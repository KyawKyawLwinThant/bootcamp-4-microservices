package com.example.apisecurity.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@ToString

public class User {
    @Id
    @Getter
    private Long id;
    @Getter
    @Setter
    @JsonProperty("first_name")
    private String firstName;
    @Getter
    @Setter
    @JsonProperty("last_name")
    private String lastName;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

    @MappedCollection private final Set<Token> tokens=new HashSet<>();
    @MappedCollection private final Set<PasswordRecovery> passwordRecoveries=
            new HashSet<>();

    public static User of(String firstName,String lastName,String email,
    String password){
        return new User(null,firstName,lastName,email,password,
                Collections.emptySet(),
                Collections.emptySet());
    }
    public User(){

    }
    public void addToken(Token token){
        this.tokens.add(token);
    }

    public void addPasswordRecovery(PasswordRecovery passwordRecovery){
        this.passwordRecoveries.add(passwordRecovery);
    }
    public boolean removePasswordRecovery(PasswordRecovery passwordRecovery){
        return this.passwordRecoveries.remove(passwordRecovery);
    }
    public Boolean removePasswordRecoveryIf(Predicate<? super PasswordRecovery> predicate){
        return this.passwordRecoveries.removeIf(predicate);
    }
    @PersistenceConstructor
    private User(Long id, String firstName, String lastName, String email, String password,
                 Collection<Token> tokens,
                 Collection<PasswordRecovery> passwordRecoveries) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.tokens.addAll(tokens);
        this.passwordRecoveries.addAll(passwordRecoveries);
    }
}
