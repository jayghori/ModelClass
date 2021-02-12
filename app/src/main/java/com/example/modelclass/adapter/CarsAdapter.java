package com.example.modelclass.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modelclass.Model.Cars;
import com.example.modelclass.R;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    Context context;
    List<Cars> carsList;
    String TAG ="TAGER";

    public CarsAdapter(Context context, List<Cars> carsList) {
        this.context = context;
        this.carsList = carsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvModel.setText(carsList.get(position).getModel());
        holder.tvPrice.setText(carsList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView tvModel,tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvModel=itemView.findViewById(R.id.tvModel);
            tvPrice=itemView.findViewById(R.id.tvPrice);
        }
    }
}
