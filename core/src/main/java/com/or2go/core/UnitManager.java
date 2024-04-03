package com.or2go.core;

import java.util.HashMap;
public class UnitManager {
    //product unit type
//    public static final int GPOS_PROD_UNIT_WHOLE = 1;
//    public static final int GPOS_PROD_UNIT_WEIGHT = 2;
//    public static final int GPOS_PROD_UNIT_VOLUME = 3;
//    public static final int GPOS_PROD_UNIT_LENGTH = 4;
//    public static final int GPOS_PROD_UNIT_PC = 1;
//    public static final int GPOS_PROD_UNIT_KG = 10;
//    public static final int GPOS_PROD_UNIT_G = 11;
//    //public static final int GPOS_PROD_UNIT_KG = 12;
//    public static final int GPOS_PROD_UNIT_L = 20;
//    public static final int GPOS_PROD_UNIT_ML = 21;
//    public static final int GPOS_PROD_UNIT_M = 30;
//    public static final int GPOS_PROD_UNIT_CM = 31;
//    public static final int GPOS_PROD_UNIT_MM = 32;
//    public static final int GPOS_PROD_UNIT_PLT = 40;
//    public static final int GPOS_PROD_UNIT_PEG = 50;

    public static final int OR2GO_Unit_Value_PC=1;
    public static final int OR2GO_Unit_Value_Package=2;
    public static final int OR2GO_Unit_Value_KG=10;
    public static final int OR2GO_Unit_Value_G=11;
    public static final int OR2GO_Unit_Value_L=20;
    public static final int OR2GO_Unit_Value_ML=21;
    public static final int OR2GO_Unit_Value_M=30;
    public static final int OR2GO_Unit_Value_CM=31;
    public static final int OR2GO_Unit_Value_MM=32;
    public static final int OR2GO_Unit_Value_Plt=40;
    public static final int OR2GO_Unit_Value_HPlate=41;
    public static final int OR2GO_Unit_Value_FPlate=42;
    public static final int OR2GO_Unit_Value_PEG=50;
    public static final int OR2GO_Unit_Value_PEG_S=51;
    public static final int OR2GO_Unit_Value_PEG_M=52;
    public static final int OR2GO_Unit_Value_PEG_L=53;


    public String getUnitName(int unit){
        return mapStatusDescription.get(unit);
    }

    HashMap<Integer, String> mapStatusDescription = new HashMap<Integer, String>() {{
        put(OR2GO_Unit_Value_PC, "piece");
        put(OR2GO_Unit_Value_Package, "packet");
        put(OR2GO_Unit_Value_KG, "kg");
        put(OR2GO_Unit_Value_G, "g");
        put(OR2GO_Unit_Value_L, "l");
        put(OR2GO_Unit_Value_ML, "ml");
        put(OR2GO_Unit_Value_M, "meter");
        put(OR2GO_Unit_Value_CM, "cm");
        put(OR2GO_Unit_Value_MM, "mm");
        put(OR2GO_Unit_Value_Plt, "plate");
        put(OR2GO_Unit_Value_HPlate, "half");
        put(OR2GO_Unit_Value_FPlate, "full");
        put(OR2GO_Unit_Value_PEG, "peg");
        put(OR2GO_Unit_Value_PEG_S, "peg small");
        put(OR2GO_Unit_Value_PEG_M, "peg medium");
        put(OR2GO_Unit_Value_PEG_L, "peg Large");
    }};
/*
    public int getUnitFromName(String unit)
    {
        int nunit=1;

        if (unit.equals("Pc"))
        {
            nunit = GPOS_PROD_UNIT_PC ;
        }
        else if (unit.equals("Kg"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_KG;
        }
        else if (unit.equals("G"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_G;
        }
        else if (unit.equals("L"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_L;
        }
        else if (unit.equals("Ml"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_ML;
        }
        else if (unit.equals("M"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_M;
        }
        else if (unit.equals("Cm"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_CM;
        }
        else if (unit.equals("Mm"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_MM;
        }
        else if (unit.equals("Plt"))
        {
            nunit = GPOS_PROD_UNIT_PLT;
        }
        else if (unit.equals("Peg"))
        {
            nunit = GPOS_PROD_UNIT_PEG;
        }

        return nunit;

    }

    public int getUnitFromSelection(String unit)
    {
        int nunit=1;

        if (unit.contains("Whole"))
        {
            nunit = GPOS_PROD_UNIT_PC ;
        }
        else if (unit.contains("Kilogram"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_KG;
        }
        else if (unit.contains("Gram"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_G;
        }
        else if (unit.contains("Litre"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_L;
        }
        else if (unit.contains("MiliLitre"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_ML;
        }
        else if (unit.equals("Meter"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_M;
        }
        else if (unit.equals("CentiMeter"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_CM;
        }
        else if (unit.equals("MiliMeter"))//((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            nunit = GPOS_PROD_UNIT_MM;
        }

        return nunit;

    }

    public String[] getCompatibleUnits(int unit)
    {
        switch (unit) {
            case GPOS_PROD_UNIT_PC:
                String[] pcunitslist = {"Pc"};
                return pcunitslist;
            case GPOS_PROD_UNIT_KG:
                String[] kgunitslist = {"Kg", "G", "Amount"};
                return kgunitslist;
            case GPOS_PROD_UNIT_G:
                String[] gunitslist = {"Kg", "G", "Amount"};
                return gunitslist;
            case GPOS_PROD_UNIT_L:
                String[] lunitslist = {"L", "Ml", "Amount"};
                return lunitslist;
            case GPOS_PROD_UNIT_ML:
                String[] mlunitslist = {"L", "Ml", "Amount"};
                return mlunitslist;
            case GPOS_PROD_UNIT_M:
                String[] munitslist = {"M", "Cm", "Amount"};
                return munitslist;
            case GPOS_PROD_UNIT_CM:
                String[] cmunitslist = {"M", "Cm", "Amount"};
                return cmunitslist;
        }

        return null;
    }

    public float getConvertedQnty(Float qnty, Integer fromunit, Integer tounit)
    {
        float convamnt = 0;

        if (fromunit.equals(tounit))
        {
            return qnty;
        }

        if ((fromunit == GPOS_PROD_UNIT_KG) && (tounit == GPOS_PROD_UNIT_G ))
        {
            convamnt = qnty * 1000 ;
        }
        else if ((fromunit == GPOS_PROD_UNIT_G) && (tounit== GPOS_PROD_UNIT_KG))
        {
            convamnt = qnty/1000 ;
        }
        if ((fromunit == GPOS_PROD_UNIT_L) && (tounit== GPOS_PROD_UNIT_ML))//(fromunit.equals("L") && tounit.equals("Ml"))
        {
            convamnt = (qnty *  1000);
        }
        else if ((fromunit == GPOS_PROD_UNIT_ML) && (tounit== GPOS_PROD_UNIT_L)) //fromunit.equals("Ml") && tounit.equals("L"))
        {
            convamnt = (qnty/1000) ;
        }
        if ((fromunit == GPOS_PROD_UNIT_M) && (tounit== GPOS_PROD_UNIT_MM))//fromunit.equals("M") && tounit.equals("Mm"))
        {
            convamnt = (qnty *  1000);
        }
        else if ((fromunit == GPOS_PROD_UNIT_MM) && (tounit== GPOS_PROD_UNIT_M))//(fromunit.equals("Mm") && tounit.equals("M"))
        {
            convamnt = (qnty/1000)  ;
        }

        return convamnt;
    }

 */
}
