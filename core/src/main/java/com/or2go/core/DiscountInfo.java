package com.or2go.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DiscountInfo {
    public int mdId;
    public String mdName;
    public String mdDescription;
    public int mdType;
    public int mdScope;
    public Float mdValue;
    public int mdAmntType;
    public String mdStartDate;
    public String mdEndDate;

    public int mdStatus;

    //public Float limit;
    public Float minsaleamnt;
    public Float maxdiscamnt;
    public int freeitemid;
    public String freeqntylimit;
    public String freeqnty;

    public Integer FTUOnly;

    public Integer VendOnly;
    public String  DiscVendId;
    public String StoreId;


    public int mdUseCount;
    public float mdUsageAmount;

    public DiscountInfo(int id, String name, String desc, int type, int scope, float amnt, int amnttype,
                        String stdt, String enddt, int sts, int usgcnt, float usgamnt, String storeid)
    {
        mdId = id;
        mdName=name;
        mdDescription = desc;
        mdType=type;
        mdScope = scope;
        mdValue = amnt;
        mdAmntType = amnttype;
        mdStartDate = stdt;
        mdEndDate = enddt;
        mdStatus = sts;
        mdUsageAmount = usgamnt;
        mdUseCount = usgcnt;
        StoreId = storeid;
    }

    public boolean isValid()
    {
        String startDay = mdStartDate;
        String endDay = mdEndDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        Date date = new Date();
        try {
            Date d1 = dateFormat.parse(startDay);
            Date d2 = dateFormat.parse(endDay);
            Date curdate= dateFormat.parse(dateFormat.format(date));

            if (curdate.after(d1) && curdate.before(d2)) {
                return true;
            }
            else
                return false;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
