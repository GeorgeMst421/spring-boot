package com.georgemst.aopdemo.dao;

import com.georgemst.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(Account account,boolean VIPflag) {
        System.out.println(getClass()+" DOING MY DB WORK. ADDING AN ACCOUNT");
    }

    @Override
    public void doWork() {
        System.out.println("I am doing a work at AccountDao");
    }
}
