package com.or2go.core;

public class OrderDeliveryInfo {
    public String orderid;
    public String daid;
    public String daname;
    public String dacontact;
    public String delitime;
    public Integer delistatus;

    public OrderDeliveryInfo(String oid, String did, String name, String contact, String time, Integer sts)
    {
        orderid=oid;
        daid= did;
        daname = name;
        dacontact=contact;
        delitime =time;
        delistatus=sts;
    }

    public String getDAName() {return daname;}
    public String getDAContact() {return dacontact;}

    public String getDeliveryTime() {return delitime;}
    public Integer getDeliveryStatus() {return delistatus;}
}
