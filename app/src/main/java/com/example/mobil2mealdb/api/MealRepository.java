package com.example.mobil2mealdb.api;

import retrofit2.Call;
public class MealRepository {

    private final MealApi api = RetrofitClient.getApi();

    public Call<MealResponse> getRandomMeal() {
        return api.getRandomMeal();
    }
    public Call<MealResponse> getMealById(String id) {return api.getMealById(id);}

    public Call<MealResponse> searchMealsByName(String query) {
        return api.searchMealsByName(query);
    }
}
