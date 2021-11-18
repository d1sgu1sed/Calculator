package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textBox1;
    TextView ResultBox;
    Button b_plus, b_minus, b_equal, b_del, b_multi;

    int fl_zn=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox1=findViewById(R.id.textBox);
        ResultBox=findViewById(R.id.res_box);
        b_del = findViewById(R.id.but_del);
        b_equal = findViewById(R.id.but_equal);
        b_minus = findViewById(R.id.but_minus);
        b_plus = findViewById(R.id.but_plus);
        b_multi = findViewById(R.id.but_multi);

        b_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textBox1.getText().toString(), s="1234567890",s1="+-/*";
                StringBuilder str1 = new StringBuilder("");
                String [] arstr = str.split("");
                if(fl_zn==5){
                    textBox1.append("*");
                    fl_zn=0;}
                else if(arstr[str.length()-1].equals("-") || arstr[str.length()-1].equals("+") ||
                        arstr[str.length()-1].equals("*")|| arstr[str.length()-1].equals("/")){
                    for (int i = 0; i < str.length()-1; i++) {
                        str1.append(arstr[i]);
                    }
                    str1.append("*");
                    textBox1.setText(str1);
                    EditText editText = (EditText)findViewById(R.id.textBox);
                    editText.setSelection(editText.getText().length());
                    fl_zn=0;

                }
                else if(s.contains(arstr[str.length()-1]) && !str.contains("+") && !str.contains("-")
                        && !str.contains("/") && !str.contains("*")){
                    str1.append("*");
                    textBox1.append(str1);
                    fl_zn=0;
                }
            }
        });

        b_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textBox1.getText().toString(), s="1234567890", s1="+-/*";
                StringBuilder str1 = new StringBuilder("");
                String [] arstr = str.split("");

                if(fl_zn==5) {
                    textBox1.append("/");
                    fl_zn = 1;
                }
                else if(arstr[str.length()-1].equals("-") || arstr[str.length()-1].equals("+") ||
                        arstr[str.length()-1].equals("*")|| arstr[str.length()-1].equals("/")){
                    for (int i = 0; i < str.length()-1; i++) {
                        str1.append(arstr[i]);
                    }
                    str1.append("/");
                    textBox1.setText(str1);
                    EditText editText = (EditText)findViewById(R.id.textBox);
                    editText.setSelection(editText.getText().length());
                    fl_zn=1;

                }
                else if(s.contains(arstr[str.length()-1]) && !str.contains("+") && !str.contains("-")
                        && !str.contains("/") && !str.contains("*")){
                    str1.append("/");
                    textBox1.append(str1);
                    fl_zn=1;
                }
            }
        });

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textBox1.getText().toString(), s="1234567890", s1="+-/*";
                StringBuilder str1 = new StringBuilder("");
                String [] arstr = str.split("");

                if(fl_zn==5) {
                    textBox1.append("+");
                    fl_zn = 2;
                }
                else if(arstr[str.length()-1].equals("-") || arstr[str.length()-1].equals("+") ||
                        arstr[str.length()-1].equals("*")|| arstr[str.length()-1].equals("/")){
                    for (int i = 0; i < str.length()-1; i++) {
                        str1.append(arstr[i]);
                    }
                    str1.append("+");
                    textBox1.setText(str1);
                    EditText editText = (EditText)findViewById(R.id.textBox);
                    editText.setSelection(editText.getText().length());
                    fl_zn=2;

                }
                else if(s.contains(arstr[str.length()-1])&& !str.contains("+") && !str.contains("-")
                        && !str.contains("/") && !str.contains("*")){
                    str1.append("+");
                    textBox1.append(str1);
                    fl_zn=2;
                }
            }



        });

        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = textBox1.getText().toString(), s="1234567890";
                StringBuilder str1 = new StringBuilder("");
                String [] arstr = str.split("");
                if(fl_zn==5) {
                    textBox1.append("-");
                    fl_zn = 3;
                }
                else if(arstr[str.length()-1].equals("-") || arstr[str.length()-1].equals("+") ||
                        arstr[str.length()-1].equals("*")|| arstr[str.length()-1].equals("/")){
                    for (int i = 0; i < str.length()-1; i++) {
                        str1.append(arstr[i]);
                    }
                    str1.append("-");
                    textBox1.setText(str1);
                    EditText editText = (EditText)findViewById(R.id.textBox);
                    editText.setSelection(editText.getText().length());
                    fl_zn=3;

                }
                else if(s.contains(arstr[str.length()-1]) && !str.contains("+") && !str.contains("-")
                        && !str.contains("/") && !str.contains("*")){
                    str1.append("-");
                    textBox1.append(str1);
                    fl_zn=3;
                }
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String sPr = textBox1.getText().toString();
                String [] ars_pr = sPr.split("");
                if (textBox1.getText().toString().equals("") || ((!sPr.contains("+") && !sPr.contains("-")
                        && !sPr.contains("*") && !sPr.contains("/")) || (ars_pr[sPr.length()-1].equals("+") ||
                        ars_pr[sPr.length()-1].equals("-") || ars_pr[sPr.length()-1].equals("*")||
                        ars_pr[sPr.length()-1].equals("/"))))
                {
                    ResultBox.setText("ERROR");
                }
                else {
                    String str = textBox1.getText().toString();
                    StringBuilder str1 = new StringBuilder();
                    StringBuilder str2 = new StringBuilder();
                    String[] arstr = str.split("");
                    int flag_num1 = 0;
                    double x, y, res;
                    for (int i = 0; i < str.length(); i++) {
                        if (arstr[i].equals("+") || arstr[i].equals("-") || arstr[i].equals("/")
                                || arstr[i].equals("*")) {
                            flag_num1++;
                        } else if (flag_num1 == 0)str1.append(arstr[i]);
                        else str2.append(arstr[i]);
                    }
                    x = Double.parseDouble(str1.toString());
                    y = Double.parseDouble(str2.toString());

                    switch (fl_zn) {
                        case 0:
                            res = x * y;
                            break;
                        case 1:
                            if (y != 0) res = x / y;
                            else res = Math.PI;
                            break;
                        case 2:
                            res = x + y;
                            break;
                        case 3:
                            res = x - y;
                            break;
                        default:
                            res = 0;
                    }

                    if (res != Math.PI) {
                        textBox1.setText("");
                        ResultBox.setText(Double.valueOf(res).toString());
                        fl_zn=5;
                    } else {
                        ResultBox.setText("ERROR");
                        fl_zn=5;
                    }
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.about_exit:
            this.finish();
            break;
            case R.id.adout_info:
                Intent intent1 = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent1);
                break;
        }
        return true;
    }
}