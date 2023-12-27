package com.or2go.core;

public class StoreLoginInfo {
    String vendorid, storeid, deviceid, logintime, sessionid;
    Integer loginmode;

    public StoreLoginInfo(String vendorid, String storeid, Integer loginmode) {
        this.vendorid = vendorid;
        this.storeid = storeid;
        this.loginmode = loginmode;
    }

    public String getVendorid() {
        return vendorid;
    }

    public String getStoreid() {
        return storeid;
    }

    public Integer getLoginmode() {
        return loginmode;
    }
}
