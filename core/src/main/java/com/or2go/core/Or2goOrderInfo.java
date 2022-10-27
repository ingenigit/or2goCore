package com.or2go.core;

import static com.or2go.core.Or2goConstValues.OR2GO_FORCE_CANCEL_CODE_ACT_OF_GOD;
import static com.or2go.core.Or2goConstValues.OR2GO_FORCE_CANCEL_CODE_CUSTOMER_REQUEST;
import static com.or2go.core.Or2goConstValues.OR2GO_FORCE_CANCEL_CODE_DELIVERY_PROBLEM;
import static com.or2go.core.Or2goConstValues.OR2GO_FORCE_CANCEL_CODE_UNEXPECTED_CONDITION;
import static com.or2go.core.Or2goConstValues.OR2GO_FORCE_CANCEL_CODE_VENDOR_INCOMPLIANCE;
import static com.or2go.core.Or2goConstValues.OR2GO_ORDERTYPE_BOOKING;
import static com.or2go.core.Or2goConstValues.OR2GO_ORDERTYPE_DELIVERY;
import static com.or2go.core.Or2goConstValues.OR2GO_ORDERTYPE_PICKUP;
import static com.or2go.core.Or2goConstValues.OR2GO_ORDER_ITEM_DETAIL_REGULAR;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_COMPLETE;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_FAILURE;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_REQ;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_FAILED_ONLINE;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_LOCAL_COMPLETE;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_NONE;
import static com.or2go.core.Or2goConstValues.OR2GO_PAY_STATUS_PROCESSING;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ACCEPT_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCELLED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CANCEL_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CHARGE_CONFIRM_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_COMPLETE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CONFIRMED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_CONFIRM_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_DECLINE_CHARGE;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_FORCE_CANCELLED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_ON_DELIVERY;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_PLACED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_PREPAYMENT_REQUEST;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_READY;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REJECTED;
import static com.or2go.core.Or2goConstValues.ORDER_STATUS_REQUEST;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class Or2goOrderInfo {
    //Integer oLocId;
    public String oOr2goId;
    public Integer oStatus;
    public Integer oType;
    public String oTime;
    public String oStoreId;
    public String oVendorName;
    public String oSubTotal;
    public String oDeliveryCharge;
    public String oDiscount;
    public String oTax;
    public String oTotal;
    public Integer oPayMode;
    public Integer oPayStatus;
    public String oAddress;
    public String oDeliveryPlace;
    public String oRequestTime;
    public String oStatusUpdateTime;
    public String oPickupOTP;

    public DeliveryAddrInfo oDeliveryAddrInfo;

    public String oCustReq;

    public int oDiscountId;

    public boolean mAccptDeliveryCharge;

    public String oStatusUpdateMsg;
    public Integer oCancelCode;

    public String oDeliveryTime;
    public String oDeliveryAssistantName;
    public String oDeliveryAssistantContact;
    public String oDeliveryAssistantId;

    private Integer oItemDetailsImgStatus;
    private Integer oItemDetailsType;
    private ArrayList<OrderItem> oItemList;

//    OrderStateMachine oOSM;

    /*
    Or2goOrderInfo()
    {
        oId = -1;
        oItemList = new ArrayList<orderDetailsItem>();
    }

    Or2goOrderInfo(int id)
    {
        oId = id;
        oItemList = new ArrayList<orderDetailsItem>();
    }
    */

    public Or2goOrderInfo(Integer type, String vend, Integer status, String time,
                          String subtotal, String charge, String total,
                          String discount, String addr, String deliloc,
                          Integer paymode, String custreq, boolean accptcharge)
    {
        //oLocId = -1;
        oOr2goId = "";
        oStatus = status;
        oStoreId = vend;
        oType = type;
        oTime = time;
        oSubTotal = subtotal;
        oDeliveryCharge = charge;
        oDiscount = discount;
        oTotal = total;

        oAddress = addr;
        oDeliveryPlace = deliloc;
        oPayMode = paymode;
        oPayStatus=OR2GO_PAY_STATUS_NONE;
        oCustReq=custreq;
        oRequestTime ="";
        oPickupOTP="";

        oDeliveryTime="";
        oDeliveryAssistantName="";
        oDeliveryAssistantContact="";
        oDeliveryAssistantId="";

        oTax= "0";
        oDiscountId=-1;

        mAccptDeliveryCharge=accptcharge;
        oItemDetailsType=OR2GO_ORDER_ITEM_DETAIL_REGULAR;
        oItemList = new ArrayList<OrderItem>();

        oItemDetailsImgStatus = 0;

//        oOSM = new OrderStateMachine();
    }

    public Or2goOrderInfo(String orderid, Integer type, String vend, Integer status, String time,
                          String subtotal, String charge, String total,
                          String discount, String addr, String deliloc,
                          Integer paymode, String custreq, boolean accptcharge)
    {
        //oLocId = -1;
        oOr2goId = orderid;
        oStatus = status;
        oStoreId = vend;
        oVendorName= "Not Set"; //no vendor name
        oType = type;
        oTime = time;
        oSubTotal = subtotal;
        oDeliveryCharge = charge;
        oDiscount = discount;
        oTotal = total;

        oAddress = addr;
        oDeliveryPlace = deliloc;
        oPayMode = paymode;
        oPayStatus=OR2GO_PAY_STATUS_NONE;
        oCustReq=custreq;

        oTax= "0";
        oDiscountId=-1;
        mAccptDeliveryCharge=accptcharge;
        oItemDetailsType=OR2GO_ORDER_ITEM_DETAIL_REGULAR;
        oItemList = new ArrayList<OrderItem>();

        oDeliveryTime="";
        oDeliveryAssistantName="";
        oDeliveryAssistantContact="";
        oDeliveryAssistantId="";

//        oOSM = new OrderStateMachine();
    }

    public void setVendorName(String vendname)
    {
        oVendorName = vendname;
    }

    public String getVendorName()
    { return oVendorName;}

    public boolean setOrderId(String id)
    {
        oOr2goId = id;
        return true;
    }
    public String getId()
    { return oOr2goId;}

    /*public boolean setLocalId(int reqid)
    {
        oLocId = reqid;

        return true;
    }

    public int getLocalId()
    {
        return oLocId;
    }*/

    public Integer getType() { return oType;}


    /*
    public boolean setTotal(String total)
    {
        oTotal = total;

        return true;
    }*/

    public boolean setTax(String tax) { oTax = tax; return  true;}
    public String getTax() { return oTax;}

    public boolean setDiscount(String disc) { oDiscount = disc; return true;}
    public String getDiscount() { return oDiscount;}
    public int getDiscountId() {return oDiscountId;}
    public boolean isUsingDiscount() { if (oDiscountId>=0) return true;
    else return false;}

    public String getTotal()
    {
        return oTotal;
    }
    public String getSubTotal()
    {
        return oSubTotal;
    }

    public boolean setStatus(Integer status)
    {
        oStatus = status;

        return true;
    }

    public Integer getStatus()
    {
        return oStatus;
    }

    public String getStatudDescription()
    {
        return mapStatusDescription.get(oStatus);
    }

    public boolean setPayStatus(Integer sts)
    {
        oPayStatus = sts;
        return true;
    }

    public Integer getPayStatus() { return oPayStatus;}

    public String getPayStatusText() { return mapPayStatusDescription.get(oPayStatus);}

    public boolean setOrderTime(String time)
    {
        oTime = time;
        return  true;
    }

    public boolean setRequestTime(String time)
    {
        oRequestTime = time;
        return true;
    }

    public void setDeliveryAddrInfo(DeliveryAddrInfo addrinfo) {oDeliveryAddrInfo=addrinfo;}
    public DeliveryAddrInfo getDeliveryAddrInfo() {return oDeliveryAddrInfo;}

    public String getRequestTime() { return oRequestTime;}

    public String getStoreId() { return oStoreId;}

    public String getOrderTime()
    {
        return oTime;
    }

    public String getAddr() { return oAddress;}

    public String getCustReq() { return oCustReq;}

    public String getDeliveryCharge() { return oDeliveryCharge;}

    public void setItemDetailsType(Integer type ) {oItemDetailsType=type;};
    public  Integer getItemDetailsType() {return  oItemDetailsType;}

    public void setPickupOTP(String otp) { oPickupOTP = otp;}
    public String getPickupOTP() { return oPickupOTP;}

    public boolean setItemList(ArrayList <OrderItem> itemlist)
    {
        oItemList = itemlist;

        return true;
    }

    public ArrayList <OrderItem> getItemList()
    {
        return oItemList;
    }

    public void clearItemList() {oItemList.clear();}

    public boolean copyItemList(ArrayList <OrderItem> itemlist)
    {
        int icnt = itemlist.size();

        if (icnt <= 0) return false;

        //oItemList = new ArrayList<orderDetailsItem>();
        oItemList.clear();

        for (int i=0; i< icnt; i++)
        {
            //orderDetailsItem orditem = new orderDetailsItem();
            oItemList.add(itemlist.get(i));

        }

        return true;
    }

//    public boolean createCartItemList(ArrayList <CartItem> itemlist, ProductManager prdMgr)
//    {
//        int icnt = itemlist.size();
//
//        if (icnt <= 0) return false;
//
//        //oItemList = new ArrayList<orderDetailsItem>();
//        oItemList.clear();
//
//        for (int i=0; i< icnt; i++)
//        {
//            CartItem citem = itemlist.get(i);
//            OrderItem oitem =  new OrderItem(citem.getId(), citem.getName(), citem.getPrice(),
//                    citem.getQntyVal(), citem.getOrderUnit(),citem.getPriceId(), citem.getSKUId());
//            //orderDetailsItem orditem = new orderDetailsItem();
//
//            oitem.setProductInfo(prdMgr.getProductInfo(citem.getId()));
//            oItemList.add(oitem);
//        }
//
//        return true;
//    }


    public int GetOrderitemCount()
    {
        return oItemList.size();
    }
    public OrderItem GetOrderItemByIndex(int n)
    {
        return oItemList.get(n);

    }

    public int addOrderItem(OrderItem item)
    {
        oItemList.add(item);

        return 0;
    }

    public int delOrderItem(int itemno)
    {
        int orderlistsize = oItemList.size();

        if ((itemno < 0) || (itemno >= orderlistsize))
        {
            return -1;
        }

        oItemList.remove(itemno);

        return 0;
    }

    public boolean deleteOrderItem(OrderItem item)
    {
        boolean res = oItemList.remove(item);
        if (res)
        {
            calcOrderTotal();
            calcGrandTotal();
            return true;
        }
        else
            return false;
    }

    public boolean removeDiscount()
    {
        if (oDiscountId>0)
        {
            oDiscountId=-1;
            oDiscount="";
            calcGrandTotal();
        }

        return true;
    }

    public int modifyOrderItem(int itemno, float qnty)
    {
        OrderItem item;

        item = oItemList.get(itemno);

        item.setQnty(qnty);// = qnty;

        return 0;
    }

    public int getItemCount()
    {
        return oItemList.size();
    }

    public boolean setDeliveryCharge(String charge)
    {
        oDeliveryCharge = charge;

        Float gtotal = Float.parseFloat(oSubTotal) + Float.parseFloat(oDeliveryCharge);

        oTotal = gtotal.toString();

        return true;
    }

    public boolean setStatusDescription(String msg)
    {
        oStatusUpdateMsg = msg;

        return true;
    }

    public String getStatusDescription()
    {
        return oStatusUpdateMsg;
    }

    public String getStatusText() {return mapStatusDescription.get(oStatus);}

    public String getOrderTypeDescription() {return mapTypeDescription.get(oType);}

    public String getLocation() {return oDeliveryPlace;}

    public String getNotificationMessage()
    {
        /*
        String msg="";
        if (oStatus.equals("ORDER_CONFIRMED"))
            msg = "Order is confirmed.";
        else if (oStatus.equals("ORDER_REJECTED"))
            msg = "Order is declined.";
        if (oStatus.equals("ORDER_REQ_CUST_CONFIRMATION"))
            msg = "Requires confirmation of delivery charge. Please confirm.";
        if (oStatus.equals("ORDER_ON_DELIVERY"))
            msg = "Order is on delivery. Will be reaching you soon.";
        if (oStatus.equals("ORDER_COMPLETED"))
            msg = "is completed. Thank you for using our service.";

        return msg;*/

        return oStatusUpdateMsg;
    }

    public boolean isActiveOrder()
    {
        //if ((mStatus==ORDER_STATUS_COMPLETE) ||(mStatus==ORDER_STATUS_CANCELLED) || (mStatus==ORDER_STATUS_REJECTED))
        if (oStatus >= 20)
        {
            return false;
        }
        return true;
    }

    public boolean isCancellable()
    {
        if ((oStatus==ORDER_STATUS_PLACED) ||(oStatus==ORDER_STATUS_CHARGE_CONFIRM_REQUEST)
                || (oStatus==ORDER_STATUS_CANCEL_REQUEST)
                ||(oStatus==ORDER_STATUS_CONFIRM_REQUEST)
                || (oStatus==ORDER_STATUS_PREPAYMENT_REQUEST))
        {
            return true;
        }
        return false;
    }

    public boolean isDeliveryComplete()
    {
        if (oStatus == ORDER_STATUS_COMPLETE) return true;
        else
            return false;
    }

    public boolean isOnDelivery()
    {
        if (oStatus == ORDER_STATUS_ON_DELIVERY)
            return true;
        else
            return false;
    }

    public boolean isActionRequired()
    {
        if ((oStatus==ORDER_STATUS_CHARGE_CONFIRM_REQUEST) ||(oStatus==ORDER_STATUS_CONFIRM_REQUEST)
                || (oStatus==ORDER_STATUS_PREPAYMENT_REQUEST))
        {
            return true;
        }
        return false;
    }


    public boolean setoDeliveryTime(String esttime)
    {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        //Date date = new Date();

        int idx1 = esttime.indexOf(" ");
        String s1 = esttime.substring(0, idx1);
        String s2 = esttime.substring(idx1+1);

        if (s1.isEmpty()) return false;

        Calendar now = Calendar.getInstance();

        if (s2.contains("Min"))
        {
            now.add(Calendar.MINUTE, Integer.parseInt(s1));
        }
        else if (s2.contains("Hour"))
        {
            now.add(Calendar.HOUR, Integer.parseInt(s1));
        }
        else if (s2.contains("Day"))
        {
            now.add(Calendar.DAY_OF_MONTH, Integer.parseInt(s1));
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());

        oDeliveryTime = dateFormat.format(now.getTime());

        return true;
    }

    public String getoDeliveryTime()
    {
        return oDeliveryTime;
    }

    public void setCompletionTime(String time) { oDeliveryTime = time; }
    public String getCompletionTime() {return oDeliveryTime;}

    public boolean setDAId(String daid) { oDeliveryAssistantId = daid; return true;}
    public String getDAId()
    {
        return oDeliveryAssistantId;
    }

    public boolean setDAName(String name) { oDeliveryAssistantName = name; return true;}
    public String getDAName()
    {
        return oDeliveryAssistantName;
    }

    public boolean setDAContact(String contact) {oDeliveryAssistantContact = contact; return true;}
    public String getDAContact()
    {
        return oDeliveryAssistantContact;
    }

    public void setCancelCode(int code) { oCancelCode = code; }
    public Integer getCancelCode() {return oCancelCode;}
    public String getCancelCodeText() {return mapCancelDescription.get(oCancelCode); }

    public Integer getOrderImageStatus() { return oItemDetailsImgStatus;}
    public void setOrderImageStatus(Integer ordimgsts) { oItemDetailsImgStatus = ordimgsts;}

    public void calcOrderTotal()
    {
        int i;
        Float newsubotal = new Float("0");

        int salelistsz = oItemList.size();
        //if sales list is empty just add the item
        if ( salelistsz != 0)
        {

            //check if the item is already present
            for(i=0;i<salelistsz;i++)
            {
                OrderItem saleitem = oItemList.get(i);//saleslist.get(i);

                newsubotal = newsubotal + saleitem.getItemTotal();
            }
        }

        oSubTotal = newsubotal.toString();
    }

    public void calcGrandTotal()
    {
        Float gtotal = Float.parseFloat(oSubTotal) + Float.parseFloat(oDeliveryCharge)+ Float.parseFloat(oTax) - Float.parseFloat(oDiscount);
        oTotal = gtotal.toString();
    }


    ///state machine API
//    public void registerOrder()
//    {
//        System.out.println("RegisterOrder : Order State="+oOSM.getOSM().getCurrentState().getName());
//        try {
//            oOSM.getOSM().fire(new EventRegister());
//        } catch (FiniteStateMachineException e) {
//            e.printStackTrace();
//        }
//    }

    /*public void updateOrderStatus()
    {
        System.out.println("UpdateOrderstatus : Order State="+oOSM.getOSM().getCurrentState().getName());
        try {
            oOSM.getOSM().fire(new EventConfirm());
        } catch (FiniteStateMachineException e) {
            e.printStackTrace();
        }
    }*/


    HashMap<Integer, String> mapStatusDescription = new HashMap<Integer, String>() {{
        put(ORDER_STATUS_REQUEST, "Order Request in procerss.");
        put(ORDER_STATUS_PLACED, "Order Placed. Waiting to be confirmed.");
        put(ORDER_STATUS_CONFIRMED, "Order Confirmed");
        put(ORDER_STATUS_CANCEL_REQUEST, "Order Cancellation Request");
        put(ORDER_STATUS_CHARGE_CONFIRM_REQUEST , "Conformation of Delivery Charge Requested ");
        put(ORDER_STATUS_ACCEPT_CHARGE, "Delivery Charge Accepted");
        put(ORDER_STATUS_DECLINE_CHARGE , "Delivery Charge Declined");
        put(ORDER_STATUS_ON_DELIVERY , "Order Is Out On delivery");
        put(ORDER_STATUS_COMPLETE, "Order Delivery Completed");
        put(ORDER_STATUS_READY, "Order is Ready");
        put(ORDER_STATUS_CANCELLED, "Order Canceled");
        put(ORDER_STATUS_REJECTED, "Service Provider Declined The Order.");
        put(ORDER_STATUS_FORCE_CANCELLED, "Service Provider Cancelled The Order.");
        put(ORDER_STATUS_CONFIRM_REQUEST, "Order Invoice Needs To Be Confirmed By User.");
        put(ORDER_STATUS_PREPAYMENT_REQUEST, "Advance Online Payment Required.");


    }};


    HashMap<Integer, String> mapPayStatusDescription = new HashMap<Integer, String>() {{
        put(OR2GO_PAY_STATUS_NONE, "");
        put(OR2GO_PAY_STATUS_PROCESSING, "Processing Online Payment");
        put(OR2GO_PAY_STATUS_FAILED_ONLINE, "Online Payment Failed");
        put(OR2GO_PAY_STATUS_LOCAL_COMPLETE, "Payment Complete. Updating Data.");
        put(OR2GO_PAY_STATUS_COMPLETE , "Payment Complete.");
        put(OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_REQ , "Confirmation Request for Payment.");
        put(OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_FAILURE , "Payment Confirmation Failed");

    }};

    HashMap<Integer, String> mapTypeDescription = new HashMap<Integer, String>() {{
        put(OR2GO_ORDERTYPE_DELIVERY, "Delivery");
        put(OR2GO_ORDERTYPE_PICKUP, "Pickup");
        put(OR2GO_ORDERTYPE_BOOKING, "Pre Order/Booking");
        //put(OR2GO_ORDER_TAKEAWAY, "TakeAway");
    }};

    HashMap<Integer, String> mapCancelDescription = new HashMap<Integer, String>() {{
        put(OR2GO_FORCE_CANCEL_CODE_VENDOR_INCOMPLIANCE, "Vendor could nor process the order.");
        put(OR2GO_FORCE_CANCEL_CODE_CUSTOMER_REQUEST, "Cancelled on Customer Request.");
        put(OR2GO_FORCE_CANCEL_CODE_DELIVERY_PROBLEM, "Cancelled due to delivery problem.");
        put(OR2GO_FORCE_CANCEL_CODE_UNEXPECTED_CONDITION, "Cancelled due to unexpected conditions.");
        put(OR2GO_FORCE_CANCEL_CODE_ACT_OF_GOD, "Act of God");
    }};
}
