package com.sanoj.devildeveloper.balanceencript;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sanoj.balanced.encript.decript.BED;

public class MainActivity extends AppCompatActivity {

    private EditText mMyKey,mInput,mOutput;
    private Button mBtn;
    private String myEncriptkey;
    private String inputvalue;
    private String outputvalue;
    private CheckBox Encrip,Decript;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.clicked);
        mMyKey = findViewById(R.id.mykey);
        mInput = findViewById(R.id.input);
        mOutput = findViewById(R.id.output);
        Encrip = findViewById(R.id.checkBox);
        Encrip.setChecked(true);
        Decript = findViewById(R.id.checkBox2);
        Decript.setChecked(false);

        Encrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mInput.setText("");
                mOutput.setText("");
                if(isChecked){
                    Decript.setChecked(false);
                }else{
                    Decript.setChecked(true);
                    mInput.setHint("Enter Your Encript String");
                    mOutput.setHint("Output Decript String");
                    mMyKey.setHint("Enter Decript Key");
                }
            }
        });
        Decript.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mInput.setText("");
                mOutput.setText("");
                if(isChecked){
                    Encrip.setChecked(false);
                }else{
                    Encrip.setChecked(true);
                    mInput.setHint("Enter Your String");
                    mOutput.setHint("Output Encript String");
                    mMyKey.setHint("Enter Encript Key");
                }
            }
        });

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputvalue = mInput.getText().toString();
                myEncriptkey = mMyKey.getText().toString();

                if(Encrip.isChecked()){
                    try{
                        if(myEncriptkey.length()<=0){
                            Toast.makeText(getApplicationContext(),"1st Enter Encripty key",Toast.LENGTH_SHORT).show();
                        }else{
                            if (inputvalue.length()<=0){
                                Toast.makeText(getApplicationContext(),"Enter Input text",Toast.LENGTH_SHORT).show();
                            }else{
                                outputvalue = BED.encryptToBase64String(inputvalue,myEncriptkey);
                            }

                        }

                    }catch (Exception e){
                        mOutput.setText("Error pls chech all feed");
                    }finally{
                        mOutput.setText(outputvalue);
                    }
                }else{

                    try{
                        if(myEncriptkey.length()<=0){
                            Toast.makeText(getApplicationContext(),"1st Enter Decript key",Toast.LENGTH_SHORT).show();
                        }else{
                            if (inputvalue.length()<=0){
                                Toast.makeText(getApplicationContext(),"Enter Decript String",Toast.LENGTH_SHORT).show();
                            }else{
                                outputvalue = BED.decryptBase64StringToString(inputvalue,myEncriptkey);
                            }

                        }

                    }catch (Exception e){
                        mOutput.setText("Error pls chech all feed");
                    }finally{
                        mOutput.setText(outputvalue);
                    }

                }



            }
        });








    }
}