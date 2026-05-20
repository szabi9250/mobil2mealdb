package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.mobil2mealdb.api.AppDatabase;
import com.example.mobil2mealdb.api.Meal;

import com.example.mobil2mealdb.R;

public class AddRecipeFragment extends Fragment {

    private Button btnFavorite;
    private boolean isFavorite = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_recipe, container, false);

        btnFavorite = view.findViewById(R.id.btnFavorite);

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Meal meal = new Meal();

                meal.idMeal = "local_" + System.currentTimeMillis();
                meal.strMeal = "Custom Recipe";
                meal.strCategory = "Local";
                meal.strArea = "Own";
                meal.strInstructions = "User added recipe";
                meal.strMealThumb = "";

                new Thread(() -> {

                    AppDatabase db = AppDatabase.getInstance(requireContext());
                    db.mealDao().insertFavorite(meal);

                    requireActivity().runOnUiThread(() -> {
                        btnFavorite.setText("Added");
                        Toast.makeText(getActivity(),
                                "Recipe added to favorites",
                                Toast.LENGTH_SHORT).show();
                    });

                }).start();
            }
        });

        return view;
    }
}