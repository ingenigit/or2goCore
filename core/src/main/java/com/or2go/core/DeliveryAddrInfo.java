package com.or2go.core;

public class DeliveryAddrInfo {
    public String nickname;
    public String addr;
    public String place;
    public String locality;
    public String sublocality;
    public String landmark;
    public String zipcode;
    public String latest;
    public String altcontact;
    public String geoposition;

    public DeliveryAddrInfo(String name, String adr, String plc, String loc, String subloc, String mark, String pin, String altaddr)
    {
        nickname= name;
        addr=adr;
        place=plc;
        locality = loc;
        sublocality = subloc;
        landmark=mark;
        zipcode=pin;
        altcontact=altaddr;
        latest="";
    }

    public void updateAddressInfo(String name, String adr, String plc, String loc, String subloc, String mark, String pin, String altaddr)
    {
        nickname= name;
        addr=adr;
        place=plc;
        locality = loc;
        sublocality = subloc;
        landmark=mark;
        zipcode=pin;
        altcontact=altaddr;
    }

    public String getAddrName() { return nickname;}
    public String getAddress() { return addr;}
    public String getLandmark() { return landmark;}
    public String getPlace() { return place;}
    public String getLocality() { return locality;}
    public String getSublocality() { return sublocality;}
    public String getZipCode(){return zipcode;}
    public String getAltcontact() {return altcontact;}

    public String getCompleteAddress()
    {
        return (addr+"Place-"+place+" Locality-"+locality+" Landmark-"+landmark+" PIN-"+zipcode+" Contact-"+altcontact);
    }

    public void setGeoPosition(String geocode) { geoposition = geocode;}
    public String getGeoposition() { return geoposition;}
}
