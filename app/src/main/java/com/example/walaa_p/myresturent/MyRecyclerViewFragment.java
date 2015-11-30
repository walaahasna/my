package com.example.walaa_p.myresturent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MyRecyclerViewFragment extends Fragment {

    ArrayList<food> myfood;
    MyRecyclerViewAdapter adapter;
    public  static  String name;

    public  static int photo;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.recycler_view_frag_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myfood = new ArrayList<food>();
        RecyclerView rv = (RecyclerView)this.getView().findViewById(R.id.recyclerView);

        food s1 = new food(R.drawable.f1,"pizaa");
        food s2 = new food(R.drawable.f1,"domines pizza");

        myfood.add(s1);
        myfood.add(s2);





        final LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);

        DefaultItemAnimator animator =new DefaultItemAnimator();
        animator.setRemoveDuration(2000);
        animator.setAddDuration(2000);
        rv.setItemAnimator(animator);
        adapter = new MyRecyclerViewAdapter(getActivity(),myfood);

        rv.setAdapter(adapter);



    }
                }

