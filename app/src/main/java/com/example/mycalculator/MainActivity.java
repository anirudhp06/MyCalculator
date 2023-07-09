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
                if(opr1.getText().length()>0 && opr2.getText().length()>0){
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1+oper2;
                    txtresult.setText(Double.toString(result));
                }
                else{
                    Toast toast= Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(opr1.getText().length()>0 && opr2.getText().length()>0){
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1-oper2;
                    txtresult.setText(Double.toString(result));
                }
                else{
                    Toast toast= Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(opr1.getText().length()>0 && opr2.getText().length()>0){
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1*oper2;
                    txtresult.setText(Double.toString(result));
                }
                else{
                    Toast toast= Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(opr1.getText().length()>0 && opr2.getText().length()>0){
                    double oper1=Double.parseDouble(opr1.getText().toString());
                    double oper2=Double.parseDouble(opr2.getText().toString());
                    double result=oper1/oper2;
                    txtresult.setText(Double.toString(result));
                    Log.w("Div","Done with Division of "+Double.toString(oper1)+","+Double.toString(oper2));
                }
                else{
                    Toast toast= Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_LONG);
                    toast.show();
                }
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