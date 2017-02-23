package com.example.quyetchu.trainninggithub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quyetchu.trainninggithub.R;
import com.example.quyetchu.trainninggithub.entity.User;

import java.util.ArrayList;

/**
 * Created by QuyetChu on 2/22/17.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHoder> {

    ArrayList<User> listUser;
    Context context;

    public UserAdapter(ArrayList<User> listUser, Context context){
        this.listUser = listUser;
        this.context = context;

    }

    public class MyViewHoder extends RecyclerView.ViewHolder {

        public TextView nameUser;

        public MyViewHoder(View view){
            super(view);
            nameUser = (TextView) view.findViewById(R.id.tvNameUser);

//            nameUser.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    context.startActivity(new Intent(context, UpdateActivity.class));
//                }
//            });


        }
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);


        return new MyViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
        User user = listUser.get(position);
        holder.nameUser.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }





}
