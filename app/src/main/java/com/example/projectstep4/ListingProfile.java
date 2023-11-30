package com.example.projectstep4;

import java.util.HashMap;
import java.util.Map;

public class ListingProfile extends Profile
{
    HashMap<String, Integer> petsAllowed;
    String[] disabilityAccommodations;
    int peopleAllowed, proximityToBus;
    boolean childrenAllowed
          , smokingAllowed
          , willHelpMoveItems;

    public ListingProfile (int id, String fn, String ln, String[] petTypes, Integer[] petNums, String[] disability, int people, int busProx, boolean ca, boolean sa, boolean whm)
    {
        super (id, fn, ln);
        petsAllowed = new HashMap<>();
        for (int i = 0; i < petTypes.length; i++)
        {
            petsAllowed.put(petTypes[i],petNums[i]);
        }
        disabilityAccommodations = disability;
        peopleAllowed = people;
        childrenAllowed = ca;
    }
}
