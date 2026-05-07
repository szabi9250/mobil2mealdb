package com.example.mobil2mealdb.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealApi {

    @GET("api/json/v1/1/random.php")
    Call<MealResponse> getRandomMeal();

    @GET("api/json/v1/1/lookup.php")
    Call<MealResponse> getMealById(@Query("i") String id);

    @GET("api/json/v1/1/search.php")
    Call<MealResponse> searchMealsByName(@Query("s") String query);

    @GET("api/json/v1/1/filter.php")
    Call<MealResponse> filterMealsByCategory(@Query("c") String category);


    @GET("api/json/v1/1/filter.php")
    Call<MealResponse> filterMealsByArea(@Query("a") String area);
}