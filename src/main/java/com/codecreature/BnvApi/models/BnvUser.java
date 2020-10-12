package com.codecreature.BnvApi.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Collection;

@Entity    // JPA (Java Persistence API) this maps BnvUser to table named BnvUser
@NamedQuery(name="find_all_users", query="select u from BnvUser u")    // JPQL (Java Persistence Query Language)
@NamedQuery(name="find_valid_user", query="select u from BnvUser u where u.username = :username")
public class BnvUser implements UserDetails{

    @Id                 // Hibernate sets Primary Key
//    @GeneratedValue     // Hibernate generates the id.
    private int id;
    private String username;
    private String email;
    private String password;

    public BnvUser(){}

    public BnvUser(int id, String username, String email, String password){
        this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public BnvUser(String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public BnvUser(String username, String password){
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String toString(){
        return String.format("\nBnvUser [id=%s, username=%s, email=%s, password=%s]", id,username,email,password);
    }

}
