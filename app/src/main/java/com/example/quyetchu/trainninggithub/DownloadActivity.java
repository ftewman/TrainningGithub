package com.example.quyetchu.trainninggithub;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DownloadActivity extends AppCompatActivity {

    Button btnDownload;
    MyAsynctask myAsynctask;
    EditText etLinkDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        etLinkDownload = (EditText) findViewById(R.id.etLinkDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etLinkDownload.getText().toString().equals("")){
                    Toast.makeText(DownloadActivity.this, "Please insert data ...", Toast.LENGTH_SHORT).show();
                }else {
                    myAsynctask = new MyAsynctask(DownloadActivity.this);
                    myAsynctask.execute(etLinkDownload.getText().toString());
                }
            }
        });
    }


    public class MyAsynctask extends AsyncTask<String, Integer, String>{

        Activity activity;
        ProgressDialog pdDownload;

        public MyAsynctask(Activity activity){
            this.activity = activity;
        }

        @Override
        protected String doInBackground(String... params) {

            for(int i = 1; i <= 100; i++){
                SystemClock.sleep(100);
                publishProgress(i);
            }

            return "Download complete ....";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdDownload = new ProgressDialog(activity);
            pdDownload.setTitle("Download file ...");
            pdDownload.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pdDownload.setMax(100);
            pdDownload.setProgress(0);
            pdDownload.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);


            pdDownload.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String result) {

            pdDownload.hide();
            Toast.makeText(activity, result, Toast.LENGTH_SHORT).show();
        }
    }
}
