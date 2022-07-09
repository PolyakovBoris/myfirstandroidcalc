package com.example.myfirstandroidcalc;

public class Values
{
    private String firstOperation="";
    private String secondOperation="";
    private String result;
    public boolean equalsToValues(Values values)
    {
        return firstOperation.equals(values.firstOperation)&&
                secondOperation.equals(values.secondOperation)&&
                result.equals(values.getResult());
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFirstOperation() {
        return firstOperation;
    }

    public String getSecondOperation() {
        return secondOperation;
    }

    public void setFirstOperation(String firstOperation) {
        this.firstOperation = firstOperation;
    }

    public void setSecondOperation(String secondOperation) {
        this.secondOperation = secondOperation;
    }

}
