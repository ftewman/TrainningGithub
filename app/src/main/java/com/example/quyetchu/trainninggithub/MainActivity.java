package com.example.quyetchu.trainninggithub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quyetchu.trainninggithub.adapter.UserAdapter;
import com.example.quyetchu.trainninggithub.entity.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<User> listUser = new ArrayList<>();
    UserAdapter userAdapter;
    ListView lvListStatus;
    Spinner spUser;
    TextView tvUsername;
    ArrayList<String> list;
    private RecyclerView recyclerView;
    int positionItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lvListStatus = (ListView) findViewById(R.id.lvListStatus);
        //spUser = (Spinner) findViewById(R.id.spListUser);
        //lvListStatus.setAdapter(userAdapter);
        //spUser.setAdapter(userAdapter);
        cloneData();
        tvUsername = (TextView) findViewById(R.id.tvName);

        tvUsername.setText(getIntent().getBundleExtra("bundle").getString("username"));
//        list = getIntent().getStringArrayListExtra("list");
        recyclerView = (RecyclerView) findViewById(R.id.lvListStatus);
        userAdapter = new UserAdapter(listUser, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        positionItemList = position;
                        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                        intent.putExtra("name", listUser.get(position).getName());
                        startActivityForResult(intent, 0);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode){
            case RESULT_OK:
                String newName = data.getStringExtra("new_name");

                Toast.makeText(MainActivity.this, newName, Toast.LENGTH_SHORT).show();
                listUser.get(positionItemList).setName(newName);
                userAdapter.notifyDataSetChanged();
                break;
        }

    }
}
