package com.example.crime_fight.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crime_fight.Models.ComplainModel;
import com.example.crime_fight.R;

import java.util.ArrayList;
import java.util.List;


public class ComplainAdapter extends RecyclerView.Adapter<ComplainAdapter.ViewHolder> implements View.OnClickListener {



    private List<ComplainModel> complains ;
    private Context context;

    @Override
    public void onClick(View v) {






    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView complain,status,policestn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            policestn = (TextView)itemView.findViewById(R.id.listpolice);
            complain= (TextView)itemView.findViewById(R.id.listcomplain);
            status = (TextView)itemView.findViewById(R.id.liststatus);

        }
    }

    public ComplainAdapter(Context cont,List<ComplainModel> complain){
        this.context=cont;
        this.complains=complain;
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {

        final ComplainModel compl = complains.get(i);
        holder.complain.setText(compl.getName());
        holder.policestn.setText(compl.getPoliceStn());
            switch (complains.get(i).getStatus()){
                case "0":
                    holder.status.setText("Recieved");
                    holder.status.setTextColor(Color.parseColor("#00BFFF"));
                    break;
                case "1":
                    holder.status.setText("On-Going");
                    holder.status.setTextColor(Color.parseColor("#FFFF00"));
                    break;
                case "2":
                    holder.status.setText("Stopped");
                    holder.status.setTextColor(Color.parseColor("#DC143C"));
                    break;
                case "3":
                    holder.status.setText("Completed");
                    holder.status.setTextColor(Color.parseColor("#00FF00"));
                    break;
            }


    }

    @Override
    public int getItemCount() {
        return complains.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.complainlisteach,viewGroup,false));
    }






}
