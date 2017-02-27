package com.example.quyetchu.trainninggithub;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MyThreadActivity extends AppCompatActivity implements View.OnClickListener{

    Handler handler;
    EditText etName;
    Button btnExit;
    Button btnClear;
    int i;
    StringBuffer sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_thread);

        init();

        btnExit.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        sb =new StringBuffer();

        doStart();
        handler=new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //etName.setText(msg.arg1+"");
                sb.append(msg.arg1+"\n");
                etName.setText(sb);

            }
        };
    }



    private void init(){

        etName = (EditText) findViewById(R.id.etName);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnClear = (Button) findViewById(R.id.btnClear);
    }

    public void doStart() {

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {
                    SystemClock.sleep(1000);

                    Message msg = handler.obtainMessage();
                    msg.arg1 = new Random().nextInt(51) + 50;
                    handler.sendMessage(msg);


                }

            }
        });

        th.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                i = 1;
                while (true){
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg1=handler.obtainMessage();
                    msg1.arg1 = i;
                    handler.sendMessage(msg1);
                    i += 2;
                }




            }
        });

        th2.start();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExit:
                System.exit(0);
                break;
            case R.id.btnClear:
                etName.getText().clear();

        }
    }
}
