package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobil2mealdb.R;

public class RecipeListFragment extends Fragment {

    private TextView tvRecipeName, tvCategory, tvCountry;
    private Button btnShowMore, btnRandom;

    private String[] recipeNames = {"Pizza", "Goulash", "Pasta", "Soup"};
    private String[] categories = {"Fast Food", "Main Dish", "Italian", "Starter"};
    private String[] countries = {"Italy", "Hungary", "Italy", "France"};

    private int currentIndex = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);

        tvRecipeName = view.findViewById(R.id.tvRecipeName);
        tvCategory = view.findViewById(R.id.tvCategory);
        tvCountry = view.findViewById(R.id.tvCountry);
        btnShowMore = view.findViewById(R.id.btnShowMore);
        btnRandom = view.findViewById(R.id.btnRandom);

        showRecipe(currentIndex);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (int) (Math.random() * recipeNames.length);
                showRecipe(currentIndex);
            }
        });

        btnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Open recipe details here", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void showRecipe(int index) {
        tvRecipeName.setText(recipeNames[index]);
        tvCategory.setText("Category: " + categories[index]);
        tvCountry.setText("Country: " + countries[index]);
    }
}