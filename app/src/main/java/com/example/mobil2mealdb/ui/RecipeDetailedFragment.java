package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobil2mealdb.R;
import com.example.mobil2mealdb.api.Meal;
import com.example.mobil2mealdb.api.MealRepository;
import com.example.mobil2mealdb.api.MealResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeDetailedFragment extends Fragment {

    private MealRepository repository;
    private TextView dRecipeText, dCategoryText, dCountryText, dInstructionsText;
    private ImageView dRecipeimageView;
    private Button btnFavorite;
    private RecyclerView dIngredientsrecyclerView;


    public RecipeDetailedFragment() {
        super(R.layout.fragment_recipe_detailed);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dRecipeText = view.findViewById(R.id.dRecipetextView);
        dCategoryText = view.findViewById(R.id.dCategorytextView);
        dCountryText = view.findViewById(R.id.dCountrytextView);
        dInstructionsText = view.findViewById(R.id.dInstructionstextView);
        dRecipeimageView = view.findViewById(R.id.dRecipeimageView);
        btnFavorite = view.findViewById(R.id.btnFavorite);
        dIngredientsrecyclerView = view.findViewById(R.id.dIngredientsrecyclerView);

        repository = new MealRepository();

        Bundle args = getArguments();
        if (args != null) {
            String mealId = args.getString("mealId");
            loadMealDetails(mealId);
        }
    }

    private void loadMealDetails(String id) {

        repository.getMealById(id).enqueue(new Callback<MealResponse>() {

            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {

                if (response.body() != null
                        && response.body().meals != null
                        && !response.body().meals.isEmpty()) {

                    Meal meal = response.body().meals.get(0);

                    dRecipeText.setText(meal.strMeal);
                    dRecipeText.setGravity(Gravity.CENTER);
                    dCategoryText.setText("Category: " + meal.strCategory);
                    dCountryText.setText("Country: " + meal.strArea);
                    dInstructionsText.setText(meal.strInstructions);

                    Glide.with(dRecipeimageView)
                            .load(meal.strMealThumb)
                            .into(dRecipeimageView);
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Hiba betöltéskor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
