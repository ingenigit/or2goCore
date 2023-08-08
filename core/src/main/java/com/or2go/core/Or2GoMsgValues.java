package com.or2go.core;

public class Or2GoMsgValues {
    //OrToGo Message Types
    public static final int OR2GO_MSG_CUSTOMER_ORDER_PLACE=100;
    public static final int OR2GO_MSG_CUSTOMER_ORDER_STATUS_UPDATE=101;
    public static final int OR2GO_MSG_CUSTOMER_ORDER_CANCEL=102;

    public static final int OR2GO_MSG_CUSTOMER_ONLINE_PAY_COMPLETE=110;
    public static final int OR2GO_MSG_CUSTOMER_ONLINE_PAY_FAILURE=111;
    public static final int OR2GO_MSG_CUSTOMER_ONLINE_PREPAY_COMPLETE=112;

    public static final int OR2GO_MSG_STORE_ORDER_STATUS_UPDATE=201;
    public static final int OR2GO_MSG_STORE_ORDER_PICKUP=202;
    public static final int OR2GO_MSG_STORE_ORDER_CONFIRM_REQUEST=211;

    public static final int OR2GO_MSG_STORE_ORDER_ASSIGN_REQUEST=300;
    public static final int OR2GO_MSG_DA_ORDER_ASSIGN_ACCEPT=301;
    public static final int OR2GO_MSG_DA_ORDER_ASSIGN_REJECT=302;
    public static final int OR2GO_MSG_DA_ORDER_DELIVERY_STATUS_UPDATE=303;
    public static final int OR2GO_MSG_STORE_ORDER_ASSIGN_CANCEL=304;

}
