package com.or2go.core;

public class ProductPriceInfo {
    public Integer mPriceId;
    public Integer mProdId;
    public Integer mSKUId;

    public Integer mUnit;
    public Float   mAmount;
    public Float   mSalePrice;
    public Float   mMaxPrice;
    public Integer mDBVer;

    public Integer mTaxInclusive;
    public Integer mManualPrice;
    public Float   mCurStk;

    UnitManager mUnitMgr = new UnitManager();

    public ProductPriceInfo(Integer priceid, Integer prodid, Integer skuid,Integer unit,  Float amount, Float price, Float mrp, Integer taxincl,
                            Integer manualprice, Integer dbver) {
        this.mPriceId = priceid;
        this.mProdId = prodid;
        this.mSKUId = skuid;
        this.mUnit = unit;
        this.mAmount = amount;
        this.mSalePrice = price;
        this.mMaxPrice = mrp;
        this.mDBVer = dbver;
        this.mTaxInclusive = taxincl;
        this.mManualPrice= manualprice;
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

    public String getAmount()
    { return mAmount.toString(); }

    public String getUnitName()
    {
        return mUnitMgr.getUnitName(mUnit);
    }

    public void dumpInfo()
    {
        System.out.println("-------- Product Price Info ----------");
        System.out.println("-------- Price : "+mSalePrice);
        System.out.println("-------- MRP : "+mMaxPrice);
        System.out.println("-------- Unit : "+mUnit);
        System.out.println("-------- Total Amount : "+mAmount);
        System.out.println("-------------------------------------");
    }
}
