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

import com.example.myapplication.R;
import com.example.myapplication.ReminderData;

import java.util.ArrayList;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {
    Context context;
    ArrayList<ReminderData> reminderData;

    public ReminderAdapter(Context context, ArrayList<ReminderData> reminderData){
        this.context = context;
        this.reminderData = reminderData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.reminder_list_look, parent, false);
//        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_list_look, parent, false));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.reminderCategory.setText(reminderData.get(position).getCategory());
        holder.reminderNote.setText(reminderData.get(position).getNote());
        holder.reminderDate.setText(reminderData.get(position).getDate());                ;
        holder.reminderAmount.setText(valueOf((int) reminderData.get(position).getAmount()));

    }

    @Override
    public int getItemCount() { return reminderData.size();}

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView reminderCategory, reminderAmount, reminderDate, reminderNote;
        private LinearLayout toplayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reminderCategory = itemView.findViewById(R.id.reminder_category);
            reminderAmount = itemView.findViewById(R.id.reminder_amount);
            reminderDate =  itemView.findViewById(R.id.reminder_date);
            reminderNote = itemView.findViewById(R.id.reminder_note);
            toplayout = itemView.findViewById(R.id.toplayout);
        }
    }

}
