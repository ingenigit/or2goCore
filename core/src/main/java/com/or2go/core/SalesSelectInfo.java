package com.or2go.core;

import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_TAG_FOOD_NONVEG;
import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_TAG_FOOD_VEG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesSelectInfo {
    private ProductInfo mProduct;
    ///private Float   mQnty;
    public HashMap<Integer, Float> mapQuantity;
    public Integer mPriceSelectId;
    public Integer mSKUSelectId;

    public Integer mFoodType;
    public List<String> mVisualTags;
    public List<String>  mTextTags;

    UnitManager mUnitMgr = new UnitManager();

    public SalesSelectInfo(ProductInfo prod)
    {
        /*super(prod.id, prod.name, prod.brandname, prod.desc, prod.category, prod.subcategory,
                prod.code, prod.gstcode, prod.barcode, prod.property, prod.tag, prod.invcontrol);*/
        mProduct = prod;
        //mQnty = Float.parseFloat("0");
        mapQuantity = new HashMap<Integer, Float>();
        mSKUSelectId=0;
        mPriceSelectId=0;

        mFoodType=0;
        mVisualTags = new ArrayList<String>();
        mTextTags = new ArrayList<String>();

        processTags();
    }

    //public void setQnty(Float qnty) { mQnty= qnty; }
    //public Float getQuantity() {return mQnty;}
    public void setQuantity(Integer priceid, Float qnty) { mapQuantity.put(priceid, qnty); }
    public Float getQuantity(Integer priceid) {return mapQuantity.get(priceid);}

    public void setSelSKU(Integer skuid) {mSKUSelectId= skuid;}
    public Integer getSelectedSKU() {return mSKUSelectId;}
    public Integer getSelectedPrice() {return mPriceSelectId;}

    public ProductInfo getProduct() { return mProduct;}
    public Integer getId() {return mProduct.id;}
    public String getName() { return mProduct.name;}
    public String getBrand() { return mProduct.brandname;}
    public String getDesc() { return mProduct.desc;}

    public ArrayList<ProductPriceInfo> getPriceList() {return mProduct.getPriceInfoList();}
    public ProductPriceInfo getSelectedPriceInfo() {
        if ((mProduct.getPriceInfoList() ==null) || (mProduct.getPriceInfoList().size()==0)) return null;
        if(mSKUSelectId==0) return mProduct.getPriceInfoList().get(0);

        int plistsize=mProduct.getPriceInfoList().size();
        for(int i=0;i<plistsize;i++)
        {
            ProductPriceInfo packinfo = mProduct.getPriceInfoList().get(i);
            if (packinfo.mPriceId.equals(mPriceSelectId))
                return packinfo;
        }

        return mProduct.getPriceInfoList().get(0);
    }

    public ArrayList<ProductSKU> getSKUList() {return mProduct.getSKUList();}
    public ProductSKU getSelectedSKUInfo() {
        if ((mProduct.getSKUList() ==null) || (mProduct.getSKUList().size()==0)) return null;
        if(mSKUSelectId==0) return mProduct.getSKUList().get(0);

        int plistsize=mProduct.getSKUList().size();
        for(int i=0;i<plistsize;i++)
        {
            ProductSKU skuinfo = mProduct.getSKUList().get(i);
            if (skuinfo.mSKUId == mSKUSelectId)
                return skuinfo;
        }

        return mProduct.getSKUList().get(0);
    }

    /*public boolean setQuantity(Float newqnty) {
        mQnty = newqnty;
        return true;
    }*/

    public boolean incQuantity(Integer priceid)
    {
        //mQnty = mQnty +1;
        Float qnty = mapQuantity.get(priceid);
        if (qnty==null) qnty = Float.parseFloat("0");
        mapQuantity.put(priceid, qnty+1);
        return true;
    }

    public boolean decQuantity(Integer priceid)
    {
        //mQnty = mQnty - 1;
        Float qnty = mapQuantity.get(priceid);
        if (qnty== null) return false;
        if (qnty==0) return false;
        mapQuantity.put(priceid, qnty-1);
        return true;
    }

    public boolean isQntyEmpty(Integer priceid)
    {
        if (mapQuantity.get(priceid) == 0) return true;
        else
            return false;
    }

    public String getViewQnty(Integer priceid)
    {
        Float nqnty = mapQuantity.get(priceid);
        if (nqnty== null) return "0";
        //if (mPriceUnit == GPOS_PROD_UNIT_PC)
        ////if (mPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        //{
        //mQnty.intValue();
        return (nqnty.toString());
        //}
        /*else {
            return (mQnty.toString()+mUnitMgr.getUnitName(mPriceUnit));
        }*/
    }

    public boolean isMultiPack() { return (mProduct.getPriceInfoList().size() > 1) ? true: false;}
    public boolean isInventoryControl() { return ((mProduct.invcontrol>0) ? true: false); }


    private void processTags()
    {
        if ((mProduct.tag == null) || (mProduct.tag.isEmpty()) || (mProduct.tag.equals("null")) )
            return;

        String[] tags = mProduct.tag.trim().split("\\s*,\\s*");

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
