package com.or2go.core;

public class ProductPackInfo {
    public Integer mPackId;
    public Integer mProdId;
    public Integer mUnit;
    public Integer mUnitCount;
    public Integer mUnitAmount;
    public Float   mAmount;
    public Float   mSalePrice;
    public Float   mMaxPrice;
    public String  mPackName;
    public String  mPackType;
    public String  mPackDesc;
    public String  mImgUrl;
    public Integer mDBVer;

    public Integer mInvControl;
    public Float   mCurStk;

    UnitManager mUnitMgr = new UnitManager();

    public ProductPackInfo(Integer packid, Integer prodid, Integer unit, Integer count, Integer unitamount, Float amount, Float price, Float mrp,
                           String name, String type, String desc, String imgurl, Integer dbver)
    {
        this.mPackId = packid;
        this.mProdId = prodid;
        this.mUnit = unit;
        this.mUnitCount = count;
        this.mUnitAmount = unitamount;
        this.mAmount = amount;
        this.mSalePrice = price;
        this.mMaxPrice = mrp;
        this.mPackName = name;
        this.mPackType = type;
        this.mPackDesc = desc;
        this.mImgUrl = imgurl;
        this.mDBVer = dbver;
        this.mInvControl= 0;
        this.mCurStk= Float.valueOf("-1");
    }

    public String getPriceStr()
    {
        return mSalePrice.toString();
    }
    public Float getPrice() { return mSalePrice;}
    public Float getMRP() { return mMaxPrice;}
    public String getMRPStr()
    {
        if (mMaxPrice == null) return "";

        if (mMaxPrice <= mSalePrice) return "";

        return mMaxPrice.toString();
    }

    public Float getDiscountValue()
    {
        if (mMaxPrice == null) return null;
        if (mMaxPrice <= mSalePrice) return null;

        //Float offAmnt = mMaxPrice-mSalePrice;
        Float discPerc = ((mMaxPrice-mSalePrice)/mMaxPrice) *100;

        return discPerc;
    }

    public String getPackAmount()
    { return mAmount.toString();}

    public String getUnitName()
    {
        return mUnitMgr.getUnitName(mUnit);
    }

    public void dumpInfo()
    {
        System.out.println("-------- Product Pack Info ----------");
        System.out.println("-------- Price : "+mSalePrice);
        System.out.println("-------- MRP : "+mMaxPrice);
        System.out.println("-------- Desc : "+mPackDesc);
        System.out.println("-------- Unit : "+mUnit);
        System.out.println("-------- UnitCount : "+mUnitCount);
        System.out.println("-------- UnitAmount : "+mUnitAmount);
        System.out.println("-------- Total Amount : "+mAmount);
        System.out.println("-------------------------------------");
    }
}
