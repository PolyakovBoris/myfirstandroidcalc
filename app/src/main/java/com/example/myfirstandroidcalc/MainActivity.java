package com.example.myfirstandroidcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.OperationCanceledException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Optional;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText first,second;
    public Button add,sub,mult,div;
    public TextView result;
    public Calculator calculator;
    private double a,b;
    private SaveValuesHelper saveValuesHelper;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);
        calculator = new Calculator();
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("save",0);
        saveValuesHelper=new SaveValuesHelper((sharedPreferences));
        Values values=saveValuesHelper.readValues();
     //   first.setText(values.getFirstOperation());
     //   second.setText(values.getSecondOperation());
     //   result.setText((values.getResult()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.add:
                Operation();
                result.setText(Double.toString(calculator.Add(a,b)));
                break;
            case R.id.sub:
                Operation();
                result.setText(Double.toString(calculator.Sub(a,b)));
                break;
            case R.id.mult:
                Operation();
                result.setText(Double.toString(calculator.Mult(a,b)));
                break;
            case R.id.div:
                Operation();
                result.setText(Double.toString(calculator.Div(a,b)));
                break;
        }
    }
    private void Operation()
    {
        try
        {
            if (first.getText().toString().length()==0) a=0;
            else a = Double.parseDouble(first.getText().toString());
            if (second.getText().toString().length()==0) b=0;
            else b = Double.parseDouble(second.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Values values=new Values();
        values.setFirstOperation((first.getText().toString()));
        values.setSecondOperation(second.getText().toString());
        values.setResult(result.getText().toString());
        saveValuesHelper.saveValues(values);

    }
}