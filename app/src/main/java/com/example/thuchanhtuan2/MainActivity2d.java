package com.example.thuchanhtuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class MainActivity2d extends AppCompatActivity {
    TextView txtPass;
    EditText txtLenght;
    CheckBox chkLower;
    CheckBox chkUp;
    CheckBox chkNumber;
    CheckBox chkSpecial;
    Button btnGenerate;
    ArrayList<Integer> a = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d);

        try {
            txtPass = findViewById(R.id.txtPass);
            txtLenght = findViewById(R.id.txtLenght);
            btnGenerate = findViewById(R.id.btnGenerate);
            chkLower = findViewById(R.id.chkLower);
            chkUp = findViewById(R.id.chkUp);
            chkNumber = findViewById(R.id.chkNumber);
            chkSpecial = findViewById(R.id.chkSpecial);

            btnGenerate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a.clear();
                    txtPass.setText("");
                    if (chkLower.isChecked())
                        a.add(1);
                    if (chkUp.isChecked())
                        a.add(2);
                    if (chkNumber.isChecked())
                        a.add(3);
                    if (chkSpecial.isChecked())
                        a.add(4);
                    int lenght = Integer.parseInt(String.valueOf(txtLenght.getText()));
                    String password = "";
                    for (int i = 0; i < lenght; i++) {
                        int tmp = randomOnePosition(a);
                        if (tmp == 1)
                            password += randomLowerCase();
                        if (tmp == 2)
                            password += randomUpCase();
                        if (tmp == 3)
                            password += randomNumber();
                    }
                    txtPass.setText(password);
                }
            });
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    int randomOnePosition(ArrayList<Integer> b){
        Random r = new Random();
        int randomIndex = r.nextInt(b.size());
        return b.get(randomIndex);
    }
    char randomUpCase(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'A');
        return c;
    }
    char randomLowerCase(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }
    char randomNumber(){
        Random r = new Random();
        char c = (char)(r.nextInt(9) + '0');
        return c;
    }
}