package com.umda.selfmartapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.umda.selfmartapp.R;
import com.umda.selfmartapp.activities.DetailedActivity;
import com.umda.selfmartapp.models.ShowAllModel;

import java.util.List;

public class ShowAllAdapter extends RecyclerView.Adapter<ShowAllAdapter.ViewHolder> {
    private Context context;
    private List<ShowAllModel> showAllModelList;

    public ShowAllAdapter(Context context, List<ShowAllModel> showAllModelList) {
        this.context = context;
        this.showAllModelList = showAllModelList;
    }

    @NonNull
    @Override
    public ShowAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_all_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAllAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(showAllModelList.get(position).getImg_url()).into(holder.myItemImage);
        holder.myCost.setText("$" + showAllModelList.get(position).getPrice());
        holder.myName.setText(showAllModelList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed", showAllModelList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return showAllModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myItemImage;
        private TextView myCost, myName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            myItemImage = itemView.findViewById(R.id.item_image);
            myCost = itemView.findViewById(R.id.item_cost);
            myName = itemView.findViewById(R.id.item_name);
        }
    }
}
