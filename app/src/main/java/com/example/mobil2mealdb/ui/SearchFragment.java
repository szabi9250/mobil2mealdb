package com.example.mobil2mealdb.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobil2mealdb.api.MealRepository;
import com.example.mobil2mealdb.api.MealResponse;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;
import com.example.mobil2mealdb.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private RecyclerView rvSearchResults;
    private TextInputEditText etSearch;
    private Chip chipCategory;


    private MealAdapter adapter;
    private MealRepository repository;

    public SearchFragment() {
        super(R.layout.fragment_search);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSearchResults = view.findViewById(R.id.rvSearchResults);
        etSearch = view.findViewById(R.id.etSearch);
        chipCategory = view.findViewById(R.id.chipCategory);


        repository = new MealRepository();
        adapter = new MealAdapter();

        //
        rvSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSearchResults.setAdapter(adapter);


        etSearch.setOnEditorActionListener((textView, actionId, keyEvent) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                String beirtSzoveg = etSearch.getText().toString();


                performSearch(beirtSzoveg);
                return true;
            }
            return false;
        });

        chipCategory.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Kategória szűrő (Később valósítjuk meg)", Toast.LENGTH_SHORT).show();
        });
    }


    private void performSearch(String query) {
        repository.searchMealsByName(query).enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.body() != null && response.body().meals != null) {

                    adapter.setMeals(response.body().meals);
                } else {
                    Toast.makeText(getContext(), "Nincs találat erre: " + query, Toast.LENGTH_SHORT).show();
                    adapter.setMeals(null);
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Hiba a hálózati lekérés során", Toast.LENGTH_SHORT).show();
            }
        });
    }
}