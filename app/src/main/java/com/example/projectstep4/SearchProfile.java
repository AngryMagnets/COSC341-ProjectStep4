package com.example.projectstep4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchProfile extends Profile
{
    HashMap<String, Integer> petsInGroup;
    String[] disabilityAccommodations;
    int peopleInGroup, childrenInGroup, desiredProximityToBus;
    boolean smokingInGroup
          , needHelpMovingItems;


    public SearchProfile (int id, String fn, String ln, String[] petTypes, Integer[] petNums, String[] disability, int people, int children, int busProx,  boolean sa, boolean nhm)
    {
        super (id, fn, ln);
        petsInGroup = new HashMap<>();
        for (int i = 0; i < petTypes.length; i++)
        {
            petsInGroup.put(petTypes[i],petNums[i]);
        }
        disabilityAccommodations = disability;
        peopleInGroup = people;
        childrenInGroup = children;
        desiredProximityToBus = busProx;
        smokingInGroup = sa;
        needHelpMovingItems = nhm;
    }

    public HashMap<String, Integer> getPetsInGroup ()
    {
        return petsInGroup;
    }

    public String[] getDisabilityAccommodations ()
    {
        return disabilityAccommodations;
    }

    public int getPeopleInGroup ()
    {
        return peopleInGroup;
    }

    public int getChildrenInGroup ()
    {
        return childrenInGroup;
    }

    public int getDesiredProximityToBus ()
    {
        return desiredProximityToBus;
    }

    public boolean isSmokingInGroup ()
    {
        return smokingInGroup;
    }

    public boolean isNeedHelpMovingItems ()
    {
        return needHelpMovingItems;
    }
}
