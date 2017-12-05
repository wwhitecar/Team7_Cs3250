package com.team7.app.business.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AccountsDto {

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
    private int accountId;

    public AccountsDto() {

    }

    public AccountsDto(String username, String password, int accountId){

    }
}
