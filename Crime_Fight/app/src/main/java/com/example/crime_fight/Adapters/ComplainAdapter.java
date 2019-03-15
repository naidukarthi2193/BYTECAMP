package com.example.crime_fight.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crime_fight.Models.ComplainModel;
import com.example.crime_fight.R;

import java.util.ArrayList;

public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.ViewHolder> {


    Context context;
    private ArrayList<ComplainModel> complains ;
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView complain,status;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            complain= (TextView)itemView.findViewById(R.id.listcomplain);
            status = (TextView)itemView.findViewById(R.id.liststatus);

        }
    }

    public ComplainAdapter(Context c,ArrayList<ComplainModel> complain){
        context=c;
        complains=complain;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.complainlisteach,viewGroup,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.complain.setText(complains.get(i).getName());

        if(complains.get(i).getStatus() != null){
            switch (complains.get(i).getStatus()){
                case "0":
                    holder.status.setText("Recieved");
                    holder.status.setTextColor(Integer.parseInt("#00BFFF"));
                    break;
                case "1":
                    holder.status.setText("On-Going");
                    holder.status.setTextColor(Integer.parseInt("#FFFF00"));
                    break;
                case "2":
                    holder.status.setText("Stopped");
                    holder.status.setTextColor(Integer.parseInt("#DC143C"));
                    break;
                case "3":
                    holder.status.setText("Completed");
                    holder.status.setTextColor(Integer.parseInt("#00FF00"));
                    break;
            }


        }





    }

    @Override
    public int getItemCount() {
        return (complains == null) ? 0 : complains.size();
    }


}
