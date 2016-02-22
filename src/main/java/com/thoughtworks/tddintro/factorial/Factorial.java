package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i)
    {   int factorialNum = 1;
        if(i < 0){
            throw new IllegalArgumentException("Try a positive value...");
        }
        else if(i > 0){
            for(int j=1;j<=i;j++) {
                factorialNum *= j;
            }
        }
        return factorialNum;
    }
}
