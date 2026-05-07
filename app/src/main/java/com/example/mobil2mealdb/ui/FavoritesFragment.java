
package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobil2mealdb.R;
import com.example.mobil2mealdb.api.AppDatabase;
import com.example.mobil2mealdb.api.Meal;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    private RecyclerView rvFavorites;
    private TextView tvEmptyFavorites;
    private MealAdapter adapter;

    public FavoritesFragment() {
        super(R.layout.fragment_favorites);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFavorites = view.findViewById(R.id.rvFavorites);
        tvEmptyFavorites = view.findViewById(R.id.tvEmptyFavorites);


        adapter = new MealAdapter(R.id.action_favoritesFragment_to_recipedetailedFragment);
        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFavorites.setAdapter(adapter);


        loadFavorites();
    }

    private void loadFavorites() {

        new Thread(() -> {


            AppDatabase db = AppDatabase.getInstance(requireContext());
            List<Meal> favoriteMeals = db.mealDao().getAllFavorites();


            requireActivity().runOnUiThread(() -> {


                if (favoriteMeals.isEmpty()) {
                    rvFavorites.setVisibility(View.GONE);
                    tvEmptyFavorites.setVisibility(View.VISIBLE);
                } else {
                    rvFavorites.setVisibility(View.VISIBLE);
                    tvEmptyFavorites.setVisibility(View.GONE);
                    adapter.setMeals(favoriteMeals);
                }
            });

        }).start();
    }
}