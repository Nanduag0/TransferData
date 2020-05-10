package com.example.transferdata.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.transferdata.R;
import com.example.transferdata.data.models.UserResponse;
import com.example.transferdata.models.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
   private  ViewModel viewModel;

  // List<UserResponse>  mlist;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    private static final String TAG="nandi";


    private RecyclerViewAdapter recyclerViewAdapter;

    private void initAdapter(Context context)
    {
        recyclerViewAdapter =  new RecyclerViewAdapter(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel= ViewModelProviders.of(this).get(ViewModel.class);
        if(viewModel==null)
        {
            Log.d(TAG,"viewmodel is null");

        }
        else
            Log.d(TAG,"viewmodel is not null");

        /*viewModel.getUserList().observe(this, new Observer<ArrayList<UserResponse>>() {
            @Override
            public void onChanged(ArrayList<UserResponse> userResponses) {
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });*/
        initAdapter(this);
        setRecyclerAdapter(this,recyclerView,recyclerViewAdapter);
        viewModel.getusers();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        viewModel.getUserList().observe(this,data ->
        {
        if(data!=null)
        {
            recyclerViewAdapter.updateList(data);
           // mlist.add(new String(data.toString()))
        }
        });
    }
    /* private void subscribeObserver(){
        viewModel.getUserList().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse)
            {
                Log.d(TAG, "onChanged: " + userResponse.getUsers());
                mUserList = userResponse.getUsers();

                recyclerViewAdapter.updateList(mUserList);

            }
        });
    }*/

    private void setRecyclerAdapter(MainActivity mainActivity, RecyclerView recyclerView, RecyclerViewAdapter recyclerViewAdapter)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
