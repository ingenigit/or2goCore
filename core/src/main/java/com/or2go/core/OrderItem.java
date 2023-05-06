package com.or2go.core;

import static com.or2go.core.UnitManager.GPOS_PROD_UNIT_PC;

public class OrderItem {
    private Integer itemId;
    private String itemName;

    private ProductInfo mProduct;

    //private String brandname;
    private Float itemPrice;
    private Float  itemQnty;
    private Integer itemPriceUnit;
    private Integer itemOrderUnit;
    private Integer orderType;
    private String orderAmount;
    private Integer orderStatus;
    private Integer taxInclusive;
    private Float   taxRate;

    private Float RateNumber;
    private String FeebackText;

    private Integer itemPriceId;
    private Integer itemSKUId;
    //private ProductPriceInfo itemPriceInfo;
    //private ProductSKU itemSKUInfo;

    ////private Integer itemPackId;
    //private Integer itemPackType;
    ///private ProductPackInfo itemPackInfo;
    private UnitManager unitMgr;

    //private Integer invControl;
    private Float curStock;

    public OrderItem(int id, String name, Float price, Float qnty, Integer orderunit, int priceid, int skuid) {
        this.itemId = id;
        this.itemName = name;
        this.itemPrice = price;
        this.itemOrderUnit = orderunit;
        this.itemQnty = qnty;
        this.itemPriceId=priceid;
        this.itemSKUId=skuid;
        this.mProduct = null;
        this.unitMgr = new UnitManager();
        this.curStock = Float.valueOf("-1");
        this.orderStatus = 0;
//        this.itemPriceUnit = priceunit;
    }

    public void setProductInfo(ProductInfo prod)
    { mProduct=prod;}

    public void setName(String name)
    {
        itemName = name;
    }
    public String getName() { return itemName; }

    //public void setBrandName(String name) { brandname = name; }
    public String getBrandName()
    {
        return mProduct.brandname;
    }

    public void setPrice(Float price)
    {
        itemPrice = price;
    }
    public Float getPrice()
    {
        return itemPrice;
    }

    public void setTaxInclusive(int taxincl) { taxInclusive = taxincl;}
    public void setTaxRate(Float rate) { taxRate = rate;}
    public boolean isTaxInclusive() { return ((mProduct.taxincl ==1) ? true: false);}
    public Float getTaxRate() {return mProduct.taxrate;}

    public void setQnty(String qnty)
    {
        itemQnty = Float.parseFloat(qnty);
    }
    public void setQnty(Float qnty)
    {
        itemQnty = qnty;
    }
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

    //public void setPriceId(Integer id) { itemPriceId = id;}
    public Integer getPriceId() { return itemPriceId;}
    //public void setSKUId(Integer id) { itemSKUId = id;}
    public Integer getSKUId() { return itemSKUId;}

    //public void setPackType(Integer type) { itemPackType = type;}
    //public Integer getPackType() { return itemPackType;}

    ///public void setPackInfo(ProductPackInfo pkinfo) { itemPackInfo = pkinfo;}
    ///public ProductPackInfo getPackInfo() { return itemPackInfo;}
    //public void setPriceInfo(ProductPriceInfo priceinfo) { itemPriceInfo = priceinfo;}
    //public ProductPriceInfo getPriceInfo() { return mProduct.getPriceInfo(itemPriceId);}

    //public void setSKUInfo(ProductSKU skuinfo) { itemSKUInfo = skuinfo;}
    public ProductSKU getSKUInfo() { return mProduct.getSKU(itemSKUId);}

    //public void setInventoryControl(Integer inv) { invControl = inv;}
    public Integer getInvControl() {return  mProduct.invcontrol;}

    public void setCurStock(Float stk) {curStock= stk;}
    public Float getCurStock(){return curStock;}

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

    void setOrderUnit(Integer orunit)
    {
        itemOrderUnit = orunit;
    }

    public Integer getOrderUnit()
    {
        return itemOrderUnit;
    }

    public Integer getPriceUnit() { return mProduct.unit;/*itemPriceUnit*/ }

    public Integer getStatus()
    {
        return orderStatus;
    }
    public void setStatus(Integer sts)
    {
        orderStatus = sts;
    }

    public void addQuantity(Float qnty, Integer orderunit)
    {
        Float newqnty;
        ///TBF
        ///if (itemPackType != OR2GO_PRODUCT_PACK_TYPE_NONE)
//        if (itemOrderUnit == orderunit)  // in DA
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
//        if (itemOrderUnit == orderunit) //in DA
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

    public Float getRateNumber() {
        return RateNumber;
    }

    public void setRateNumber(Float rateNumber) {
        RateNumber = rateNumber;
    }

    public String getFeebackText() {
        return FeebackText;
    }

    public void setFeebackText(String feebackText) {
        FeebackText = feebackText;
    }
}
