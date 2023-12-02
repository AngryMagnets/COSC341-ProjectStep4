package com.example.projectstep4;

import java.util.HashMap;
import java.util.Map;

public class ListingProfile extends Profile
{
    String location, postalCode;
    double[] coordinates;
    HashMap<String, Integer> petsAllowed;
    String[] disabilityAccommodations;
    int peopleAllowed, proximityToBus;
    boolean childrenAllowed
          , smokingAllowed
          , willHelpMoveItems;

    public ListingProfile (int id, String fn, String ln, String l, String pCode, double[] c, String[] petTypes, Integer[] petNums, String[] disability, int people, int busProx, boolean ca, boolean sa, boolean whm)
    {
        super (id, fn, ln);
        location = l; postalCode = pCode;
        coordinates = c;

        petsAllowed = new HashMap<>();
        for (int i = 0; i < petTypes.length; i++)
        {
            petsAllowed.put(petTypes[i],petNums[i]);
        }
        disabilityAccommodations = disability;
        peopleAllowed = people;
        childrenAllowed = ca;
    }

    public HashMap<String, Integer> getPetsAllowed ()
    {
        return petsAllowed;
    }

    public String[] getDisabilityAccommodations ()
    {
        return disabilityAccommodations;
    }

    public int getPeopleAllowed ()
    {
        return peopleAllowed;
    }

    public int getProximityToBus ()
    {
        return proximityToBus;
    }

    public boolean isChildrenAllowed ()
    {
        return childrenAllowed;
    }

    public boolean isSmokingAllowed ()
    {
        return smokingAllowed;
    }

    public boolean isWillHelpMoveItems ()
    {
        return willHelpMoveItems;
    }
}
