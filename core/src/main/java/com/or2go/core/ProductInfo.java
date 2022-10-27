package com.or2go.core;

import static com.or2go.core.Or2goConstValues.OR2GO_PRODUCT_PACK_TYPE_SINGLE;

import java.util.ArrayList;

public class ProductInfo {
    public Integer id;
    public String 	name;
    public String 	brandname;
    public String  shortname;
    public Integer	type;
    public String	category;
    public String	subcategory;
    public String	code;
    public String	gstcode;
    public String	barcode;
    public String   property;
    //String	price;
    //String	unit;
    public Integer packtype;
    public Float    maxprice;
    public Float	price;
    public Integer	pricetype;
    public Integer	unit;
    public Integer taxincl;
    public Float   taxrate;
    //Integer varprice;
    public String	discrate;
    public String  disctype;

    public String	desc;
    public String   tag;

    //
    public Integer salestatus;
    //inventory control
    public Integer invcontrol;

    ///byte[]	imgdata;
//    public Bitmap	itemimg;
    public String  imgurl;
    public ArrayList<ProductPriceInfo> mPriceInfoList;

    public ArrayList<ProductSKU> mSKUList;

    public ProductInfo()
    {
        id = 0;
        name=category=subcategory=code=gstcode=barcode=desc=tag="";

        type=pricetype=unit=taxincl=0;

        packtype=OR2GO_PRODUCT_PACK_TYPE_SINGLE;

        //imgdata=null;
//        itemimg = null;
        mPriceInfoList=null;

        mSKUList = null;
    }


    public ProductInfo(int prdid, String pname, String brand, String pdesc, String cat, String subcat,
                       String pcode, String hsncode, String pbarcode,String prop, String tags, Integer inv)
    {
        id = prdid;
        name = pname;
        brandname = brand;
        desc = pdesc;
        category= cat;
        subcategory= subcat;
        code = pcode;
        gstcode= hsncode;
        barcode=pbarcode;
        property= prop;
        invcontrol= inv;

        mPriceInfoList= new ArrayList<ProductPriceInfo>();
        mSKUList = new ArrayList<ProductSKU>();;
    }

    ///access

    public void setId(int sid)
    {
        id = sid;
    }
    public void setName(String prdname) { name = prdname;}
    public void setBrandName(String bname) { brandname=bname;}
    public void setDescription(String prddesc) { desc = prddesc;}
    public void setType(Integer prdtype) { type = prdtype;}
    public void setCategory(String prdtype) { category = prdtype;}
    public void setSubCategory(String prdsubtype) { subcategory = prdsubtype;}
    public void setUnit(Integer prdunit) { unit = prdunit;}
    public void setPrice(Float prdprice) { price = prdprice;}
    public void setMaxPrice(Float prdmaxprice) { maxprice = prdmaxprice;}
    public void setPackType(Integer type) { packtype = type;}
    public void setTaxIncl(Integer incl) {taxincl = incl;}
    public void setTaxRate(Float rate) {taxrate = rate;}
    public void setTags(String prtag) { tag = prtag;}
    public void setImageURL(String url) { imgurl = url;}
    public void setInventoryControl(Integer invctrl) { invcontrol = invctrl;}

    public void setProductCode(String cd) { code = cd;}
    public void setHSNCode(String cd) { gstcode = cd;}
    public void setBarCode(String cd) { barcode = cd;}

    public void setProperty(String pt) { property = pt;}
    public void setSaleStatus(int salests) { salestatus = salests;}


    public String getTags() { return tag;}
    public String getDescription() { return desc;}

    public Integer getPacktype() { return  packtype;}
    public Float getMaxPrice() {return  maxprice;}
    public String getImageURL() {return  imgurl;}

    //Price control functions
    public synchronized boolean addPriceInfo(ProductPriceInfo priceinfo)
    {
        if (priceinfo== null) return false;

        if (mPriceInfoList == null) mPriceInfoList= new ArrayList<ProductPriceInfo>();

        mPriceInfoList.add(priceinfo);

        return true;

    }

    public boolean setPriceInfoList(ArrayList<ProductPriceInfo> pricelist)
    {
        if ((pricelist == null) || (pricelist.size()==0)) return false;

        mPriceInfoList.clear();
        mPriceInfoList = pricelist;
        return true;
    }

    public ArrayList<ProductPriceInfo> getPriceInfoList()
    {
        return mPriceInfoList;
    }

    public ProductPriceInfo getPriceInfo(int id)
    {
        if (mPriceInfoList == null) return null;

        int packcnt = mPriceInfoList.size();
        if (packcnt==1) return mPriceInfoList.get(0);

        for(int i=0;i<packcnt;i++)
        {
            ProductPriceInfo pkinfo = mPriceInfoList.get(i);

            if (pkinfo.mPriceId == id) return pkinfo;
        }

        return null;

    }

    ///SKU control functions
    public synchronized boolean addSKUInfo(ProductSKU skuinfo)
    {
        if (skuinfo== null) return false;

        if (mSKUList == null) mSKUList= new ArrayList<ProductSKU>();

        mSKUList.add(skuinfo);

        return true;

    }

    public ArrayList<ProductSKU> getSKUList()
    {
        return mSKUList;
    }

    public ProductSKU getSKU(int id)
    {
        if (mSKUList == null) return null;

        int packcnt = mSKUList.size();
        if (packcnt==1) return mSKUList.get(0);

        for(int i=0;i<packcnt;i++)
        {
            ProductSKU skuinfo = mSKUList.get(i);

            if (skuinfo.mSKUId == id) return skuinfo;
        }

        return null;

    }


    //Inventory control functions
    public boolean setStock(int packid, Float stkval)
    {
        ProductPriceInfo pkinfo = getPriceInfo(packid);
        if (pkinfo == null) return false;

        pkinfo.mCurStk = stkval;

        return true;
    }
}
