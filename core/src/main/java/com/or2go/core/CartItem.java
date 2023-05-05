package com.or2go.core;

import static com.or2go.core.UnitManager.GPOS_PROD_UNIT_PC;

public class CartItem {
    public Integer itemId;
    public String itemName;

    public ProductInfo mProduct;

    public Float itemPrice;
    public Float  itemQnty;
    public Integer itemOrderUnit;
    public Integer orderType;
    public String orderAmount;


    public Integer itemPriceId;
    public Integer itemSKUId;

    public UnitManager unitMgr;

    public Float curStock;

    public CartItem(int id, String name, Float price, Float qnty, Integer orderunit, int priceid, int skuid) {
        itemId = id;
        itemName = name;
        itemPrice = price;
        itemOrderUnit = orderunit;
        itemQnty = qnty;
        itemPriceId=priceid;
        itemSKUId=skuid;

        mProduct = null;
        unitMgr = new UnitManager();
        curStock = Float.valueOf("-1");
    }

    public void setProductInfo(ProductInfo prod)
    { mProduct=prod;}

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
    public Float getPrice()
    {
        return itemPrice;
    }

    public boolean isTaxInclusive() { return ((mProduct.getSKU(itemSKUId).mTaxInclusive ==1) ? true: false);}
    public Float getTaxRate() {return mProduct.taxrate;}


    public void setQnty(String qnty)
    {
        itemQnty = Float.parseFloat(qnty);
    }
    public void setQnty(Float qnty)
    {
        itemQnty = qnty;
    }

    //public void setPriceId(Integer id) { itemPriceId = id;}
    public Integer getPriceId() { return itemPriceId;}
    //public void setSKUId(Integer id) { itemSKUId = id;}
    public Integer getSKUId() { return itemSKUId;}
    //public ProductPriceInfo getPriceInfo() { return mProduct.getPriceInfo(itemPriceId);}
    public ProductSKU getSKUInfo() { return mProduct.getSKU(itemSKUId);}
    public Integer getInvControl() {return  mProduct.invcontrol;}

    public void setCurStock(Float stk) {curStock= stk;}
    public Float getCurStock(){return curStock;}

    public String getQnty()
    {
        //if (itemOrderUnit.equals("Pc"))
        if (itemOrderUnit == GPOS_PROD_UNIT_PC)
        {
            float f = itemQnty;
            Integer nqnty = (int) f;

            return nqnty.toString();
        }
        else
            return itemQnty.toString();
    }



    public Float getQntyVal()
    {
        return itemQnty;
    }

    public void setOrderAmount(String amount)
    {
        orderAmount = amount;
    }

    public String getOrderAmount()
    {
        return orderAmount;
    }

    public void setOrderType(Integer type)
    {
        orderType = type;
    }

    public Integer getOrderType()
    {
        return orderType;
    }

    public void setID(int id)
    {
        itemId = id;
    }

    public Integer getId()
    {
        return itemId;
    }

    public void setOrderUnit(Integer orunit)
    {
        itemOrderUnit = orunit;
    }

    public Integer getOrderUnit()
    {
        return itemOrderUnit;
    }

    public Integer getPriceUnit() { return mProduct.unit;/*itemPriceUnit*/ }

    public void addQuantity(Float qnty, Integer orderunit)
    {
        Float newqnty;

        ///TBF
        ///if (itemPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        {
            itemQnty = itemQnty + qnty;
        }
        /*else
        {
            UnitManager unitmgr = new UnitManager();
            itemQnty = itemQnty + unitmgr.getConvertedQnty(qnty, orderunit, itemOrderUnit);
        }*/

    }

    public void removeQuantity(Float qnty, Integer orderunit)
    {
        Float newqnty;

        ///TBF
        /////if (itemPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        {//make sure remaining quantity remains non-negative
            if (itemQnty >= qnty)
                itemQnty = itemQnty - qnty;
        }
        /*else
        {
            UnitManager unitmgr = new UnitManager();
            Float convqnty = unitmgr.getConvertedQnty(qnty, orderunit, itemOrderUnit);
            if(itemQnty >= convqnty)
                itemQnty = itemQnty - convqnty;
        }*/
    }

    public String getUnitName()
    {
        return unitMgr.getUnitName(itemOrderUnit);
    }

    public boolean isWholeItem()
    {
        if (itemOrderUnit == GPOS_PROD_UNIT_PC)
            return true;
        else
            return false;
    }

    public float getItemActualTotal() {
        float tot=0;
        float ordrqnty = itemQnty;
        //ProductPriceInfo productPriceInfo = getPriceInfo();
        ProductSKU skuInfo = getSKUInfo();
        if (true) {
            tot = skuInfo.mMRP * ordrqnty;//itemQnty;
        }
        else if (mProduct.unit == itemOrderUnit) {
            tot = skuInfo.mMRP * ordrqnty;
        }
        else {
            if (mProduct.unit.equals("Kg") && itemOrderUnit.equals("G"))
            {
                tot = (skuInfo.mMRP/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("G") && itemOrderUnit.equals("Kg"))
            {
                tot = (skuInfo.mMRP* ordrqnty * 1000);
            }
            if (mProduct.unit.equals("L") && itemOrderUnit.equals("Ml"))
            {
                tot = (skuInfo.mMRP/1000) * ordrqnty;//itemQnty;
            }
            else if (mProduct.unit.equals("Ml") && itemOrderUnit.equals("L"))
            {
                tot = (skuInfo.mMRP * ordrqnty * 1000);
            }
            if (mProduct.unit.equals("M") && itemOrderUnit.equals("Mm"))
            {
                tot = (skuInfo.mMRP/1000) * ordrqnty;
            }
            else if (mProduct.unit.equals("Mm") && itemOrderUnit.equals("M"))
            {
                tot = (skuInfo.mMRP * ordrqnty * 1000);
            }
        }

        //System.out.println("OrderItem geTotal ="+tot);
        return tot;
    }

    public float getItemTotal()
    {
        float tot=0;

        ///if (orderType.equals("Amount"))
        ///	return (Float.parseFloat(orderAmount));

        float ordrqnty = itemQnty;

        //Log.i("OrderItem" , "PackType="+itemPackType);
        //if (itemPriceUnit.equals(itemOrderUnit))
        if (true) //TBF  //(itemPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
        {
            tot = itemPrice * ordrqnty;//itemQnty;
        }
        else if (mProduct.unit == itemOrderUnit)
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
}
