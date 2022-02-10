package com.doubleclick.realmdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;


public class ReecyelerAdapter extends RealmRecyclerViewAdapter<TaskDB,ReecyelerAdapter.RecyclerViewHolder> {

    public ReecyelerAdapter(@Nullable OrderedRealmCollection<TaskDB> data) {
        super(data, true);
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();

    }

    @NonNull
    @Override
    public ReecyelerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReecyelerAdapter.RecyclerViewHolder holder, int position) {
        TaskDB taskDB = getItem(position);
        holder.textView.setText(taskDB.getTask());
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.editTextTextPersonName);
        }
    }
}
