package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobil2mealdb.R;
import com.example.mobil2mealdb.api.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Meal> mealList = new ArrayList<>();

    public void setMeals(List<Meal> meals) {
        this.mealList = meals != null ? meals : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipe, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);


        holder.tvName.setText(meal.strMeal);


        // Kép
        Glide.with(holder.itemView.getContext())
                .load(meal.strMealThumb)
                .into(holder.ivThumb);

        //Át Részletes
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("mealId", meal.idMeal);

            Navigation.findNavController(v).navigate(R.id.hometodetailed, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivThumb;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.iRecipetextView);
            ivThumb = itemView.findViewById(R.id.iRecipeimageView);
        }
    }
}