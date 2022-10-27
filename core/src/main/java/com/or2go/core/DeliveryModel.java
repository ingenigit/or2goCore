package com.or2go.core;

public class DeliveryModel {
    public Integer mId;
    public Integer mType;
    public String  mName;
    public String  mParams;

    public DeliveryModel(Integer id, Integer type, String name, String param)
    {
        mId = id;
        mType = type;
        mName = name;
        mParams = param;
    }
}