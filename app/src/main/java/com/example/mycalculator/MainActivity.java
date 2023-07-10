package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText opr1,opr2;
    private Button btnadd,btnsub,btndiv,btnmul,clear;
    private TextView txtresult;


    public void cal(EditText opr1,EditText opr2,String ops) {
        Double oper1,oper2;
        try {
            oper1 = Double.parseDouble(opr1.getText().toString());
            oper2 = Double.parseDouble(opr2.getText().toString());
        }
        catch (NumberFormatException n){
            /*
            * App eventually crashes without try-catch or dosen't respond to anything as Double can't parse empty values.
            * Need to use try-catch block because if user passes no values, displaying toast is not possible
            * setting 2 operators to some default value to detect if user hasn't passed any values.
            * */
            oper1=-5555555.00;
            oper2=-5555555.00;
        }
        Double result;
        if(oper1!=-5555555.00 && oper2!=-5555555.00){
            switch (ops) {
                case "+":
                    result = oper1 + oper2;
                    txtresult.setText(Double.toString(result));
                    break;
                case "-":
                    result = oper1 - oper2;
                    txtresult.setText(Double.toString(result));
                case "*":
                    result = oper1 * oper2;
                    txtresult.setText(Double.toString(result));
                case "/":
                    result = oper1 / oper2;
                    txtresult.setText(Double.toString(result));
            }
        }
        else{
            Toast toast=Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG);
            toast.show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opr1=(EditText) findViewById(R.id.Field1);
        opr2=(EditText) findViewById(R.id.Field2);
        btnadd=(Button) findViewById(R.id.Add);
        btnsub=(Button) findViewById(R.id.Sub);
        btnmul=(Button) findViewById(R.id.Mul);
        btndiv=(Button) findViewById(R.id.Div);
        txtresult=(TextView) findViewById(R.id.Result);
        clear=(Button) findViewById(R.id.Cls);

        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cal(opr1,opr2,"+");
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cal(opr1,opr2,"-");
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cal(opr1,opr2,"*");
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cal(opr1,opr2,"/");
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                opr1.setText("");
                opr2.setText("");
                txtresult.setText("0.00");
                opr1.requestFocus();
            }
        });
    }
}