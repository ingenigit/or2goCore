package com.or2go.core;

public class DeliveryOptionalChargeInfo {
    String mVendorId;
    String mCategory;
    Integer mChargeOption;

    public DeliveryOptionalChargeInfo(String vendid, String cat, Integer opt)
    {
        mVendorId = vendid;
        mCategory = cat;
        mChargeOption = opt;
    }
}
