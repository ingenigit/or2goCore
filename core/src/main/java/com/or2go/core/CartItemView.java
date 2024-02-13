package com.or2go.core;

import static com.or2go.core.UnitManager.GPOS_PROD_UNIT_PC;

public class CartItemView {
    BaseCartItem bcItem;
    public ProductInfo mProduct;
    public ProductSKU mSKU;

    UnitManager mUnitMgr;

    public CartItemView(BaseCartItem baseitem, ProductInfo prdinfo, ProductSKU skuinfo)
    {
        bcItem = baseitem;
        mProduct = prdinfo;
        mSKU = skuinfo;

        mUnitMgr = new UnitManager();

    }

    public Integer getId()
    {
        return bcItem.getId();
    }
    public Integer getSKUId() { return bcItem.getSKUId();}
    public ProductSKU getSKUInfo() { return mSKU;}

    public String getName()
    {
        return mProduct.name;
    }
    public String getImage()
    {
        return mProduct.imgurl;
    }
    public String getBrandName()
    {
        return mProduct.brandname;
    }
    public Float getPrice() {return mSKU.getPrice();}

    public Integer getInvControl() {return  mProduct.invcontrol;}
    public boolean isTaxInclusive() { return ((mProduct.taxincl ==1) ? true: false);}
    public Float getTaxRate() {return mProduct.taxrate;}

    public void setQnty(Float qnty) {bcItem.setQnty(qnty);}
    public void setQnty(String qnty) {bcItem.setQnty(Float.parseFloat(qnty));}
    public String getQnty() {return bcItem.getQnty();}
    public Float getQntyVal()
    {
        return bcItem.getQntyVal();
    }
    //
    public void addQuantity(Float qnty, Integer orderunit) { bcItem.addQuantity(qnty, orderunit);}
    public void removeQuantity(Float qnty, Integer orderunit){bcItem.removeQuantity(qnty, orderunit);}


    public int getImagePath(){
        return mProduct.imagepath;
    }

    public String getUnitName()
    {
        return mUnitMgr.getUnitName(bcItem.getOrderUnit());
    }

    public boolean isWholeItem()
    {
        if (bcItem.getOrderUnit() == GPOS_PROD_UNIT_PC)
            return true;
        else
            return false;
    }

    public void setCurStock(Float stk) {bcItem.setCurStock(stk);}
    public Float getCurStock(){return bcItem.getCurStock();}

    ////////////////////
    public float getItemMRPTotal(BaseCartItem cartitem) {
        float tot=0;
        float ordrqnty = cartitem.getQntyVal();//itemQnty;
        //ProductPriceInfo productPriceInfo = getPriceInfo();

        if (true) {
            tot = mSKU.mMRP * ordrqnty;//itemQnty;
        }
        else if (mProduct.unit == cartitem.itemOrderUnit) {
            tot = mSKU.mMRP * ordrqnty;
        }
        else {
            if (mProduct.unit.equals("Kg") && cartitem.itemOrderUnit.equals("G"))
            {
                tot = (mSKU.mMRP/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("G") && cartitem.itemOrderUnit.equals("Kg"))
            {
                tot = (mSKU.mMRP* ordrqnty * 1000);
            }
            if (mProduct.unit.equals("L") && cartitem.itemOrderUnit.equals("Ml"))
            {
                tot = (mSKU.mMRP/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("Ml") && cartitem.itemOrderUnit.equals("L"))
            {
                tot = (mSKU.mMRP * ordrqnty * 1000);
            }
            if (mProduct.unit.equals("M") && cartitem.itemOrderUnit.equals("Mm"))
            {
                tot = (mSKU.mMRP/1000) * ordrqnty;
            }
            else if (mProduct.unit.equals("Mm") && cartitem.itemOrderUnit.equals("M"))
            {
                tot = (mSKU.mMRP * ordrqnty * 1000);
            }
        }

        //System.out.println("OrderItem geTotal ="+tot);
        return tot;
    }

    public float getItemTotal(BaseCartItem cartitem)
    {
        //ProductInfo mProduct = mCurProductMgr.getProductInfo(cartitem.getId());
        //ProductSKU skuInfo = mCurProductMgr.getProdSKU(cartitem.getId(), cartitem.getSKUId());

        float tot=0;

        ///if (orderType.equals("Amount"))
        ///	return (Float.parseFloat(orderAmount));

        float ordrqnty = cartitem.getQntyVal();//itemQnty;
        float itemPrice = mSKU.mPrice;

        String itemOrderUnit = mUnitMgr.getUnitName(cartitem.getOrderUnit());

        //Log.i("OrderItem" , "PackType="+itemPackType);
        //if (itemPriceUnit.equals(itemOrderUnit))
        if (true) //TBF  //(itemPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        {
            tot = itemPrice * ordrqnty;//itemQnty;
        }
        else if (mProduct.unit == cartitem.getOrderUnit())
        {
            tot = itemPrice * ordrqnty;
        }
        else
        {
//            Log.i("OrderItem" , "PriceUnit="+mProduct.unit+" OrderUnit="+itemOrderUnit);
//            Log.i("OrderItem" , "Price="+itemPrice+" Quantity="+ordrqnty);

            if (mProduct.unit.equals("Kg") && itemOrderUnit.equals("G"))
            {
                tot = (itemPrice/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("G") && itemOrderUnit.equals("Kg"))
            {
                tot = (itemPrice * ordrqnty * 1000);
            }
            if (mProduct.unit.equals("L") && itemOrderUnit.equals("Ml"))
            {
                tot = (itemPrice/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("Ml") && itemOrderUnit.equals("L"))
            {
                tot = (itemPrice * ordrqnty * 1000);
            }
            if (mProduct.unit.equals("M") && itemOrderUnit.equals("Mm"))
            {
                tot = (itemPrice/1000) * ordrqnty;
            }
            else if (mProduct.unit.equals("Mm") && itemOrderUnit.equals("M"))
            {
                tot = (itemPrice * ordrqnty * 1000);
            }
        }

        //System.out.println("OrderItem geTotal ="+tot);
        return tot;
    }
    ////////////////////////

}
