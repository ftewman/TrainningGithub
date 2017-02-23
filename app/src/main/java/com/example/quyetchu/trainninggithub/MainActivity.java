package com.example.quyetchu.trainninggithub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quyetchu.trainninggithub.adapter.UserAdapter;
import com.example.quyetchu.trainninggithub.entity.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<User> listUser = new ArrayList<>();
    UserAdapter userAdapter;
    ListView lvListStatus;
    Spinner spUser;
    TextView tvUsername;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userAdapter = new UserAdapter(listUser);
        //lvListStatus = (ListView) findViewById(R.id.lvListStatus);
        //spUser = (Spinner) findViewById(R.id.spListUser);
        //lvListStatus.setAdapter(userAdapter);
        //spUser.setAdapter(userAdapter);
        cloneData();
        tvUsername = (TextView) findViewById(R.id.tvName);
        tvUsername.setText(getIntent().getStringExtra("username"));
        recyclerView = (RecyclerView) findViewById(R.id.lvListStatus);
        userAdapter = new UserAdapter(listUser);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);


    }

    public void cloneData(){

        for (int i = 1; i < 2000; i++){
            listUser.add(new User("Quyet Chu" + (i), "Android Developer" + (i), i));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibAdd:

        }
    }
}
