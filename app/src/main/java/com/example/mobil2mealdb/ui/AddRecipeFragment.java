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

                isFavorite = !isFavorite;

                if (isFavorite) {
                    btnFavorite.setText("Added");
                    Toast.makeText(getActivity(), "Recipe added to favorites", Toast.LENGTH_SHORT).show();
                } else {
                    btnFavorite.setText("Add to favorites");
                    Toast.makeText(getActivity(), "Recipe removed from favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}