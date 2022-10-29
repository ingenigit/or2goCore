package com.or2go.core;

public class OrderAssignInfo {
    public String ordId;
    public String ordCust;
    //public String ordVendorId;
    public String ordStoreId;
    public String ordStoreName;
    public String ordStoreAddress;
    public String ordDeliveryPlace;
    public String ordDeliveryAddress;
    public String ordDescription;
    public String assignRequestTime;

    public OrderAssignInfo(String ordid, String cust, String storeid, String store, String vendaddr, String deliaddr, String deliplace, String reqtime){
        this.ordId = ordid;
        this.ordCust = cust;
        this.ordDeliveryPlace = deliplace;
        this.ordDeliveryAddress = deliaddr;
        this.ordStoreId = storeid;
        this.ordStoreName = store;
        this.ordStoreAddress = vendaddr;
        this.assignRequestTime = reqtime;
    }

    public void setVendorAddress(String vendaddr)
    {
        ordStoreAddress = vendaddr;
    }

    public void setDescription(String desc)
    {
        ordDescription = desc;
    }

    public String getOrderId() { return ordId;}
    public String getStoreId() { return ordStoreId;}
    public String getStore() { return ordStoreName;}
    public String getStoreAddress() { return ordStoreAddress;}
    public String getCustomer() { return ordCust;}
    public String getDeliAddr() { return ordDeliveryAddress;}
    public String getDeliPlace() { return ordDeliveryPlace;}
}
