package com.georgemst.aopdemo.dao;

import com.georgemst.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    // 03 - @afterReturning

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes ... simulate an exception
        if(tripWire){
            throw new RuntimeException("Tripwire is true n throwing an exception");
        }

        List<Account> accounts = new ArrayList<>();

        // create sample Accounts
        Account ac1 = new Account("John","Silver");
        Account ac2 = new Account("Madhu","Platinum");
        Account ac3 = new Account("Luca","Gold");

        // add them to our account list
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        return accounts;
    }
}
