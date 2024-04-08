package com.or2go.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DiscountInfo {
    public int mdId;
    public String mdName;
    public String mdDescription;
    public int mdScope;
    public String mdTarget;
    public Float mdAmount;
    public int mdAmntType;
    public Float minordamnt;
    public Float maxdiscamnt;
    public String mdStartDate;
    public String mdEndDate;
    public int mdStatus;
    public int mdUseCount;
    public float mdUsageAmount;

    public DiscountInfo(int mdId, String mdName, String mdDescription, int mdScope, String mdTarget, Float mdAmount, int mdAmntType, Float minordamnt, Float maxdiscamnt, String mdStartDate, String mdEndDate, int mdStatus, int mdUseCount, float mdUsageAmount) {
        this.mdId = mdId;
        this.mdName = mdName;
        this.mdDescription = mdDescription;
        this.mdScope = mdScope;
        this.mdTarget = mdTarget;
        this.mdAmount = mdAmount;
        this.mdAmntType = mdAmntType;
        this.minordamnt = minordamnt;
        this.maxdiscamnt = maxdiscamnt;
        this.mdStartDate = mdStartDate;
        this.mdEndDate = mdEndDate;
        this.mdStatus = mdStatus;
        this.mdUseCount = mdUseCount;
        this.mdUsageAmount = mdUsageAmount;
    }

    public boolean isValid() {
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
