package com.example.myapplication.Adapters;

import static java.lang.String.valueOf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AutopayData;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AutopayAdapter extends RecyclerView.Adapter<AutopayAdapter.ViewHolder> {
    Context context;
    ArrayList<AutopayData> autopayData;

    public AutopayAdapter(Context context, ArrayList<AutopayData> autopayData){
        this.context = context;
        this.autopayData = autopayData;
    }
    @NonNull
    @Override
    public AutopayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.autopay_list_look, parent, false);
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_list_look, parent, false));
        return new AutopayAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.autopayCategory.setText(autopayData.get(position).getCategory());
        holder.autopayNote.setText(autopayData.get(position).getNote());
        holder.autopayDate.setText(autopayData.get(position).getDate_limit());                ;
        holder.autopayAmount.setText(valueOf((int) autopayData.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return autopayData.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView autopayCategory, autopayAmount, autopayDate, autopayNote;
        private LinearLayout toplayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            autopayCategory = itemView.findViewById(R.id.autopay_category);
            autopayAmount = itemView.findViewById(R.id.autopay_amount);
            autopayDate =  itemView.findViewById(R.id.autopay_date);
            autopayNote = itemView.findViewById(R.id.autopay_note);
            toplayout = itemView.findViewById(R.id.toplayout);
        }
    }
}
