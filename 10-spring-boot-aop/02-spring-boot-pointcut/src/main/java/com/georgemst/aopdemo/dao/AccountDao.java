package com.georgemst.aopdemo.dao;

import com.georgemst.aopdemo.Account;

public interface AccountDao {
    void addAccount(Account account, boolean VIPflag);

    void doWork();

    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
    String getName();
}
