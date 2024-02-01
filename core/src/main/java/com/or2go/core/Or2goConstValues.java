package com.or2go.core;

public class Or2goConstValues {
    //Limits
    public static final int OR2GO_MAX_LOGIN_RETRY_COUNT=5;

    public static final int OR2GO_LOGIN_STATUS_NONE = 0;
    public static final int OR2GO_LOGIN_STATUS_INPROGRESS = 1;
    public static final int OR2GO_LOGIN_STATUS_FAILED = 2;
    public static final int OR2GO_LOGIN_STATUS_SUCCESS = 3;
    public static final int OR2GO_LOGIN_STATUS_ALREADY = 4;

    //Server API call syncronization type
    public static final int OR2GO_COMM_SYNC_API = 1;
    public static final int OR2GO_COMM_ASYNC_API = 2;

    //Server communication message
    public static final int OR2GO_COMM_LOGIN = 1;
    public static final int OR2GO_COMM_Multi_LOGIN = 11;
    public static final int OR2GO_COMM_LOGOUT = 2;
    public static final int OR2GO_GET_SESSION = 3;
    public static final int OR2GO_REGISTER_OTPREQ = 4;
    public static final int OR2GO_REGISTER = 5;

    public static final int OR2GO_VENDOR_LIST = 6;
    public static final int OR2GO_VENDOR_LIST_PUBLIC = 7;
    public static final int OR2GO_STORE_LOGIN_INFO = 88;

    public static final int OR2GO_COMM_APPINFO = 300;

    public static final int OR2GO_PRODUCT_LIST = 8;
    public static final int OR2GO_PRICE_LIST = 9;
    public static final int OR2GO_SKU_LIST = 99;

    public static final int OR2GO_ORDER_REQ = 10;
    public static final int OR2GO_ORDER_CONFIRM = 11;
    public static final int OR2GO_ORDER_CANCEL_REQ = 12;
    public static final int OR2GO_ORDER_CONFIRM_DELICHARGE = 13;
    public static final int OR2GO_ORDER_REJECT_DELICHARE = 14;
    public static final int OR2GO_ORDER_SET_DELIVERY = 15;
    public static final int OR2GO_ORDER_COMPLETE = 16;
    public static final int OR2GO_ORDER_FEEDBACK = 19;
    public static final int OR2GO_ORDER_STATUS_UPDATE = 20;
    public static final int OR2GO_ACTIVE_ORDER_LIST = 21;
    public static final int OR2GO_ORDER_DETAILS = 22;
    public static final int OR2GO_ORDER_HISTORY_INFO = 23;
    public static final int OR2GO_ORDER_RATING = 24;
    public static final int OR2GO_QUICK_ORDER_CONFIRM = 25;
    public static final int OR2GO_QUICK_ORDER_ITEMS_UPDATE = 26;
    public static final int OR2GO_IMAGE_STATUS_UPDATE = 27;

    public static final int OR2GO_PAYMENT_STATUS_UPDATE = 30;
    public static final int OR2GO_PREPAYMENT_STATUS_UPDATE=31;
    public static final int OR2GO_PAY_STATUS_PENDING=32; //1

    public static final int OR2GO_GET_SPINFO = 40;

    public static final int OR2GO_ORDER_HISTORY = 50;

    public static final int OR2GO_DELIVERY_LOCATION_INFO = 60;
    public static final int OR2GO_DELIVERY_MODEL = 61;

    public static final int OR2GO_DISCOUNT_INFO = 70;

    public static final int OR2GO_USER_DELIVERY_ADDR = 80;
    public static final int OR2GO_USER_DELIVERY_ADDR_DELETE = 81;
    public static final int OR2GO_USER_DELIVERY_ADDR_UPDATE = 82;

    public static final int OR2GO_VENDOR_DBVERSION_LIST=90;
    public static final int OR2GO_VENDOR_PRICE_LIST=91;
    public static final int OR2GO_VENDOR_INFO=92;
    public static final int OR2GO_STORE_INFO=93;
    public static final int OR2GO_SKU_DATA=94;

    public static final int OR2GO_CRASH_REPORT = 101;

    public static final int OR2GO_OUT_OF_STOCK_DATA = 111;
    public static final int OR2GO_ITEM_STOCK_VAL = 112;

    public static final int OR2GO_DA_LOCATION = 120;
    public static final int OR2GO_ACTIVE_DA_LIST=121;
    public static final int OR2GO_ASSIGN_DA=122;
    public static final int OR2GO_DA_ASSIGN_REQUESTS=125;
    public static final int OR2GO_DA_ASSIGNED_ORDERS=126;
    public static final int OR2GO_CANCEL_DA_ASSIGN=127;

