package com.georgemst.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao{
    @Override
    public boolean addSillyAccount() {
        System.out.println(getClass()+" This is the membershipDAO doing it's work");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("I am going to sleep MemberShipDAO");
    }
}
