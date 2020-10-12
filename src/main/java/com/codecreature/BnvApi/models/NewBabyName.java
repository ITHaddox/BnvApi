package com.codecreature.BnvApi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NewBabyName {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private boolean isGirl;

    public NewBabyName(){

    }

    public NewBabyName(long id, String username, String name, boolean isGirl){
        this.id = id;
        this.username = username;
        this.name = name;
        this.isGirl = isGirl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }

    @Override
    public String toString(){
        return String.format("\nID: %s, Username: %s, Name: %s, Votes: %s, Date: %s" +
                " , Is Gril: %s", id, username, name, isGirl);
    }
}
