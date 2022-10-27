package com.or2go.core;

public class ProductSKU {
    public Integer mSKUId;
    public Integer mProdId;
    public String  mName;
    public String  mDescription;
    public Integer mUnit;
    public Integer mUnitCount;
    public Integer mUnitAmount;
    public Float mAmount;
    public String  mSize;
    public String  mColor;
    public String  mModel;
    public String  mDimension;
    public String  mWeight;
    public String  mPkgType;
    public Integer mDBVer;
    public ProductSKU(Integer id, Integer pid, String name, String desc, Integer unit, Integer ucount, Integer uamount, Float amount,
                      String size, String color, String model, String weight, String dimen, String pkgtype, Integer dbver){
        this.mSKUId = id;
        this.mProdId = pid;
        this.mName = name;
        this.mDescription = desc;
        this.mUnit = unit;
        this.mUnitCount = ucount;
        this.mUnitAmount = uamount;
        this.mAmount = amount;
        this.mSize = size;
        this.mColor = color;
        this.mModel = model;
        this.mDimension = dimen;
        this.mWeight = weight;
        this.mPkgType = pkgtype;
        this.mDBVer = dbver;
    }
}
