package com.georgemst.aopdemo.dao;

import com.georgemst.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account,boolean VIPflag) {
        System.out.println(getClass()+" DOING MY DB WORK. ADDING AN ACCOUNT");
    }

    @Override
    public void doWork() {
        System.out.println("I am doing a work at AccountDao");
    }


    @Override
    public String getName() {
        System.out.println("AccountDao get name" );
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("AccountDao set name" );
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println("AccountDao get service code");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println("AccountDao set serviceCode");
        this.serviceCode = serviceCode;
    }
}
