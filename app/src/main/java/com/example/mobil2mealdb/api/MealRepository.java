package com.example.mobil2mealdb.api;

import retrofit2.Call;
public class MealRepository {

    private final MealApi api = RetrofitClient.getApi();

    public Call<MealResponse> getRandomMeal() {
        return api.getRandomMeal();
    }
}
