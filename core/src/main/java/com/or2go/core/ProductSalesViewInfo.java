package com.or2go.core;

import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_PACK_TYPE_MULTI;
import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_PACK_TYPE_NONE;
import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_PACK_TYPE_SINGLE;
import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_TAG_FOOD_NONVEG;
import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_TAG_FOOD_VEG;

import java.util.ArrayList;
import java.util.List;

public class ProductSalesViewInfo {
    private int mId;
    private String mName;
    private String mBrand;
    private String mDesc;
    private Float mPrice;
    private Float mMaxPrice;
    private Integer mPriceType;
    private Integer mPriceUnit;
    private Integer mOrderUnit;
    private Integer mPackType;
    private Float mQnty;

    private int mInventoryMgmt;

    private String mTag;
    public Integer mFoodType;
    public List<String> mVisualTags;
    public List<String> mTextTags;

    private String mImgUrl;
//    private Bitmap image;

    UnitManager mUnitMgr = new UnitManager();

    ArrayList<ProductPackInfo> mPackInfoList;
    Integer mPackSelectId;

    public ProductSalesViewInfo(int id, String name, String brname, String desc, Float price, int pricetype, int  unit, String tag)
    {
        super();
        this.mId =id;
        this.mName = name;
        this.mBrand = brname;
        this.mDesc = desc;
        this.mPrice = price;
        this.mPriceType = pricetype;
        this.mPriceUnit = unit;
        this.mQnty = Float.parseFloat("0");
        this.mTag = tag;
        this.mPackType=OR2GO_PRODUCT_PACK_TYPE_SINGLE;
        this.mFoodType=0;
        this.mVisualTags = new ArrayList<String>();
        this.mTextTags = new ArrayList<String>();
        this.mPackSelectId =0;
        this.mInventoryMgmt=0;
        processTags();
    }

//    public Bitmap getImage() {
//        return image;
//    }

//    public void setImage(Bitmap image) {
//        this.image = image;
//    }

    public String getName() { return mName; }
    public String getBrand() { if ((mBrand==null) || (mBrand.equals("null"))) return "";
    else return mBrand; }
    public String getDesc() { return mDesc;}

    /*
    public void setmName(String title) {
        mName = title;
    }*/

    public int getId() {
        return mId;
    }

    public String getPrice() {
        return mPrice.toString();
    }

    public boolean setPrice(Float newprice) {
        mPrice = newprice;

        return true;
    }

    public String getMRPStr() {
        if (mMaxPrice == null) return "";
        if (mMaxPrice <= mPrice) return "";
        return mMaxPrice.toString();
    }
    public Integer getPriceUnit() {
        return mPriceUnit;
    }
    //public Integer getOrderUnit() {return mOrderUnit;}
    public void setOrderUnit(Integer unit) { mOrderUnit = unit;}
    public String getUnitName(){ return mUnitMgr.getUnitName(mPriceUnit);}

    public Float getQnty() {
        return mQnty;
    }

    public String getViewQnty()
    {
        //if (mPriceUnit == GPOS_PROD_UNIT_PC)
        if (mPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        {
            Integer nqnty = mQnty.intValue();
            return (nqnty.toString());
        }
        else {
            return (mQnty.toString()+mUnitMgr.getUnitName(mPriceUnit));
        }
    }

    public boolean setQuantity(Float newqnty) {
        mQnty = newqnty;
        return true;
    }

    public boolean incQuantity()
    {
        mQnty = mQnty +1;
        return true;
    }

    public boolean decQuantity()
    {
        mQnty = mQnty - 1;
        return true;
    }

    public boolean isQntyEmpty()
    {
        if (mQnty == 0) return true;
        else
            return false;
    }

    public boolean isInventoryControl() { return ((mInventoryMgmt>0) ? true: false); }
    public void setInventoryMgmt(int val) {mInventoryMgmt=val;}
    public int getInventoryControl() { return mInventoryMgmt;}


    public String[] getTags()
    {
        /*if (mTag != null)
            System.out.println("SalesViewInfo product:"+mName+"      Tag=" + mTag);
        else
            System.out.println("SalesViewInfo  :  Tag is null");*/
        if ((mTag == null) || (mTag.isEmpty()) || (mTag.equals("null")) )
            return null;

        String[] tags = mTag.trim().split("\\s*,\\s*");
        //int n = tags.length;
        //System.out.println("SalesViewInfo  :  Tag break count=" + n);
        //for (int i=0; i < n; i++)
        //    System.out.println("SalesViewInfo  :  Tag=" + tags[i]);

        return tags;
    }

    public void setMultiPack() { mPackType=OR2GO_PRODUCT_PACK_TYPE_MULTI;}
    public void setPackType(Integer pktype) { mPackType=pktype;}
    public Integer getPackType() { return mPackType;}

    public  boolean isMultiPack() { return ((mPackType==OR2GO_PRODUCT_PACK_TYPE_MULTI)? true: false);}

    public  boolean isNonePack() { return ((mPackType==OR2GO_PRODUCT_PACK_TYPE_NONE)? true: false);}

    public synchronized boolean addMultiPackInfo(ProductPackInfo packinfo)
    {
        if (packinfo== null) return false;

        if (mPackInfoList == null) mPackInfoList= new ArrayList<ProductPackInfo>();

        mPackInfoList.add(packinfo);

        return true;
    }

    public ArrayList<ProductPackInfo> getPackInfoList()
    {
        return mPackInfoList;
    }

    public boolean setPackInfoList(ArrayList<ProductPackInfo> packinfolist)
    {
        mPackInfoList=packinfolist;
        return true;
    }

    public ProductPackInfo getSelectedPackInfo()
    {
        if ((mPackInfoList ==null) || (mPackInfoList.size()==0)) return null;
        if(mPackSelectId==0) return mPackInfoList.get(0);

        int plistsize=mPackInfoList.size();
        for(int i=0;i<plistsize;i++)
        {
            ProductPackInfo packinfo = mPackInfoList.get(i);
            if (packinfo.mPackId == mPackSelectId)
                return packinfo;
        }
        return mPackInfoList.get(0);
    }

    public boolean isOutOfStock()
    {
        ProductPackInfo packinfo = getSelectedPackInfo();

        if ((mInventoryMgmt==1) && (packinfo.mCurStk == 0)) {
            return true;
        }
        else
            return false;
    }

    public int getOrderUnit()
    {
        if (mPackInfoList != null) {

            int packcnt = mPackInfoList.size();
            for(int i=0; i< packcnt;i++)
            {
                ProductPackInfo packInfo = mPackInfoList.get(i);
                if (packInfo.mPackId ==  mPackSelectId)
                    return packInfo.mUnit;
            }
            return mOrderUnit;
        }
        else
            return mOrderUnit;
    }

    private void processTags()
    {
        if ((mTag == null) || (mTag.isEmpty()) || (mTag.equals("null")) )
            return;

        String[] tags = mTag.trim().split("\\s*,\\s*");

        int n = tags.length;

        for (int i = 0; i < n; i++) {
            String curtag = tags[i];
            if (curtag.equals("Veg")) {
                mFoodType = OR2GO_PRODUCT_TAG_FOOD_VEG;
            }
            else if (curtag.equals("Non Veg")) {
                mFoodType = OR2GO_PRODUCT_TAG_FOOD_NONVEG;
            }
            else if (curtag.equals("New")|| curtag.equals("Best Seller") || curtag.equals("Must Try") || curtag.equals("Popular") || curtag.equals("On Sale")){
                mVisualTags.add(curtag);
            }
            else
                mTextTags.add(curtag);
        }
    }
}