    public static final int OR2GO_DA_ASSIGN_REQUEST_REPLY=130;
    public static final int OR2GO_ORDER_DELIVERY_STATUS_UPDATE=131;

    public static final int OR2GO_COMM_VENDOR_STORE_LIST=200;
    public static final int OR2GO_COMM_VENDOR_LOGIN=201;
    public static final int OR2GO_COMM_STORE_LOGIN=202;
    public static final int OR2GO_COMM_SESSION_LOGIN=203;


    ///////////////////

    //Order Type Values
    public static final int OR2GO_ORDERTYPE_NONE = 0;
    public static final int OR2GO_ORDERTYPE_DELIVERY = 1;
    public static final int OR2GO_ORDERTYPE_PICKUP = 2;
    public static final int OR2GO_ORDERTYPE_BOOKING = 3;

    public static final int OR2GO_ORDER_DELIVERY_ASAP = 1;
    public static final int OR2GO_ORDER_DELIVERY_BOOK = 2;
    public static final int OR2GO_ORDER_PICKUP = 3;
    public static final int OR2GO_ORDER_TAKEAWAY = 4;
    //

    public static final int OR2GO_VENDORLIST_NONE = 0;
    public static final int OR2GO_VENDORLIST_REQ = 1;
    public static final int OR2GO_VENDORLIST_DONE = 2;

    public static final int OR2GO_VENDOR_PRODUCTLIST_NONE = 0;
    public static final int OR2GO_VENDOR_PRODUCTLIST_REQ = 1;
    public static final int OR2GO_VENDOR_PRODUCTLIST_DOWNLOAD_DONE = 2;
    public static final int OR2GO_VENDOR_PRODUCTLIST_EXIST = 3;
    public static final int OR2GO_VENDOR_PRODUCTLIST_REQ_NEW = 4;
    public static final int OR2GO_VENDOR_PRODUCTLIST_REQ_UPDATE = 5;

    public static final int OR2GO_VENDOR_PRODUCTLIST_DONE = 10;

    ///
    public static final int OR2GO_ORDER_ITEM_DETAIL_REGULAR = 0;
    public static final int OR2GO_ORDER_ITEM_DETAIL_TEXT = 1;
    public static final int OR2GO_ORDER_ITEM_DETAIL_IMG = 2;
    public static final int OR2GO_ORDER_ITEM_DETAIL_HYBRID =3;

    //public static final String OR2GO_SERVER = "http://172.105.54.66:3333/";
    ///public static final String OR2GO_SERVER = "http://172.105.54.66:3000/";
    ///public static final String GENIPOS_SERVER = "http://www.genipos.biz/";


    //public static final String OR2GO_SP_CODE = "OD7570010000002";
    ///public static final String OR2GO_SP_CODE = "OD7510000000008";

    //Order Cart Status
    public static final int ORDER_CART_STATUS_NONE = 1;
    public static final int ORDER_CART_STATUS_REQUEST = 2;
    public static final int ORDER_CART_STATUS_COMPLETE = 3;
    public static final int ORDER_CART_STATUS_ERROR = 3;

    //order status values
    public static final int ORDER_STATUS_REQUEST = 1;
    public static final int ORDER_STATUS_PLACED = 2;
    public static final int ORDER_STATUS_CONFIRMED = 3;
    public static final int ORDER_STATUS_CANCEL_REQUEST = 4;
    public static final int ORDER_STATUS_CHARGE_CONFIRM_REQUEST = 5;
    public static final int ORDER_STATUS_ACCEPT_CHARGE = 6;
    public static final int ORDER_STATUS_DECLINE_CHARGE = 7;
    public static final int ORDER_STATUS_PICKED_UP = 8;
    public static final int ORDER_STATUS_ON_DELIVERY = 8;
    public static final int ORDER_STATUS_CONFIRM_REQUEST = 9;
    public static final int ORDER_STATUS_PREPAYMENT_REQUEST = 10;
    public static final int ORDER_STATUS_READY = 11;

    public static final int ORDER_STATUS_CONFIRM_COND_PREPAYMENT = 12;

    public static final int ORDER_STATUS_FAILED = 8;
    public static final int ORDER_STATUS_RETRY = 9;
    public static final int ORDER_STATUS_COMPLETE = 20;
    public static final int ORDER_STATUS_CANCELLED = 21;
    public static final int ORDER_STATUS_REJECTED = 22;
    public static final int ORDER_STATUS_FORCE_CANCELLED = 23;
    public static final int ORDER_STATUS_DELIVERY_FAIL = 24;

    //order delivery status values
    public static final int OR2GO_FORCE_CANCEL_CODE_VENDOR_INCOMPLIANCE =1;
    public static final int OR2GO_FORCE_CANCEL_CODE_CUSTOMER_REQUEST    =2;
    public static final int OR2GO_FORCE_CANCEL_CODE_DELIVERY_PROBLEM    =3;
    public static final int OR2GO_FORCE_CANCEL_CODE_UNEXPECTED_CONDITION=4;
    public static final int OR2GO_FORCE_CANCEL_CODE_ACT_OF_GOD          =10;

