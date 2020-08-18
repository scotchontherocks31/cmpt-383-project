package com.cmpt383.project.helpers;

import java.util.ArrayList;
import java.util.List;

public class Hailstone {
    
    private int requestVal;
    private List<Integer> hailList = new ArrayList<>();

    public Hailstone(int requestVal){
        this.requestVal = requestVal;
    }

    public int hailstoneVal(int val){
        if(val%2 == 0)
            return val/2;
        else
            return 3*val+1;
    }

    public List<Integer> hailCollection(){

        //intial hailstone entry
        int hail = hailstoneVal(this.requestVal);
        this.hailList.add(hail);

        while(hail != 1){
            hail = hailstoneVal(hail);
            this.hailList.add(hail);
        }

        return this.hailList;
    }
}