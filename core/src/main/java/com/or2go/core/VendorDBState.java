package com.or2go.core;

public class VendorDBState {
    public static final int OR2GO_VENDOR_DBSTATUS_NONE=0;
    public static final int OR2GO_VENDOR_DBSTATUS_REQ_UPDATE=1;
    public static final int OR2GO_VENDOR_DBSTATUS_UPDATED=2;

    public static final int OR2GO_VENDOR_DB_DOWNLOAD_NONE=0;
    public static final int OR2GO_VENDOR_DB_DOWNLOAD_REQ=1;
    public static final int OR2GO_VENDOR_DB_DOWNLOAD_DONE=2;
    public static final int OR2GO_VENDOR_DB_DOWNLOAD_ERROR=3;

    private Integer mInfoVer;
    private Integer mProductVer;
    private Integer mPriceVer;

    private Integer mInfoVerReq;
    private Integer mProductVerReq;
    private Integer mPriceVerReq;

    private Integer mInfoStatus;
    private Integer mProductStatus;
    private Integer mPriceStatus;

    private Integer mInfoDownloadState;
    private Integer mProductDownloadState;
    private Integer mPriceDownloadState;

    public VendorDBState()
    {
        mInfoVer=mPriceVer=mProductVer=0;
        mInfoVerReq=mPriceVerReq=mProductVerReq=0;
        mInfoStatus=mProductStatus=mPriceStatus=OR2GO_VENDOR_DBSTATUS_NONE;
        mInfoDownloadState=mProductDownloadState=mPriceDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_NONE;

    }

    public VendorDBState(int infover, int prodver, int pricever)
    {
        mInfoVer=infover;
        mPriceVer=pricever;
        mProductVer=prodver;

        mInfoVerReq=mPriceVerReq=mProductVerReq=0;

        mInfoStatus=mProductStatus=mPriceStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        mInfoDownloadState=mProductDownloadState=mPriceDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_NONE;

    }

    public boolean updateState(int infover, int prodver, int pricever)
    {
//        Log.i("Vendor DB State","Info  cur="+mInfoVer + "server ver=" +infover);
        if (mInfoVer < infover)
        {
            mInfoVerReq=infover;
            mInfoStatus=OR2GO_VENDOR_DBSTATUS_REQ_UPDATE;
        }
        else
        {
            mInfoVerReq=-1;
            mInfoStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        }

//        Log.i("Vendor DB State","Product  cur="+mProductVer + "server ver=" +prodver);
        if (mProductVer < prodver)
        {
            mProductVerReq=prodver;
            mProductStatus=OR2GO_VENDOR_DBSTATUS_REQ_UPDATE;
        }
        else
        {
            mProductVerReq=-1;
            mProductStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        }

//        Log.i("Vendor DB State","Price  cur="+mPriceVer + "server ver=" +pricever);
        if (mPriceVer < pricever)
        {
            mPriceVerReq=pricever;
            mPriceStatus=OR2GO_VENDOR_DBSTATUS_REQ_UPDATE;
        }
        else
        {
            mPriceVerReq=-1;
            mPriceStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        }

        return true;
    }

    public boolean setDBStates(int infost, int prodst, int pricest)
    {
        mInfoStatus=infost;
        mProductStatus=prodst;
        mPriceStatus=pricest;

        return true;
    }


    public void setInfoState(int st) { mInfoStatus=st;}
    public void setProductState(int st) { mProductStatus=st;}
    public void setPriceState(int st) { mPriceStatus=st;}
    public void setInfoDownloadState(int st) { mInfoDownloadState=st;}
    public void setProductDownloadState(int st) { mProductDownloadState=st;}
    public void setPriceDownloadState(int st) { mPriceDownloadState=st;}

    public Integer getInfoState(){return mInfoStatus;}
    public Integer getProductState(){return mProductStatus;}
    public Integer getPriceState(){return mPriceStatus;}
    public Integer getInfoDownloadState(){return mInfoDownloadState;}
    public Integer getProductDownloadState(){return mProductDownloadState;}
    public Integer getPriceDownloadState(){return mPriceDownloadState;}

    public void setInfoVersion(int st) { mInfoVer=st;}
    public void setProductVersion(int st) { mProductVer=st;}
    public void setPriceVersion(int st) { mPriceVer=st;}
    public Integer getInfoVer(){return mInfoVer;}
    public Integer getProductVer(){return mProductVer;}
    public Integer getPriceVer(){return mPriceVer;}

    public boolean isProductUpdated() {
        if (mProductStatus==OR2GO_VENDOR_DBSTATUS_UPDATED)
            return true;
        else
            return false;
    }

    public boolean isPriceUpdated() {
        if (mPriceStatus==OR2GO_VENDOR_DBSTATUS_UPDATED)
            return true;
        else
            return false;
    }

    public boolean isProductDownloadError() {
        if (mProductDownloadState==OR2GO_VENDOR_DB_DOWNLOAD_ERROR)
            return true;
        else
            return false;
    }

    public boolean isPriceDownloadError() {
        if (mPriceDownloadState==OR2GO_VENDOR_DB_DOWNLOAD_ERROR)
            return true;
        else
            return false;
    }

    public void setProductDownloadDone() { mProductDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_DONE;}
    public void setProductDownloadError() { mProductDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_ERROR;}
    public void setPriceDownloadDone() { mPriceDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_DONE;}
    public void setPriceDownloadError() { mPriceDownloadState=OR2GO_VENDOR_DB_DOWNLOAD_ERROR;}

    public boolean reqInfoDBDownload()
    {
        if ((mInfoStatus==OR2GO_VENDOR_DBSTATUS_NONE) || (mInfoStatus==OR2GO_VENDOR_DBSTATUS_REQ_UPDATE))
            return true;
        else
            return false;
    }

    public boolean reqProductDBDownload()
    {
        System.out.println("reqProductDBDownload : Product DB version="+mProductVer+"  DB status="+mProductStatus+ " Req Version="+mProductVerReq);
        if ((mProductStatus==OR2GO_VENDOR_DBSTATUS_NONE) || (mProductStatus==OR2GO_VENDOR_DBSTATUS_REQ_UPDATE))
            return true;
        else
            return false;
    }

    public boolean reqPriceDBDownload()
    {
        System.out.println("Price DB version="+mPriceVer+"  DB status="+mPriceStatus+ " Req Version="+mPriceVerReq);
        if ((mPriceStatus==OR2GO_VENDOR_DBSTATUS_NONE) || (mPriceStatus==OR2GO_VENDOR_DBSTATUS_REQ_UPDATE))
            return true;
        else
            return false;
    }

    //
    public synchronized boolean doneProductDBUpdate()
    {
        mProductVer = mProductVerReq;
        mProductStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        System.out.println("doneProductDBUpdate : Updated product DB version="+mProductVer);
        return true;
    }

    public synchronized boolean doneInfoDBUpdate()
    {
        mInfoVer = mInfoVerReq;
        mInfoStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;

        return true;
    }

    public synchronized boolean donePriceDBUpdate()
    {
        mPriceVer = mPriceVerReq;
        mPriceStatus=OR2GO_VENDOR_DBSTATUS_UPDATED;
        System.out.println("doneProductDBUpdate : Updated price DB version="+mPriceVer);
        return true;
    }
}
