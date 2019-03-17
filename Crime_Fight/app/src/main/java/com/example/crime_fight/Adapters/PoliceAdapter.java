package com.example.crime_fight.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crime_fight.Activities.Police_Details;
import com.example.crime_fight.Models.ComplainModel;
import com.example.crime_fight.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PoliceAdapter extends  RecyclerView.Adapter<PoliceAdapter.ViewHolder>  {

    private ArrayList<ComplainModel> police_list,complains ;
    Context context,ctx;




    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView complain,status,name;
        public ArrayList<ComplainModel> compList,dialogComp,complains;
        public Context ctx;



        public ViewHolder(@NonNull View itemView, Context ctx, ArrayList<ComplainModel> compList) {
            super(itemView);
            this.dialogComp=compList;
            this.ctx=ctx;

            itemView.setOnClickListener(this);
            name = (TextView)itemView.findViewById(R.id.policelist_name);
            complain= (TextView)itemView.findViewById(R.id.policelist_complain);
            status = (TextView)itemView.findViewById(R.id.policelist_status);
        }

        @Override
        public void onClick(View v) {

//            Toast.makeText(v.getContext(),"Clicked",Toast.LENGTH_SHORT).show();


            int position = getAdapterPosition();
            final ComplainModel dialogInfo = this.dialogComp.get(position);
            Toast.makeText(v.getContext(),dialogInfo.getName()+dialogInfo.getComplain()+dialogInfo
                    .getAdharnumber()+"xx"+dialogInfo.getPoliceStn()+dialogInfo.getStatus(),Toast.LENGTH_SHORT).show();
//
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(v.getContext());
//            mBuilder.setTitle("Hello");
//            mBuilder.show();

            final Dialog dialog = new Dialog(ctx);
            dialog.setContentView(R.layout.police_status_dialog);
            dialog.setTitle("Status");
            final TextView name = (TextView)dialog.findViewById(R.id.nameValue);
            name.setText(dialogInfo.getName());
            TextView adhar  = (TextView)dialog.findViewById(R.id.adharValue);
            adhar.setText(dialogInfo.getAdharnumber());
            TextView comps = (TextView)dialog.findViewById(R.id.complainValue);
            comps.setText(dialogInfo.getComplain());
             TextView address = (TextView)dialog.findViewById((R.id.addressValue));
            address.setText(dialogInfo.getAddress());
            ImageView closer =(ImageView)dialog.findViewById(R.id.close);
            closer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            TextView status = (TextView)dialog.findViewById(R.id.statusValue);
            switch (dialogInfo.getStatus()){
                case "0":
                    status.setText("Recieved");
                    status.setTextColor(Color.parseColor("#00BFFF"));
                    break;
                case "1":
                    status.setText("On-Going");
                    status.setTextColor(Color.parseColor("#FFFF00"));
                    break;
                case "2":
                    status.setText("Completed");
                    status.setTextColor(Color.parseColor("#00FF00"));
                    break;
                case "3":
                    status.setText("Stopped");
                    status.setTextColor(Color.parseColor("#DC143C"));
                    break;

            }

            Button accept = (Button)dialog.findViewById(R.id.statusOngoing);
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference myref;
                    myref =  FirebaseDatabase.getInstance().getReference();
                    myref.child("Complain").child(name.getText().toString()).child("status").setValue("1");
                    myref.child("Police").child(dialogInfo.getPoliceStn()).child(name.getText().toString()).child("status").setValue("1");
                    Toast.makeText(ctx,"Complain Accepted",Toast.LENGTH_LONG);
                    dialog.dismiss();
                }
            });
            Button complete = (Button)dialog.findViewById(R.id.statusCompleted);
            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatabaseReference myref;
                    myref =  FirebaseDatabase.getInstance().getReference();
                    myref.child("Complain").child(name.getText().toString()).child("status").setValue("2");
                    myref.child("Police").child(dialogInfo.getPoliceStn()).child(name.getText().toString()).child("status").setValue("2");
                    Toast.makeText(ctx,"Complain Completed",Toast.LENGTH_LONG);
                    dialog.dismiss();
                }
            });
            Button close = (Button)dialog.findViewById(R.id.statusStop);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference myref;
                    myref =  FirebaseDatabase.getInstance().getReference();
                    myref.child("Complain").child(name.getText().toString()).child("status").setValue("3");
                    myref.child("Police").child(dialogInfo.getPoliceStn()).child(name.getText().toString()).child("status").setValue("3");
                    Toast.makeText(ctx,"Complain Closed",Toast.LENGTH_LONG);
                    dialog.dismiss();
                }
            });

            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);



        }
    }

    public PoliceAdapter(Context context,ArrayList<ComplainModel> policelist){
        this.police_list=policelist;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull final PoliceAdapter.ViewHolder holder, int i) {

        final ComplainModel compl = police_list.get(i);
        holder.name.setText(compl.getName());
        holder.complain.setText(compl.getComplain());
        switch (police_list.get(i).getStatus()){
            case "0":
                holder.status.setText("Recieved");
                holder.status.setTextColor(Color.parseColor("#00BFFF"));
                break;
            case "1":
                holder.status.setText("On-Going");
                holder.status.setTextColor(Color.parseColor("#FFFF00"));
                break;
            case "2":
                holder.status.setText("Completed");
                holder.status.setTextColor(Color.parseColor("#00FF00"));
                break;
            case "3":
                holder.status.setText("Stopped");
                holder.status.setTextColor(Color.parseColor("#DC143C"));
                break;
        }


    }

    @Override
    public int getItemCount() {
        return police_list.size();
    }

    @NonNull
    @Override
    public PoliceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new PoliceAdapter.ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.policelisteach,viewGroup,false),
                viewGroup.getContext(),police_list
                );
    }

}
