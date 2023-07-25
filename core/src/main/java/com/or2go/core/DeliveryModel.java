package com.or2go.core;

public class DeliveryModel {
    public Integer mId;
    public Integer mType;
    public String  mName;
    public String  mState;
    public String  mPlace;
    public String  mParams;

    public DeliveryModel(Integer id, Integer type, String name, String state, String place, String param)
    {
        mId = id;
        mType = type;
        mName = name;
        mState = state;
        mPlace = place;
        mParams = param;
    }
}