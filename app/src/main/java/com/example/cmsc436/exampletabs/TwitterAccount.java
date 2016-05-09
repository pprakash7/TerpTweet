package com.example.cmsc436.exampletabs;

/**
 * Created by Katherine Larson on 4/15/2016.
 */


public class TwitterAccount implements Comparable{

    private String accountName, idName;
    private Long id;

    public TwitterAccount(String accountName, Long id, String idName) {
        this.accountName = accountName;
        this.id = id;
        this.idName = idName;
    }
    public String getAccountName() {
        return accountName;
    }

    public Long getID() {
        return id;
    }

    public String getIdName() {
        return idName;
    }

    public int compareTo(Object o) {
        TwitterAccount toCompare = (TwitterAccount) o;
        return this.accountName.compareTo(toCompare.getAccountName());
    }
}
