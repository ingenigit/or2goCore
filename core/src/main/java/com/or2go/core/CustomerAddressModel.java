package com.or2go.core;

public class CustomerAddressModel {
    public int placeId;
    public String placeName, placeAddress;

    public CustomerAddressModel(int placeId, String placeName, String placeAddress) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
    }

    @Override
    public String toString() {
        return "{" +
                placeName +
                "," +
                placeAddress +
                '}';
    }
}
