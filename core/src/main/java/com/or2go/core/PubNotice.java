package com.or2go.core;

public class PubNotice {
    public Integer noticeID;
    public String title, notice, image;
    public Integer targetloctype, frequencytype;
    public String targetloc, timeperiod, publish, end, status;

    public PubNotice(Integer noticeID, String title, String notice, String image, Integer targetloctype, Integer frequencytype, String targetloc, String timeperiod, String publish, String end, String status) {
        this.noticeID = noticeID;
        this.title = title;
        this.notice = notice;
        this.image = image;
        this.targetloctype = targetloctype;
        this.frequencytype = frequencytype;
        this.targetloc = targetloc;
        this.timeperiod = timeperiod;
        this.publish = publish;
        this.end = end;
        this.status = status;
    }

    public Integer getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(Integer noticeID) {
        this.noticeID = noticeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTargetloctype() {
        return targetloctype;
    }

    public void setTargetloctype(Integer targetloctype) {
        this.targetloctype = targetloctype;
    }

    public Integer getFrequencytype() {
        return frequencytype;
    }

    public void setFrequencytype(Integer frequencytype) {
        this.frequencytype = frequencytype;
    }

    public String getTargetloc() {
        return targetloc;
    }

    public void setTargetloc(String targetloc) {
        this.targetloc = targetloc;
    }

    public String getTimeperiod() {
        return timeperiod;
    }

    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
