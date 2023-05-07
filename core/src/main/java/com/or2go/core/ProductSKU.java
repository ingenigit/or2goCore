package com.or2go.core;

public class ProductSKU {
    public Integer mSKUId;
    public Integer mProdId;
    public String  mName;
    public String  mDescription;
    public Integer mUnit;
    //public Integer mUnitCount;
    //public Integer mUnitAmount;
    public Float mAmount;
    public Float   mPrice;
    public Float   mMRP;
    //public Integer mTaxInclusive;
    public String  mSize;
    public String  mColor;
    public String  mModel;
    public String  mDimension;
    public String  mWeight;
    public String  mPkgType;
    public Integer mDBVer;
    //public ProductSKU(Integer id, Integer pid, String name, String desc, Integer unit, /*Integer ucount, Integer uamount,*/ Float amount,
    //                  String size, String color, String model, String weight, String dimen, String pkgtype, Integer dbver)
    public ProductSKU(Integer id, Integer pid, String name, String desc, Integer unit, Float amount, Float price, Float mrp,
                      String size, String color, String model, String weight, String dimen, String pkgtype)
    {
        this.mSKUId = id;
        this.mProdId = pid;
        this.mName = name;
        this.mDescription = desc;
        this.mUnit = unit;
        //this.mUnitCount = ucount;
        //this.mUnitAmount = uamount;
        this.mAmount = amount;
        this.mAmount = amount;
        this.mPrice = price;
        this.mMRP = mrp;
        //this.mTaxInclusive=taxincl;

        this.mSize = size;
        this.mColor = color;
        this.mModel = model;
        this.mDimension = dimen;
        this.mWeight = weight;
        this.mPkgType = pkgtype;
        //this.mDBVer = dbver;
    }

    public Float getPrice() { return mPrice;}
    public Float getMRP() { return mMRP;}
    public String getMRPStr()
    {
        if (mMRP == null) return "";
        if (mMRP <= mPrice) return "";

        return mMRP.toString();
    }

    public Float getDiscountValue()
    {
        if (mMRP == null) return null;
        if (mMRP <= mPrice) return null;

        //Float offAmnt = mMaxPrice-mSalePrice;
        Float discPerc = ((mMRP-mPrice)/mMRP) *100;

        return discPerc;
    }

    public String getAmount() { return mAmount.toString(); }

}
