package com.or2go.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SPInfo {
    public String spname;
    public String propname;
    public String contact;
    public  String  altcontact;
    public  String  email;
    public  String  address;
    public  String  place;
    public  String  state;
    public  String  zipcode;
    public  String  status;
    public  String  logopath;
    public  String  closestatus;
    public  String  closedfrom;
    public  String  closedtill;
    public  String  closedreason;
    public  String  closedon;
    public  Integer  dbversion;

    ArrayList<String> vClosedDates;
    ArrayList<String> vClosedDays;

    public SPInfo(String name, String oname, String cont, String altcont, String mail, String addr, String loc, String st, String pin, String sts,
                  String logo, String closests, String closefrm, String closeto, String reason, String close, int dbver)
    {
        this.spname = name;
        this.propname = oname;
        this.contact = cont;
        this.altcontact=altcont;
        this.email = mail;
        this.address = addr;
        this.place = loc;
        this.state = st;
        this.zipcode = pin;
        this.status = sts;
        this.logopath = logo;
        this.closestatus = closests;
        this.closedfrom = closefrm;
        this.closedtill = closeto;
        this.closedreason = reason;
        this.closedon = close;
        this.dbversion = dbver;

        if ((addr == null) || (addr.equals("null")))
            address="";

        if ((close == null) || (close.equals("null")))
            closedon="";

        if ((closedfrom == null) || (closedfrom.equals("null")))
            closedfrom="";

        if ((closedtill == null) || (closedtill.equals("null")))
            closedtill="";

        vClosedDates = new ArrayList<String>();
        vClosedDays = new ArrayList<String>();

        if ((closedon!= null) && (!closedon.isEmpty())) {
            processClosingInfo();
        }
    }
    public boolean setShutdownInfo(String from, String till, String cause)
    {
        closedfrom = from;
        closedtill = till;
        closedreason = cause;
        return true;
    }

    public boolean clearShutdownInfo()
    {
        closedfrom = "";
        closedtill = "";
        closedreason = "";
        return true;
    }

    public void processClosingInfo()
    {
        if (closedon.isEmpty()) return;
        String closed[] = closedon.split(",");
        int dn = closed.length;
        for(int i=0; i< dn;i++)
        {
            String clarr[] = closed[i].split(":");
            if (clarr[0].equals("DATE"))
            {
                vClosedDates.add(clarr[1]);
            }
            else if (clarr[0].equals("DOW"))
            {
                vClosedDays.add(clarr[1]);
            }
        }
    }

    public boolean isClosedToday()
    {
        if (isShutdownNow()) return true;
        if (vClosedDates.size() > 0)
        {
            int clsdtcnt = vClosedDates.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

            for(int i=0;i< clsdtcnt; i++)
            {
                String cldate = vClosedDates.get(i);
                Date enteredDate=null;
                try
                {
                    enteredDate = sdf.parse(cldate);
                }catch (Exception ex)
                {
                    // enteredDate will be null if date="287686";
                }
                Date currentDate = new Date();

                if (fmt.format(enteredDate).equals(fmt.format(currentDate))){

                    return true;
                }//else
            }
        }

        if (vClosedDays.size() > 0)
        {
            int clsdtcnt = vClosedDays.size();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat sdfdow = new SimpleDateFormat("EEE");

            for(int i=0;i< clsdtcnt; i++)
            {
                Date d = new Date();
                String today = sdfdow.format(d);
                String cldow = vClosedDays.get(i);

                if (today.equals(cldow))
                {
                    return true;
                }//else
            }
        }
        return false;
    }


    public String getClosedDays()
    {
        String closeinfo="";
        if (vClosedDates.size() > 0)
        {
            int clsdtcnt = vClosedDates.size();

            for(int i=0;i< clsdtcnt; i++)
            {
                String cldate = vClosedDates.get(i);
                closeinfo += cldate;
                if ((clsdtcnt -i) > 1) closeinfo +=" , ";
            }
        }

        if (vClosedDays.size() > 0)
        {
            int clsdtcnt = vClosedDays.size();
            closeinfo +=" , ";
            for(int i=0;i< clsdtcnt; i++)
            {
                String cldate = vClosedDays.get(i);
                closeinfo += cldate+"days";
                if ((clsdtcnt -i) > 1) closeinfo +=" , ";
            }
        }
        return closeinfo;
    }


    private boolean isShutdownNow()
    {
        //JAVA 8
        //LocalDateTime now = LocalDateTime.now();
        //LocalDateTime limit = LocalDateTime.parse( closedfrom );
        //Boolean isLate = now.isAfter( limit );

        ///System.out.println("SHUTDOWN FROM :"+closedfrom);
        //System.out.println("SHUTDOWN TILL :"+closedtill);
        if (closedfrom.isEmpty()) return false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date closedFrom = sdf.parse(closedfrom);
            Date closedTill = sdf.parse(closedtill);

            Date currentDate = new Date();

            //if ((currentDate.after(closedFrom)) && (currentDate.before(closedTill)))
            if ((currentDate.after(closedFrom)))
            {
                return true;
            }
        }catch (Exception ex)
        {
            return false;
            // enteredDate will be null if date="287686";
        }
        return false;
    }

    public void dumpSPInfo()
    {
        System.out.println("-----SP Info-----");
        System.out.println("Name"+spname);
        System.out.println("Shutdown FROM :"+closedfrom);
        System.out.println("Shutdown TILL :"+closedtill);
        System.out.println("Closed On :"+closedon);
        System.out.println("Closed Reason :"+closedreason);
        System.out.println("DB Version :"+dbversion);
        System.out.println("-----SP Info-----");
    }
}
