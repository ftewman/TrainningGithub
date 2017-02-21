package com.example.quyetchu.trainninggithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> listStatus = new ArrayList<>();
    ArrayAdapter<String> adapterListStatus;
    ListView lvListStatus;
    ImageButton ibAdd;
    EditText edtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cloneData();
        adapterListStatus = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, listStatus);
        lvListStatus = (ListView) findViewById(R.id.lvListStatus);
        ibAdd = (ImageButton) findViewById(R.id.ibAdd);
        edtStatus = (EditText) findViewById(R.id.etStatus);
        lvListStatus.setAdapter(adapterListStatus);

        ibAdd.setOnClickListener(this);
    }

    public void cloneData(){
        for (int i = 0; i < 20; i++){
            listStatus.add("Status " +(i+1));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibAdd:
                listStatus.add(edtStatus.getText().toString());
                adapterListStatus.notifyDataSetChanged();
        }
    }
}
