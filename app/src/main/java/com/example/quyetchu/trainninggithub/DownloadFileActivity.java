package com.example.quyetchu.trainninggithub;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class DownloadFileActivity extends AppCompatActivity {

    Button btnDownload;
    EditText etLinkDownload;
    int checkCount = 3;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        etLinkDownload = (EditText) findViewById(R.id.etLinkDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = new Random().nextInt(9999);

                if(etLinkDownload.getText().toString().equals("")){
                    Toast.makeText(DownloadFileActivity.this, "Please insert data ...", Toast.LENGTH_SHORT).show();
                }else {

                    new Downloader(DownloadFileActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                }
            }
        });
    }


    private class Downloader extends AsyncTask<Void, Integer, Integer> {

        NotificationManager mNotifyManager;
        Builder mBuilder;
        Activity activity;

        public Downloader(Activity activity){
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            checkCount -= 1;
            mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mBuilder = new NotificationCompat.Builder(activity);
            mBuilder.setContentTitle("Download file "+ etLinkDownload.getText().toString())
                    .setContentText("Download in progress")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setProgress(100, 0, false);
            mNotifyManager.notify(id, mBuilder.build());
            Log.e("Count", id+"");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mBuilder.setProgress(100, values[0], false);
            mNotifyManager.notify(id, mBuilder.build());
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            int i;
            for (i = 0; i <= 100; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.d("TAG", "sleep failure");
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            checkCount += 1;
            mBuilder.setProgress(100, 0, false);
            mBuilder.setContentText("Download complete ...");
            mNotifyManager.notify(id, mBuilder.build());
        }
    }
}
