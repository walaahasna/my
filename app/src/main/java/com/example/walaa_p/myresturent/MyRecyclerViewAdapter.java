package com.example.walaa_p.myresturent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jit on 01/09/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<food> myFood;
    MyRecyclerViewAdapter listener;




    public MyRecyclerViewAdapter(Context context, List<food> Programs){
        this.context = context;
        this.myFood=Programs;
        
    }
    public void setRecyclerViewListener(MyRecyclerViewAdapter listener){
        this.listener = listener ;
    }

    @Override
    public MyViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);
        final MyViewHolder vh = new MyViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
       food s =myFood.get(position);

        holder.tv1.setText(s.getName()
        );

        holder.i.setImageResource(s.getPhoto());
    }

    @Override
    public int getItemCount() {
            return myFood.size();
    }





    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv1;
        ImageView i;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.name);
             i=(ImageView)itemView.findViewById(R.id.imageView);
    }


}




}

