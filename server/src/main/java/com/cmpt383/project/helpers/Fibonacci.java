package com.cmpt383.project.helpers;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci{

    private int requestVal;
    private List<Integer> fibList = new ArrayList<>();

    public Fibonacci(int requestVal){
        this.requestVal = requestVal;
    }

    public int fibonacciVal(int val){

        //initial var declarations
        int f1 = 0;
        int f2 = 1;
        int res;

        if(val == 0)
            return f1;

        for(int i = 2; i <=val; i++){
            res = f1+f2;
            f1 = f2;
            f2 = res;
        }

        return f2;
    }

    public List<Integer> fibCollection(){

        for(int i = 0; i<=this.requestVal; i++){
            this.fibList.add(fibonacciVal(i));
        }
        return this.fibList;
    }

}