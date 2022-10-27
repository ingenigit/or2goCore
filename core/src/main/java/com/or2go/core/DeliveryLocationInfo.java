package com.or2go.core;

public class DeliveryLocationInfo {
    public int locId;
    public String locName;
    public String locDescription;
    public String  stdRate;
    public String  spRate1;
    public String  spRate2;
    public String  spRate3;

    public DeliveryLocationInfo(int id, String name, String desc, String stdrate, String sprate1, String sprate2, String sprate3)
    {
        locId = id;
        locName =name;
        locDescription = desc;
        stdRate = stdrate;
        spRate1 = sprate1;
        spRate2 = sprate2;
        spRate3 = sprate3;
    }
}
