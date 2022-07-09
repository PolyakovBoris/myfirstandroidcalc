package com.example.myfirstandroidcalc;

import android.content.SharedPreferences;

public class SaveValuesHelper
{
    public static final String KEY_FIRST_OPERAND="first_operand";
    public static final String KEY_SECOND_OPERAND="second_operand";
    public static final String KEY_RESULT="result";
    private final SharedPreferences sharePreferences;


    public SaveValuesHelper(SharedPreferences sharePreferences) {
        this.sharePreferences = sharePreferences;
    }
    public void saveValues(Values values)
    {
        sharePreferences.edit().
            putString(KEY_FIRST_OPERAND,values.getFirstOperation()).
            putString(KEY_SECOND_OPERAND,values.getSecondOperation()).
                putString(KEY_RESULT,values.getResult()).
                commit();

    }
    public Values readValues()
    {
        Values values = new Values();
        values.setFirstOperation(sharePreferences.getString(KEY_FIRST_OPERAND,""));
        values.setSecondOperation(sharePreferences.getString(KEY_SECOND_OPERAND,""));
        values.setResult(sharePreferences.getString((KEY_RESULT),""));
        return values;
    }
}
