package com.example.myfirstandroidcalc;

public class Calculator
{
    public double Add(double x,double y)
    {
        return x+y;
    }
    public double Sub(double x,double y)
    {
        return x-y;
    }
    public double Mult(double x,double y)
    {
        return x*y;
    }
    public double Div(double x,double y)
    {
        if(y==0) return 1;
        return x/y;
    }
}
