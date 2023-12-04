package com.example.projectstep4;

import java.io.Serializable;
import java.util.Map;

public class Profile implements Serializable
{
    private int pID;
    private String fName, lName;
    public Profile (int id, String fn, String ln)
    {
        pID = id;
        fName = fn; lName = ln;
    }
    public int getpID () { return pID; }
    public String getfName ()
    {
        return fName;
    }
    public String getlName ()
    {
        return lName;
    }
}
