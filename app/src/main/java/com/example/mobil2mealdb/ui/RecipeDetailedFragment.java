package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.mobil2mealdb.R;

public class RecipeDetailedFragment extends Fragment {
    public RecipeDetailedFragment() {
        super(R.layout.fragment_recipe_detailed);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String mealId = getArguments().getString("mealId");
    }


}
