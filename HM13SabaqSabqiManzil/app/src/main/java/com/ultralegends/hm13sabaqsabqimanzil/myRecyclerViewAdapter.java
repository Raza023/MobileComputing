package com.ultralegends.hm13sabaqsabqimanzil;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.myVH> {

    @NonNull
    @Override
    public myRecyclerViewAdapter.myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.myVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myVH extends RecyclerView.ViewHolder{

        public myVH(@NonNull View itemView) {
            super(itemView);

        }
    }
}
