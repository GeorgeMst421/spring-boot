package com.georgemst.aopdemo.dao;

import com.georgemst.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account, boolean VIPflag);
    void doWork();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    String getName();

    // 03- AfterReturning

    List<Account> findAccounts();

    // afterThrowing
    List<Account> findAccounts(boolean tripWire);
}
