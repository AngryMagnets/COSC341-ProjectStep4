package com.example.projectstep4;

import java.util.Map;

public class Profile
{
    private int pID;
    private String fName, lName;
    public Profile (int id, String fn, String ln)
    {
        pID = id;
        fName = fn; lName = ln;
    }
    public String getfName ()
    {
        return fName;
    }

    public String getlName ()
    {
        return lName;
    }
}
