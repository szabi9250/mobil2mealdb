package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.mobil2mealdb.R;
import com.example.mobil2mealdb.api.Meal;
import com.example.mobil2mealdb.api.MealRepository;
import com.example.mobil2mealdb.api.MealResponse;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private TextView nameText, categoryText, countryText;
    private ImageView imageView;
    private Button randomButton;
    private Button detailedviewButton;
    private Meal currentMeal;
    private MealRepository repository;
    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameText = view.findViewById(R.id.recipenametextView);
        categoryText = view.findViewById(R.id.categorytextView);
        countryText = view.findViewById(R.id.countrytextView);
        imageView = view.findViewById(R.id.recipeImageView);
        randomButton = view.findViewById(R.id.randomButton);
        detailedviewButton = view.findViewById(R.id.detailedviewButton);

        repository = new MealRepository();

        loadRandomMeal();

        randomButton.setOnClickListener(v -> loadRandomMeal());

        detailedviewButton.setOnClickListener(v -> {
            if (currentMeal != null) {
                Bundle bundle = new Bundle();
                bundle.putString("mealId", currentMeal.idMeal);

                Navigation.findNavController(v)
                        .navigate(R.id.hometodetailed, bundle);
            }
        });
    }

    private void loadRandomMeal() {

        repository.getRandomMeal().enqueue(new Callback<MealResponse>() {

            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {

                if (response.body() != null && response.body().meals != null) {

                    Meal meal = response.body().meals.get(0);
                    currentMeal = meal;

                    nameText.setText(meal.strMeal);
                    categoryText.setText("Category: " + meal.strCategory);
                    countryText.setText("Country: " + meal.strArea);

                    Glide.with(imageView)
                            .load(meal.strMealThumb)
                            .into(imageView);
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Hiba történt", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

