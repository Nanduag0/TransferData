package com.example.transferdata.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transferdata.R;
import com.example.transferdata.data.models.ComapnyResponse;
import com.example.transferdata.data.models.UserResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder>
{
    private Context context;
    private List<UserResponse> llist;

    public RecyclerViewAdapter(Context context)
    {

        this.context = context;
        llist=new ArrayList<>();

    }

    public void updateList(List<UserResponse> llist)
    {

        this.llist = llist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.content_main,parent,false);
        return new Viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position)
    {
        holder.uid.setText(llist.get(position).getUid().toString());
        holder.id.setText(llist.get(position).getId().toString());
        holder.title.setText(llist.get(position).getTitle());
        holder.body.setText(llist.get(position).getBody());

    }

    @Override
    public int getItemCount()
    {
        return llist.size();

    }
    /* public void updateList(List<UserResponse> userResponseList)
    {
        this.llist=userResponseList;
        notifyDataSetChanged();

    }
  */
    public class Viewholder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.tv_uid)
        TextView uid;
       @BindView(R.id.itsid)
        TextView id;
        @BindView(R.id.tv_title)
        TextView title;
        @BindView(R.id.tv_body)
        TextView body;

        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
