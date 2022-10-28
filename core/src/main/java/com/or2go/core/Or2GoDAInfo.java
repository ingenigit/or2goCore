package com.or2go.core;

public class Or2GoDAInfo {
    public String daId;
    public String daName;
    public String daContact;
    public boolean daActive;
    public String daAddress;
    public String daPin;
    public String daLocation;

    public Or2GoDAInfo(String id, String name, String contact, String address, String pin)
    {
        daId=id;
        daName= name;
        daContact=contact;
        daAddress=address;
        daPin=pin;
    }

    public boolean setActiveStatus(boolean sts)
    {
        daActive = sts;
        return true;
    }

    public boolean getActiveStatus() { return daActive;}

    public boolean setLocation(String loc) { daLocation=loc; return true;}
    public String getLocation() {return daLocation;}

}
