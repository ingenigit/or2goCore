package com.or2go.core;

import static com.or2go.core.Or2goConstValues.DISCOUNT_AMOUNT_TYPE_PERCENT;
import static com.or2go.core.Or2goConstValues.DISCOUNT_AMOUNT_TYPE_VALUE;
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

public class Or2goVendorInfo {
    public String vId;
    public String vType;
    public String vStoreType;
    public String vName;
    public String vDescription;
    public String vTagInfo;
    public String vAddress;
    public String vPlace;
    public String vLocality;
    public String vStatus;
    public String vMinOrd;
    public String vWorkTime;
    public String vOpenTime1;
    public String vCloseTime1;
    public String vPolicy;
    public String vRating;
    public String vState;
    public String vPIN;
    public String vLogoPath;
//    Bitmap vLogo;
    public String vDBName;

    public String vClosedFrom;
    public String vClosedTill;
    public String vClosedReason;
    public Integer vShutDownType;

    //Integer vInfoVersion;
    //Integer vPriceVersion;
    //Integer vProdDbVersion;
    VendorDBState mDBState;

    public Integer vProdStatus;
    public Integer vProdDbVersion;

    public Integer vOrderControl;
    public Integer vOrderPayOption;

    public String vClosedOn;
    ArrayList<String> vClosedDates;
    ArrayList<String> vClosedDays;

    public String[] vTags;

    //Discount Information
    public String vDiscValue = "";
    public int vDiscType = 0;

    public boolean isActive;

    public Or2goVendorInfo(String id, String name, String type, String storetype, String desc, String tags,
                           String addr, String place, String locality, String state, String status,
                           String minorder, String worktime, String closedon,
                           String logopath, String dbname, Integer proddbver, Integer infodbver, Integer pricedbver) {
        this.vId = id;
        this.vName = name;
        this.vType = type;
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
        this.vLogoPath = logopath;
        this.vDBName = dbname;
        this.vOrderControl = 0;

        //vInfoVersion = infodbver;
        this.vProdDbVersion = proddbver;

        this.mDBState = new VendorDBState(infodbver, proddbver, pricedbver);
        //vLogo = logo;
        this.isActive = false;
    }

    public Or2goVendorInfo(String id) {
        this.vId = id;
        this.vName = "";
        this.vType = "";
        this.vDescription = "";
        this.vTagInfo = "";
        this.vAddress = "";
        this.vPlace = "";
        this.vLocality = "";
        this.vState = "";
        this.vStatus = "";
        this.vMinOrd = "";
        this.vWorkTime = "";
        this.vClosedOn = "";
        this.vClosedFrom = "";
        this.vClosedTill = "";
        this.vClosedReason = "";
        this.vShutDownType = 0;

        this.vClosedDates = new ArrayList<String>();
        this.vClosedDays = new ArrayList<String>();

        this.vProdStatus = OR2GO_VENDOR_PRODUCTLIST_NONE;
        this.vLogoPath = "";
        this.vDBName = "";
        this.vOrderPayOption= VENDOR_PAYOPT_NONE;

        this.mDBState = new VendorDBState(0, 0, 0);

        this.isActive = false;
    }

    public boolean updateVendorInfo(Or2goVendorInfo newinfo) {
        vDescription = newinfo.vDescription;
        vType = newinfo.vType;
        vStoreType = newinfo.vStoreType;
        vTagInfo = newinfo.vTagInfo;
        vAddress = newinfo.vAddress;
        vPlace = newinfo.vPlace;
        vLocality = newinfo.vLocality;

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

        mDBState.doneInfoDBUpdate();

        return true;
    }

    public String getId() {
        return vId;
    }

    public String getName() {
        return vName;
    }

    public String getType() {
        return vType;
    }

    public String getStoreType() {
        return vStoreType;
    }

    public String getDescription() {
        return vDescription;
    }

    public String getTags() {
        return vTagInfo;
    }

    public String getAddress() {
        return vAddress;
    }

    public String getPlace() {
        return vPlace;
    }

    public String getLocality() {
        return vLocality;
    }

    public String getState() {
        return vState;
    }

    public String getWorkTime() {
        return vWorkTime;
    }

    public String getClosedon() {
        return vClosedOn;
    }

    public String getStatus() {
        return vStatus;
    }

    public String getLogoPath() {
        return vLogoPath;
    }

    public String getDbName() {
        return vDBName;
    }

    public Integer getProductDbVersion() {
        return mDBState.getProductVer();
    }
    public Integer getDbVersion() {
        return vProdDbVersion;
    }

    public Integer getPriceDbVersion() {
        return mDBState.getPriceVer();
    }

    public Integer getInfoVersion() {
        return mDBState.getInfoVer();
    }

    public String getMinOrder() {
        return vMinOrd;
    }

    public String getPolicy() {
        return vPolicy;
    }

    public void setPolicy(String policy) {
        vPolicy = policy;
    }

//    public void setLogo(Bitmap logo) {
//        vLogo = logo;
//    }

//    public Bitmap getLogo() {
//        return vLogo;
//    }

    public boolean setLogoPath(String path) {
        vLogoPath = path;
        return true;
    }

    public boolean setProductDB(String dbname) {
        vDBName = dbname;
        return true;
    }

    public boolean setProductStatus(Integer sts) {
        vProdStatus = sts;
        return true;
    }

    public Integer getvProdStatus() {
        return vProdStatus;
    }

    public boolean setProductDbVersion(Integer ver) {
//        mDBState.setProductVersion(ver);
        vProdDbVersion = ver;
        return true;
    }

    public Integer getvProdDbVersion()
    {
        if (vProdDbVersion == null)
            return 0;
        else
            return vProdDbVersion;
    }

    //public Integer getInfoVersion() { return mDBState.getInfoVer();}
    //public Integer getProductDBVersion() { return mDBState.getProductVer(); }

    public synchronized VendorDBState getDBState() {
        return mDBState;
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
        if ((mDBState.reqProductDBDownload()  || mDBState.reqPriceDBDownload()))
            return true;
        else
            return false;
    }

    public synchronized boolean isServerProductListDownloadDone() {

        if (vProdStatus == OR2GO_VENDOR_PRODUCTLIST_DOWNLOAD_DONE)
            return true;
        else
            return false;
    }

    public synchronized boolean isServerProductListUpdateDone() {

        //if (vProdStatus == OR2GO_VENDOR_PRODUCTLIST_DONE)
        if ((mDBState.getProductState() == OR2GO_VENDOR_DBSTATUS_UPDATED) &&
                (mDBState.getPriceState() == OR2GO_VENDOR_DBSTATUS_UPDATED))
            return true;
        else
            return false;
    }
}
