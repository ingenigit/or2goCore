package com.or2go.core;

public class StoreDBState {
    public static final int OR2GO_DBSTATUS_NONE=0;
    public static final int OR2GO_DBSTATUS_REQUIRE_UPDATE=1;
    public static final int OR2GO_DBSTATUS_DOWNLOAD_REQ=2;
    public static final int OR2GO_DBSTATUS_DOWNLOAD_DONE=3;
    public static final int OR2GO_DBSTATUS_DOWNLOAD_ERROR=4;
    public static final int OR2GO_DBSTATUS_UPDATED=5;

    /*public static final int OR2GO_DB_DOWNLOAD_NONE=0;
    public static final int OR2GO_DB_DOWNLOAD_REQ=1;
    public static final int OR2GO_DB_DOWNLOAD_DONE=2;
    public static final int OR2GO_DB_DOWNLOAD_ERROR=3;*/

    private Integer mCurrentVer;
    private Integer mRequiredVer;
    private Integer mStatus;
    //private Integer mDownloadState;

    public StoreDBState()
    {
        mCurrentVer=0;
        mRequiredVer=-1;
        mStatus=OR2GO_DBSTATUS_NONE;
        //mDownloadState=OR2GO_DB_DOWNLOAD_NONE;
    }

    public StoreDBState(int ver)
    {
        mCurrentVer=ver;
        mRequiredVer=-1;
        mStatus=OR2GO_DBSTATUS_UPDATED;
        //mDownloadState=OR2GO_DB_DOWNLOAD_NONE;
    }

    public synchronized boolean updateVersion(int newver) {
        System.out.println("Store DB State cur=" + mCurrentVer + "New ver=" + newver);
        if (mCurrentVer < newver) {
            mRequiredVer = newver;
            mStatus = OR2GO_DBSTATUS_REQUIRE_UPDATE;
        } else {
            mRequiredVer = -1;
            mStatus = OR2GO_DBSTATUS_UPDATED;
        }
        return true;
    }

    /*public boolean setState(int status)
    {
        mStatus=status;

        return true;
    }*/

    public synchronized void setState(int st) { mStatus=st;}
    //public void setDownloadState(int st) { mDownloadState=st;}
    public Integer getState(){return mStatus;}
    //public Integer getDownloadState(){return mDownloadState;}
    public synchronized void setVersion(int st) { mCurrentVer=st;}
    public Integer getVer(){return mCurrentVer;}
    public Integer getRequiredVer(){return mRequiredVer;}

    public boolean isUpdated() {
        if (mStatus==OR2GO_DBSTATUS_UPDATED)
            return true;
        else
            return false;
    }

    public boolean isDownloadError() {
        if (mStatus==OR2GO_DBSTATUS_DOWNLOAD_ERROR)
            return true;
        else
            return false;
    }

    //public void setDownloadDone() { mDownloadState=OR2GO_DB_DOWNLOAD_DONE;}
    //public void setDownloadError() { mDownloadState=OR2GO_DB_DOWNLOAD_ERROR;}

    public boolean isRequiredDBDownload()
    {
        if ((mStatus==OR2GO_DBSTATUS_NONE) || (mStatus==OR2GO_DBSTATUS_REQUIRE_UPDATE)|| (mStatus==OR2GO_DBSTATUS_DOWNLOAD_ERROR))
            return true;
        else
            return false;
    }

    public synchronized boolean doneDBUpdate()
    {
        if (mCurrentVer < mRequiredVer) mCurrentVer = mRequiredVer;
        mStatus=OR2GO_DBSTATUS_UPDATED;
        mRequiredVer=-1;
        System.out.println("doneProductDBUpdate : Updated product DB version="+mCurrentVer);
        return true;
    }
}
