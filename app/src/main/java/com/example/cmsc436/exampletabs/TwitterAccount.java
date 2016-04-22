package com.example.cmsc436.exampletabs;

/**
 * Created by Katherine Larson on 4/15/2016.
 */


public class TwitterAccount {

    private String accountName, idName;
    private int id;

    public TwitterAccount(String accountName, int id, String idName) {
        this.accountName = accountName;
        this.id = id;
        this.idName = idName;
    }
    public String getAccountName() {
        return accountName;
    }

    public int getID() {
        return id;
    }

    public String getIdName() {
        return idName;
    }

}
