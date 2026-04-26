package com.example.mobil2mealdb.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobil2mealdb.api.IngredientItem;

import java.util.ArrayList;
import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.VH> {

    private List<IngredientItem> items = new ArrayList<>();

    public void setItems(List<IngredientItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.textView.setText(items.get(position).getDisplayText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView textView;

        VH(View v) {
            super(v);
            textView = v.findViewById(android.R.id.text1);
        }
    }
}
