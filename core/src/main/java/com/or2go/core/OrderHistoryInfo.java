package com.or2go.core;

import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ACCEPT_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCELLED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCEL_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CHARGE_CONFIRM_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_COMPLETE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CONFIRMED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_DECLINE_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ON_DELIVERY;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_PLACED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REJECTED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REQUEST;

import java.util.HashMap;

public class OrderHistoryInfo {
    public String oId;
    public String oTime;
    public String oVendor;
    public String oTotal;
    public Integer oStatus;
    public Integer oPaymode;

    public void setId(String id) { oId=id;}
    public void setTime(String time) { oTime=time;}
    public void setVendor(String vend) { oVendor=vend;}
    public void setTotal(String tot) { oTotal=tot;}
    public void setStatus(Integer sts) { oStatus=sts;}
    public  void setPaymode(Integer mode) { oPaymode = mode;}

    public String getStatusText() {return mapStatusDescription.get(oStatus);}

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
        put(ORDER_STATUS_CANCELLED, "Order Canceled");
        put(ORDER_STATUS_REJECTED, "Service Provider Declined The Order.");

    }};
}
