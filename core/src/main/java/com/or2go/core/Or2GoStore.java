package com.or2go.core;

import static com.or2go.core.Or2goConstValues.DISCOUNT_AMOUNT_TYPE_PERCENT;
import static com.or2go.core.Or2goConstValues.DISCOUNT_AMOUNT_TYPE_VALUE;
import static com.or2go.core.Or2goConstValues.OR2GO_STORE_DATA_INFO;
import static com.or2go.core.Or2goConstValues.OR2GO_STORE_DATA_PRICE;
import static com.or2go.core.Or2goConstValues.OR2GO_STORE_DATA_PRODUCT;
import static com.or2go.core.Or2goConstValues.OR2GO_STORE_DATA_SKU;
import static com.or2go.core.Or2goConstValues.OR2GO_STORE_DATA_STOCK;
import static com.or2go.core.Or2goConstValues.OR2GO_VENDOR_PRODUCTLIST_DOWNLOAD_DONE;
import static com.or2go.core.Or2goConstValues.OR2GO_VENDOR_PRODUCTLIST_NONE;
import static com.or2go.core.Or2goConstValues.VENDOR_PAYOPT_NONE;
import static com.or2go.core.VendorDBState.OR2GO_VENDOR_DBSTATUS_UPDATED;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Or2GoStore {
    public String vId;
    public String vServiceType;
    public String vStoreType;
    public String vName;
    public String vDescription;
    public String vTagInfo;
    public String vAddress;
    public String vPlace;
    public String vLocality;
    public Integer vStatus;
    public String vMinOrd;
    public String vWorkTime;
    public String vOpenTime1;
    public String vCloseTime1;
    public String vPolicy;
    public String vRating;
    public String vState;
    public String vPIN;
    public String geolocation;

    public String vClosedFrom;
    public String vClosedTill;
    public String vClosedReason;
    public Integer vShutDownType;


    public StoreDBState mInfoDBState;
    public StoreDBState mProductDBState;
    public StoreDBState mPriceDBState;
    public StoreDBState mSKUDBState;

    public Integer vProdStatus;
    //Integer vReqProdDbVersion;

    public Integer vOrderControl;
    public Integer vOrderPayOption;

    public String vClosedOn;
    public ArrayList<String> vClosedDates;
    public ArrayList<String> vClosedDays;

    public String[] vTags;

    //Discount Information
    public String vDiscValue = "";
    public int vDiscType = 0;

    public ArrayList<Integer> vFavProducts;

    public boolean isActive;

    public Or2GoStore(String id, String name, String svctype, String storetype, String desc, String tags,
                      String addr, String place, String locality, String state, Integer status,
                      String minorder, String worktime, String closedon,
                      Integer proddbver, Integer infodbver, Integer pricedbver, Integer skudbver, String geoLocation) {
        this.vId = id;
        this.vName = name;
        this.vServiceType = svctype;
        this.vStoreType = storetype;
        this.vDescription = desc;
        this.vTagInfo = tags;
        this.vAddress = addr;
        this.vPlace = place;
        this.vLocality = locality;
        this.vState = state;

        this.vStatus = status;

        this.vMinOrd = minorder;
        this.vWorkTime = worktime;
        this.vClosedOn = closedon;
        this.vClosedFrom = "";
        this.vClosedTill = "";
        this.vClosedReason = "";
        this.vShutDownType = 0;
        this.geolocation = geoLocation;

        this.vClosedDates = new ArrayList<String>();
        this.vClosedDays = new ArrayList<String>();

        /*
        String time[] = vWorkTime.split("-");
        vOpenTime1 = time[0];
        vCloseTime1 = time[1];*/
        if (vWorkTime != null)
            processWorkingTime();

        if ((vClosedOn != null) && (!vClosedOn.isEmpty())) {
            processClosingInfo();
        }


        this.vProdStatus = OR2GO_VENDOR_PRODUCTLIST_NONE;


        this.vOrderControl = 0;

        //vInfoVersion = infodbver;
        //vProdDbVersion = proddbver;

        this.mInfoDBState = new StoreDBState(infodbver);
        this.mProductDBState = new StoreDBState(proddbver);
        this.mPriceDBState = new StoreDBState(pricedbver);
        this.mSKUDBState = new StoreDBState(skudbver);

        vFavProducts = new ArrayList<Integer>();
        //vLogo = logo;

        this.isActive = false;


    }

    public Or2GoStore(String id, String name) {
        vId = id;
        vName = name;
        vServiceType = "";
        vStoreType = "";
        vDescription = "";
        vTagInfo = "";
        vAddress = "";
        vPlace = "";
        vLocality = "";
        vState = "";
        vStatus = 0;
        vMinOrd = "";
        vWorkTime = "";
        vClosedOn = "";
        vClosedFrom = "";
        vClosedTill = "";
        vClosedReason = "";
        vShutDownType = 0;
        geolocation = "";

        vClosedDates = new ArrayList<String>();
        vClosedDays = new ArrayList<String>();

        vProdStatus = OR2GO_VENDOR_PRODUCTLIST_NONE;
        vOrderPayOption= VENDOR_PAYOPT_NONE;

        mInfoDBState = new StoreDBState();
        mProductDBState = new StoreDBState();
        mPriceDBState = new StoreDBState();
        mSKUDBState = new StoreDBState();

        vFavProducts = new ArrayList<Integer>();

        isActive = false;
    }

    public boolean updateVendorInfo(Or2GoStore newinfo) {
        vDescription = newinfo.vDescription;
        vServiceType = newinfo.vServiceType;
        vStoreType = newinfo.vStoreType;
        vTagInfo = newinfo.vTagInfo;
        vAddress = newinfo.vAddress;
        vPlace = newinfo.vPlace;
        vLocality = newinfo.vLocality;
        geolocation = newinfo.geolocation;

        vStatus = newinfo.vStatus;

        vMinOrd = newinfo.vMinOrd;
        vWorkTime = newinfo.vWorkTime;
        vClosedOn = newinfo.vClosedOn;
        vClosedFrom = newinfo.vClosedFrom;
        vClosedTill = newinfo.vClosedTill;
        vClosedReason = newinfo.vClosedReason;
        vShutDownType = newinfo.vShutDownType;

        processWorkingTime();
        processClosingInfo();

        //////mDBState.doneInfoDBUpdate();

        return true;

    }

    public String getId() {
        return vId;
    }
    public String getName() {
        return vName;
    }

    /*public String getType() {
        return vType;
    }*/

    public String getServiceType() { return vServiceType; }
    public String getStoreType() { return vStoreType; }
    public String getDescription() {       return vDescription; }
    public String getTags() { return vTagInfo; }

    public String getAddress() { return vAddress; }
    public String getPlace() { return vPlace; }
    public String getLocality() { return vLocality; }
    public String getState() { return vState; }
    public String getWorkTime() { return vWorkTime; }
    public String getClosedon() { return vClosedOn; }
    public Integer getStatus() { return vStatus; }
    public String getGeoLoc() { return geolocation; }

    public Integer getInfoVersion() { return mInfoDBState.getVer(); }
    public Integer getProductDBVersion() { return mProductDBState.getVer(); }
    public Integer getPriceDBVersion() { return mPriceDBState.getVer(); }
    public Integer getSKUDBVersion() { return mSKUDBState.getVer(); }


    public String getMinOrder() {
        return vMinOrd;
    }

    public String getPolicy() {
        return vPolicy;
    }

    public void setPolicy(String policy) {
        vPolicy = policy;
    }



    public boolean setProductStatus(Integer sts) {
        vProdStatus = sts;
        return true;
    }

    public Integer getvProdStatus() {
        return vProdStatus;
    }

    public boolean setProductDbVersion(Integer ver) {
        mProductDBState.setVersion(ver);
        return true;
    }

    //public Integer getInfoVersion() { return mDBState.getInfoVer();}
    //public Integer getProductDBVersion() { return mDBState.getProductVer(); }

    public synchronized StoreDBState getInfoDBState() {
        return mInfoDBState;
    }
    public synchronized StoreDBState getProductDBState() {
        return mProductDBState;
    }
    public synchronized StoreDBState getPriceDBState() {
        return mPriceDBState;
    }
    public synchronized StoreDBState getSKUDBState() {
        return mSKUDBState;
    }

    public synchronized void setOrderControl(Integer ordctrl) { vOrderControl = ordctrl;}
    public synchronized Integer getOrderControl(){return vOrderControl;}

    public synchronized void setPayOption(Integer payopt) { vOrderPayOption = payopt;}
    public synchronized Integer getPayOption(){return vOrderPayOption;}

    public boolean setShutdownInfo(String from, String till, String cause, int type) {
        vClosedFrom = from;
        vClosedTill = till;
        vClosedReason = cause;
        vShutDownType = type;

        return true;
    }

    public boolean clearShutdownInfo() {
        vClosedFrom = "";
        vClosedTill = "";
        vClosedReason = "";
        vShutDownType = 0;

        return true;
    }

    public Integer getShutDownType() {
        return vShutDownType;
    }

    public String getShutDownFrom() {
        return vClosedFrom;
    }

    public String getShutDownTill() {
        return vClosedTill;
    }

    public String getShutDownReason() {
        return vClosedReason;
    }

    public void processWorkingTime() {
        if (vWorkTime.isEmpty()) return;

        if (vWorkTime.contains("null"))
            vWorkTime = vWorkTime.replace("null", "00");
        String time[] = vWorkTime.split("-");

        if (time.length > 1) {
            vOpenTime1 = time[0];
            vCloseTime1 = time[1];
        } else {
            vOpenTime1 = "00:00";
            vCloseTime1 = "00:00";
        }
    }

    public void processClosingInfo() {
        if (vClosedOn.isEmpty()) return;

        String closed[] = vClosedOn.split(",");

        int dn = closed.length;
        for (int i = 0; i < dn; i++) {

            String clarr[] = closed[i].split(":");


            if (clarr[0].equals("DATE")) {
                vClosedDates.add(clarr[1]);
            } else if (clarr[0].equals("DOW")) {
                vClosedDays.add(clarr[1]);
            }

        }

    }

    public boolean isClosedToday() {
        //if ((vClosedDays.size() == 0) && (vClosedDays.size() ==0))
        //    return false;

        if (vClosedDates.size() > 0) {
            int clsdtcnt = vClosedDates.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

            for (int i = 0; i < clsdtcnt; i++) {
                SimpleDateFormat sdf1 = new SimpleDateFormat("EEE");
                Date d = new Date();
                String dayOfTheWeek = sdf1.format(d);

                String cldate = vClosedDates.get(i);
                Date enteredDate = null;
                try {
                    enteredDate = sdf.parse(cldate);
                } catch (Exception ex) {
                    // enteredDate will be null if date="287686";
                }
                Date currentDate = new Date();

                if (fmt.format(enteredDate).equals(fmt.format(currentDate))) {

                    return true;
                }//else

            }
        }
        if (vClosedDays.size() > 0) {
            int clsdtcnt = vClosedDays.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

            SimpleDateFormat sdfdow = new SimpleDateFormat("EEE");

            for (int i = 0; i < clsdtcnt; i++) {

                Date d = new Date();
                String today = sdfdow.format(d);


                String cldow = vClosedDays.get(i);

                if (today.equals(cldow)) {
                    return true;
                }//else

            }

        }

        return false;
    }


    public boolean isOpen() {
        if (isShutdownNow()) return false;
        if (isClosedToday()) return false;

        String startTime = vOpenTime1;
        String endTime = vCloseTime1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date d1 = sdf.parse(vOpenTime1);
            Date d2 = sdf.parse(vCloseTime1);

            Date curtime = sdf.parse(dateFormat.format(date));

            if (curtime.after(d1) && curtime.before(d2)) {
                return true;
            } else
                return false;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;

    }

    private boolean isShutdownNow() {
        //JAVA 8
        //LocalDateTime now = LocalDateTime.now();
        //LocalDateTime limit = LocalDateTime.parse( closedfrom );
        //Boolean isLate = now.isAfter( limit );

        //System.out.println("SHUTDOWN FROM :"+vClosedFrom);
        //System.out.println("SHUTDOWN TILL :"+vClosedTill);
        if (vClosedFrom.isEmpty()) return false;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date closedFrom = sdf.parse(vClosedFrom);
            Date closedTill = sdf.parse(vClosedTill);

            Date currentDate = new Date();

            //if ((currentDate.after(closedFrom)) && (currentDate.before(closedTill)))
            if ((currentDate.after(closedFrom))) {
                //System.out.println("SHUTDOWN NOW!!!!");
                return true;
            }

        } catch (Exception ex) {
            return false;
            // enteredDate will be null if date="287686";
        }


        return false;


    }

    public void addDiscountInfo(String value, int disctype) {
        vDiscValue = value;
        vDiscType = disctype;
    }

    public String getDiscountView() {
        if (vDiscType == DISCOUNT_AMOUNT_TYPE_VALUE) {
            return (Currency.getInstance("INR").getSymbol() + vDiscValue + " OFF");
        } else if (vDiscType == DISCOUNT_AMOUNT_TYPE_PERCENT) {
            return (vDiscValue + "%" + " OFF");
        }

        return "";
    }

    public synchronized boolean isDownloadRequired() {
        dumpDBStates();
        if (mProductDBState.isRequiredDBDownload()  || mPriceDBState.isRequiredDBDownload() || mSKUDBState.isRequiredDBDownload())
            return true;
        if (mInfoDBState.isRequiredDBDownload() || mProductDBState.isRequiredDBDownload()  || mPriceDBState.isRequiredDBDownload() || mSKUDBState.isRequiredDBDownload())
            return true;
        else
            return false;
    }

    public synchronized Integer getDownloadDataType() {
        System.out.println(" Store Download Data Type");
        if (mInfoDBState.isRequiredDBDownload()){
            System.out.println(" Store Product DB Status="+ mInfoDBState.getState()+ " Cur Ver="+mInfoDBState.getVer()+ " Req Ver="+mInfoDBState.getRequiredVer());
            return OR2GO_STORE_DATA_INFO;
        }
        if (mProductDBState.isRequiredDBDownload()) {
            System.out.println(" Store Product DB Status="+ mProductDBState.getState()+ " Cur Ver="+mProductDBState.getVer()+ " Req Ver="+mProductDBState.getRequiredVer());
            return OR2GO_STORE_DATA_PRODUCT;
        }
        if (mPriceDBState.isRequiredDBDownload()) {
            System.out.println(" Store Price DB Status="+ mPriceDBState.getState()+ " Cur Ver="+mPriceDBState.getVer()+ " Req Ver="+mPriceDBState.getRequiredVer());
            return OR2GO_STORE_DATA_PRICE;
        }
        if (mSKUDBState.isRequiredDBDownload())
        {   System.out.println(" Store SKU DB Status="+ mSKUDBState.getState()+ " Cur Ver="+mSKUDBState.getVer()+ " Req Ver="+mSKUDBState.getRequiredVer());
            return OR2GO_STORE_DATA_SKU;}


        return -1;
    }

    public synchronized boolean setDBSate(int datatype, int status) {
        switch(datatype)
        {
            case OR2GO_STORE_DATA_INFO:
                mInfoDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_PRODUCT:
                mProductDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_PRICE:
                mPriceDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_SKU:
                mSKUDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_STOCK:
                break;
            default:
                ;
        }

        return true;

    }

    /*public synchronized boolean updateDBSate(int datatype, int status) {
        switch(datatype)
        {
            case OR2GO_STORE_DATA_INFO:
                mInfoDBState.update(status);
                break;
            case OR2GO_STORE_DATA_PRODUCT:
                mProductDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_PRICE:
                mPriceDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_SKU:
                mSKUDBState.setState(status);
                break;
            case OR2GO_STORE_DATA_STOCK:
                break;
            default:
                ;
        }

        return true;

    }*/

    public synchronized void dumpDBStates()
    {
        System.out.println("Product DB State="+mProductDBState.getState()+ " Cur Ver="+mProductDBState.getVer()+" Req Ver="+mProductDBState.getRequiredVer());
        System.out.println("Price DB State="+mPriceDBState.getState()+ " Cur Ver="+mPriceDBState.getVer()+" Req Ver="+mPriceDBState.getRequiredVer());
        System.out.println("SKU DB State="+mSKUDBState.getState()+ " Cur Ver="+mSKUDBState.getVer()+" Req Ver="+mSKUDBState.getRequiredVer());

    }

    public synchronized boolean isServerProductListDownloadDone() {

        if (vProdStatus == OR2GO_VENDOR_PRODUCTLIST_DOWNLOAD_DONE)
            return true;
        else
            return false;

    }

    public synchronized boolean isServerProductListUpdateDone() {

        //if (vProdStatus == OR2GO_VENDOR_PRODUCTLIST_DONE)
        if ((mProductDBState.getState() == OR2GO_VENDOR_DBSTATUS_UPDATED) &&
                (mPriceDBState.getState() == OR2GO_VENDOR_DBSTATUS_UPDATED))
            return true;
        else
            return false;

    }
}