    //order image status values
    public static final int OR2GO_ORDER_IMG_STATUS_NONE =0;
    public static final int OR2GO_ORDER_IMG_STATUS_PENDING    =1;
    public static final int OR2GO_ORDER_IMG_STATUS_UPLOADING    =3;
    public static final int OR2GO_ORDER_IMG_STATUS_DONE=4;

    ///Events
    public static final int OR2GO_EVENT_ORDER_REQUEST= 1;
    public static final int OR2GO_EVENT_ORDER_CONFIRM=2;
    public static final int OR2GO_EVENT_ORDER_REJECT= 3;
    public static final int OR2GO_EVENT_ORDER_CANCEL= 4;

    public static final int OR2GO_EVENT_ORDER_CONFIRM_COND_PREPAY=20;
    public static final int OR2GO_EVENT_PAYMENT_COMPLETE_COND_PREPAY=21;

    public static final int OR2GO_EVENT_DA_ASSIGN_REQUEST=1;
    public static final int OR2GO_EVENT_DA_ASSIGN_ACCEPT=2;
    public static final int OR2GO_EVENT_DA_ASSIGN_REJECT=3;

    public static final int EV_ORDER_DA_ON_PICKUP=4;
    public static final int EV_ORDER_DA_DELIVERY_PICKUP=5;
    public static final int EV_ORDER_DA_ON_DELIVERY=6;
    public static final int EV_ORDER_DA_DELIVERY_COMPLETE=7;
    public static final int EV_ORDER_DA_DELIVERY_FAIL=8;
    public static final int EV_ORDER_DA_DELIVERY_RETRY=9;
    public static final int EV_ORDER_DA_DELIVERY_REJECT=10;

    public static final int EV_ORDER_SELF_DELIVERY_COMPLETE=11;

    public static final int OR2GO_EVENT_ORDER_READY_DELIVERY= 9;
    public static final int OR2GO_EVENT_ORDER_READY_PICKUP= 10;
    public static final int OR2GO_EVENT_ORDER_PICKUP_DA= 11;
    public static final int OR2GO_EVENT_ORDER_PICKUP_CUSTOMER= 12;
    public static final int OR2GO_EVENT_ORDER_FORCE_CANCEL= 13;
    public static final int OR2GO_EVENT_ORDER_SelF_DELIVERY= 14;

    public static final int OR2GO_EVENT_DA_ASSIGN_CANCEL=20;


    public static final int OR2GO_EVENT_ONLINE_PAYMENT_COMPLETE= 1;
    public static final int OR2GO_EVENT_ONLINE_PAYMENT_FAILURE= 2;

    //Vendor Pay options
    public static final int VENDOR_PAYOPT_NONE=0;
    public static final int VENDOR_PAYOPT_ALL=1;
    public static final int VENDOR_PAYOPT_COD=2;
    public static final int VENDOR_PAYOPT_ONLINE=2;
    public static final int VENDOR_PAYOPT_ONLINE_PREPAY=4;

    //payment mode
    public static final int OR2GO_PAY_MODE_COD = 1;
    public static final int OR2GO_PAY_MODE_MODE_ONLINE = 2;
    public static final int OR2GO_PAY_MODE_MODE_CASHLESS = 2;
    public static final int OR2GO_PAY_MODE_CARD = 3;
    public static final int OR2GO_PAY_MODE_UPI = 4;
    public static final int OR2GO_PAY_MODE_WALLET = 5;
    public static final int OR2GO_PAY_MODE_EXT_UPI = 6;
    public static final int OR2GO_PAY_MODE_EXT_NEFT = 7;
    public static final int OR2GO_PAY_MODE_EXT_WALLET = 8;
    public static final int OR2GO_PAY_MODE_EXT_CARD = 9;

    //payment status
    public static final int OR2GO_PAY_STATUS_NONE = 0;
    public static final int OR2GO_PAY_STATUS_ONLINE_COMPLETE_APP=1;
    public static final int OR2GO_PAY_STATUS_EXT_VERIFICATION_PENDING = 2;
    public static final int OR2GO_PAY_STATUS_COMPLETE = 3; //5
    public static final int OR2GO_PAY_STATUS_FAILED_ONLINE = 4; //3

    public static final int OR2GO_PAY_STATUS_PROCESSING = 10; //2
    public static final int OR2GO_PAY_STATUS_LOCAL_COMPLETE = 11; //4
    public static final int OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_REQ = 12; //10
    public static final int OR2GO_PAY_STATUS_EXTPAY_CONFIRMATION_FAILURE = 13; //11

