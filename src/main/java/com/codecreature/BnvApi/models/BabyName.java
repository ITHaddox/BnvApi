package com.codecreature.BnvApi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQuery(name="find_names_by_username", query="select b from BabyName b where b.username = :username")
public class BabyName {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String name;
    private int votes;
    private Date initDate;
    private boolean isGirl;

    public BabyName(){

    }

    public BabyName(String username, String name){
        this.username = username;
        this.name = name;
        this.votes = 0;
    }

    public BabyName(long id, String username, String name, int votes, Date initDate, boolean isGirl){
        this.id = id;
        this.username = username;
        this.name = name;
        this.votes = votes;
        this.initDate = initDate;
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

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        this.isGirl = girl;
    }

    @Override
    public String toString(){
        return String.format("\nID: %s, Username: %s, Name: %s, Votes: %s, Date: %s" +
                " , Is Girl: %s", id, username, name, votes, initDate, isGirl);
    }
}
