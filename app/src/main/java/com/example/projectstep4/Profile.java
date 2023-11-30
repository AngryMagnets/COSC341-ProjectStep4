package com.example.projectstep4;

import java.util.Map;

public class Profile
{
    private String fName, lName;
    public Profile (String fn, String ln)
    {
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
