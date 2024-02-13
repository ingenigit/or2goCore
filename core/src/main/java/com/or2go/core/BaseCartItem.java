package com.or2go.core;

import static com.or2go.core.UnitManager.GPOS_PROD_UNIT_PC;

public class BaseCartItem {
    public Integer itemId;
    public Integer itemSKUId;
    public Float  itemQnty;
    public Integer itemOrderUnit;

    public Float curStock;

    public BaseCartItem(Integer itemid, Integer skuid, Float qnty, Integer unit)
    {
        itemId = itemid;
        itemSKUId = skuid;
        itemQnty = qnty;
        itemOrderUnit = unit;

        curStock = Float.valueOf("-1");
    }

    public Integer getId()
    {
        return itemId;
    }
    public Integer getSKUId() { return itemSKUId;}

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

    public Float getQntyVal()
    {
        return itemQnty;
    }

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

    public Integer getOrderUnit()
    {
        return itemOrderUnit;
    }

    public void setCurStock(Float stk) {curStock= stk;}
    public Float getCurStock(){return curStock;}

}

