package com.example.sportsapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Here, It is used to bind Adapter class with Adapter item view
public class myCustomAdapter extends RecyclerView.Adapter<myCustomAdapter.viewHolder> {

    public itemClickListner clickListner;

    public void setClickListner(itemClickListner clickListner) {
        this.clickListner = clickListner;
    }

    // it is List by using model class
    private List<sports>sportsList;


    // It is Constructor of List
    public myCustomAdapter(List<sports> sportsList) {
        this.sportsList = sportsList;
    }


    // These are three esstential methods need to implement for recyclerView
    @NonNull
    @Override

    // This method is used to Create a new viewholder object  when Recycler view need new item view
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_item_layout,
                parent,
                false
        );
        return new viewHolder(viewItem);
    }


    // This method is used to bind data With the Specfic Postion of Item
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        // we use this for getting the specific position of item from model class
        //syntax:  model_class variable = List_name.get(int position)
        sports s= sportsList.get(position);
        
        holder.card_name.setText(s.getSportName());
        holder.card_image.setImageResource(s.getSportimage());

    }

    @Override
    public int getItemCount() {
        return sportsList.size();
    }



    public  class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // making Reference of view with custom layout . here, named as cardvirw_item_layout
        ImageView card_image;
        TextView card_name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            // finding views
            card_image=itemView.findViewById(R.id.card_image);
            card_name=itemView.findViewById(R.id.card_name);

        }

        @Override
        public void onClick(View view) {
            if(clickListner !=null){
                clickListner.onCLick(view,getAdapterPosition());
            }
        }
    }


}
