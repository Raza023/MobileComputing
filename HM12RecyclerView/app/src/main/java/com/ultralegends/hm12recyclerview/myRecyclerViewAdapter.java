package com.ultralegends.hm12recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.myVH> {

    List<Friend> friendsList;
    public myRecyclerViewAdapter(List<Friend> friendsList) {
        this.friendsList = friendsList;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new myVH(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.myVH holder, int position) {
        holder.data = friendsList.get(position);
        holder.imageViewFriend.setImageResource(holder.data.getImageID());
        holder.textViewFriendName.setText(holder.data.getName());
        holder.textViewdateFriend.setText(String.valueOf(holder.data.getDob()));
        holder.textViewCity.setText(holder.data.getCity());
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

    public class myVH extends RecyclerView.ViewHolder{
        ImageView imageViewFriend;
        TextView textViewFriendName;
        TextView textViewdateFriend;
        TextView textViewCity;
        Friend data;
        public myVH(@NonNull View itemView) {
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewdateFriend = itemView.findViewById(R.id.textViewDate);
            textViewCity = itemView.findViewById(R.id.textViewCity);

            textViewFriendName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(textViewCity.getAlpha() != 0F)
                    {
                        textViewCity.animate().alpha(0F).setDuration(1000);
                    }
                    else
                    {
                        textViewCity.animate().alpha(1F).setDuration(1000);
                    }

                }
            });
        }

    }


}
