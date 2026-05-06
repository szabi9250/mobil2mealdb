package com.example.mobil2mealdb.api;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;


@Dao
public interface MealDao {

    //Recept elmentése a kedvencek közé.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavorite(Meal meal);

    //Recept törlése a kedvencek közül
    @Delete
    void deleteFavorite(Meal meal);

    //Az összes kedvenc recept lekérése(lista forma)
    @Query("SELECT * FROM favorite_meals")
    List<Meal> getAllFavorites();

    // adott recept benne van-e már a kedvencekben
    @Query("SELECT EXISTS (SELECT 1 FROM favorite_meals WHERE idMeal = :id)")
    boolean isFavorite(String id);
}