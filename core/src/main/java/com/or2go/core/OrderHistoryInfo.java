package com.or2go.core;

import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ACCEPT_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCELLED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCEL_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CHARGE_CONFIRM_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_COMPLETE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CONFIRMED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_DECLINE_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_DELIVERY_FAILED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_FORCE_CANCELLED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ON_DELIVERY;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_PLACED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REJECTED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REQUEST;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistoryInfo {
    public String oId;
    public Integer oType;
    public String oTime;
    public String oCompTime;
    public String oStore;
    public String oSubTotal;
    public String oDeliveryCharge;
    public String oDiscount;
    public String oTax;
    public String oTotal;
    public String oDeliveryAddress;
    public Integer oStatus;
    public Integer oPaymode;
    public String oCustReq;

    private ArrayList<OrderItem> oItemList;

    public OrderHistoryInfo(String id, String store, String time)
    {
        oId = id;
        oTime= time;
        oStore = store;

        oItemList= new ArrayList<OrderItem>();
    }

    public void setId(String id) { oId=id;}
    public void setType(Integer type) {oType=type;}
    public void setTime(String time) { oTime=time;}
    public void setCompletionTime(String time) { oCompTime=time;}
    public void setStore(String vend) { oStore=vend;}
    public void setSubTotal(String subtot) { oSubTotal=subtot;}
    public void setDiscount(String disc) { oDiscount=disc;}
    public void setTax(String tax) { oTax=tax;}
    public void setTotal(String tot) { oTotal=tot;}
    public void setStatus(Integer sts) { oStatus=sts;}
    public  void setPaymode(Integer mode) { oPaymode = mode;}
    public void setDeliveryCharge(String delicharge) { oDeliveryCharge=delicharge;}
    public void setDeliveryAddress(String deliaddr) { oDeliveryAddress=deliaddr;}

    public String getStatusText() {return mapStatusDescription.get(oStatus);}

    public boolean addOrderedItem(OrderItem item) {oItemList.add(item);return true;}
    public  ArrayList<OrderItem> getItemList() {return oItemList;}

    HashMap<Integer, String> mapStatusDescription = new HashMap<Integer, String>() {{
        put(ORDER_STATUS_REQUEST, "Order Requested");
        put(ORDER_STATUS_PLACED, "Order Placed.");
        put(ORDER_STATUS_CONFIRMED, "Order Confirmed");
        put(ORDER_STATUS_CANCEL_REQUEST, "Order Cancellation Request");
        put(ORDER_STATUS_CHARGE_CONFIRM_REQUEST , "Conformation of Delivery Charge Requested ");
        put(ORDER_STATUS_ACCEPT_CHARGE, "Delivery Charge Accepted");
        put(ORDER_STATUS_DECLINE_CHARGE , "Delivery Charge Declined");
        put(ORDER_STATUS_ON_DELIVERY , "Order Is Out On delivery");
        put(ORDER_STATUS_COMPLETE, "Order Delivery Completed");
        put(ORDER_STATUS_CANCELLED, "Order Cancelled");
        put(ORDER_STATUS_REJECTED, "Service Provider Declined The Order.");
        put(ORDER_STATUS_FORCE_CANCELLED, "Order Force Cancelled.");
        put(ORDER_STATUS_DELIVERY_FAILED, "Order Delivery Failed.");
    }};
}