    //UPI Payment Status
    public static int UPI_PAY_STATUS_FAILURE = 0;
    public static final int UPI_PAY_STATUS_SUCCESS = 1;
    public static final int UPI_PAY_STATUS_SUBMITTED = 2;

    //Discount Settings
    public static final int DISCOUNT_AMOUNT_TYPE_VALUE = 1;
    public static final int DISCOUNT_AMOUNT_TYPE_PERCENT = 2;

    //Messages
    public static final int OR2GO_VENDOR_PRODUCT_DBSYNC=5;
    public static final int OR2GO_VENDOR_PRICE_DBSYNC=6;
    public static final int OR2GO_VENDOR_SKU_DBSYNC=7;

    //Update
    public static final int OR2GO_APP_IMMIDIATE_UPDATE_REQUEST_CODE=99;
    public static final int OR2GO_APP_FLEXIBLE_UPDATE_REQUEST_CODE=100;

    //Product data types
    public static final int OR2GO_STORE_DATA_INFO=1;
    public static final int OR2GO_STORE_DATA_PRODUCT=2;
    public static final int OR2GO_STORE_DATA_SKU=3;
    public static final int OR2GO_STORE_DATA_PRICE=4;
    public static final int OR2GO_STORE_DATA_STOCK=5;

    //product pack types
    public static final int OR2GO_PRODUCT_PACK_TYPE_NONE=3;
    public static final int OR2GO_PRODUCT_PACK_TYPE_SINGLE=0;
    public static final int OR2GO_PRODUCT_PACK_TYPE_MULTI=2;

    //product TAG types
    public static final int OR2GO_PRODUCT_TAG_FOOD_VEG=1;
    public static final int OR2GO_PRODUCT_TAG_FOOD_NONVEG=2;
    public static final int OR2GO_PRODUCT_TAG_NEW=3;
    public static final int OR2GO_PRODUCT_TAG_POPULAR=4;
    public static final int OR2GO_PRODUCT_TAG_RECOMMENDED=5;
    public static final int OR2GO_PRODUCT_TAG_BEST_SELLER=6;
    public static final int OR2GO_PRODUCT_TAG_MUST_TRY=7;
    public static final int OR2GO_PRODUCT_TAG_SALE=8;

    //App Initialization Status
    public static final int OR2GO_INIT_NONE=0;
    public static final int OR2GO_INIT_LOGGED_IN=1;
    public static final int OR2GO_INIT_COMPLETE=10;

    //Delivery Status
    public static final int OR2GO_DELIVERY_STATUS_NONE = 0;
    public static final int OR2GO_DELIVERY_STATUS_ASSIGN_REQUEST = 1;
    public static final int OR2GO_DELIVERY_STATUS_ASSIGN_ACCEPT = 2;
    public static final int OR2GO_DELIVERY_STATUS_ASSIGNED = 3;
    public static final int OR2GO_DELIVERY_STATUS_PICKUP_ONTHEWAY = 4;
    public static final int OR2GO_DELIVERY_STATUS_PICKUP_DONE = 5;
    public static final int OR2GO_DELIVERY_STATUS_DELIVERY_ONTHEWAY = 6;
    public static final int OR2GO_DELIVERY_STATUS_DELIVERY_FAIL = 7;
    public static final int OR2GO_DELIVERY_STATUS_DELIVERY_RETRY = 8;
    public static final int OR2GO_DELIVERY_STATUS_DELIVERY_DONE = 9;
    public static final int OR2GO_DELIVERY_STATUS_ASSIGN_REJECT = 10;

    public static final int OR2GO_DELIVERY_ASSIGN_ACCEPT = 2;
    public static final int OR2GO_DELIVERY_ASSIGN_REJECT = 3;

    //Delivery Model Types
    public static final int OR2GO_DELIVERY_CHARGE_MODEL_NONE=0;
    public static final int OR2GO_DELIVERY_CHARGE_MODEL_LOCATION=1;
    public static final int OR2GO_DELIVERY_CHARGE_MODEL_DISTANCE=2;
    public static final int OR2GO_DELIVERY_CHARGE_MODEL_RANGE=3;

    //Store Delivery Options
    public static final int STORE_DELIVERY_OPTION_NONE=0;
    public static final int STORE_DELIVERY_OPTION_SELF=1;
    public static final int STORE_DELIVERY_OPTION_DA=2;
    public static final int STORE_DELIVERY_OPTION_BOTH=3;


    //Search Type
    //App Initialization Status
    public static final int OR2GO_SEARCH_PRODUCT_NAME=1;
    public static final int OR2GO_SEARCH_PRODUCT_BRAND=2;
    public static final int OR2GO_SEARCH_VENDOR_TAG=10;
}
