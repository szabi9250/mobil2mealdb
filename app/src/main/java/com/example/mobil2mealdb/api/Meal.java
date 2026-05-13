package com.example.mobil2mealdb.api;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "favorite_meals")
public class Meal {

    @PrimaryKey
    @NonNull
    public String idMeal = ""; // ures alapertek

    public String strMeal;
    public String strCategory;
    public String strArea;
    public String strInstructions;
    public String strMealThumb;
    public String strTags;
    public String strYoutube;
    public String strSource;

    //Alapanyagok strIngredient1,strIngredient2....-ben vannak megadva 15-ig, a Measure is ugyanúgy hozzá párba
    public String strIngredient1;
    public String strMeasure1;
    public String strIngredient2;
    public String strMeasure2;
    public String strIngredient3;
    public String strMeasure3;
    public String strIngredient4;
    public String strMeasure4;
    public String strIngredient5;
    public String strMeasure5;
    public String strIngredient6;
    public String strMeasure6;
    public String strIngredient7;
    public String strMeasure7;
    public String strIngredient8;
    public String strMeasure8;
    public String strIngredient9;
    public String strMeasure9;
    public String strIngredient10;
    public String strMeasure10;
    public String strIngredient11;
    public String strMeasure11;
    public String strIngredient12;
    public String strMeasure12;
    public String strIngredient13;
    public String strMeasure13;
    public String strIngredient14;
    public String strMeasure14;
    public String strIngredient15;
    public String strMeasure15;

    public List<IngredientItem> getIngredients() {
        List<IngredientItem> list = new ArrayList<>();

        if (strIngredient1 != null && !strIngredient1.isEmpty())
            list.add(new IngredientItem(strIngredient1, strMeasure1));

        if (strIngredient2 != null && !strIngredient2.isEmpty())
            list.add(new IngredientItem(strIngredient2, strMeasure2));

        if (strIngredient3 != null && !strIngredient3.isEmpty())
            list.add(new IngredientItem(strIngredient3, strMeasure3));

        if (strIngredient4 != null && !strIngredient4.isEmpty())
            list.add(new IngredientItem(strIngredient4, strMeasure4));

        if (strIngredient5 != null && !strIngredient5.isEmpty())
            list.add(new IngredientItem(strIngredient5, strMeasure5));

        if (strIngredient5 != null && !strIngredient5.isEmpty())
            list.add(new IngredientItem(strIngredient5, strMeasure5));

        if (strIngredient6 != null && !strIngredient6.isEmpty())
            list.add(new IngredientItem(strIngredient6, strMeasure6));

        if (strIngredient7 != null && !strIngredient7.isEmpty())
            list.add(new IngredientItem(strIngredient7, strMeasure7));

        if (strIngredient8 != null && !strIngredient8.isEmpty())
            list.add(new IngredientItem(strIngredient8, strMeasure8));

        if (strIngredient9 != null && !strIngredient9.isEmpty())
            list.add(new IngredientItem(strIngredient9, strMeasure9));

        if (strIngredient10 != null && !strIngredient10.isEmpty())
            list.add(new IngredientItem(strIngredient10, strMeasure10));

        if (strIngredient11 != null && !strIngredient11.isEmpty())
            list.add(new IngredientItem(strIngredient11, strMeasure11));

        if (strIngredient12 != null && !strIngredient12.isEmpty())
            list.add(new IngredientItem(strIngredient12, strMeasure12));

        if (strIngredient13 != null && !strIngredient13.isEmpty())
            list.add(new IngredientItem(strIngredient13, strMeasure13));

        if (strIngredient14 != null && !strIngredient14.isEmpty())
            list.add(new IngredientItem(strIngredient14, strMeasure14));

        if (strIngredient15 != null && !strIngredient15.isEmpty())
            list.add(new IngredientItem(strIngredient15, strMeasure15));

        return list;
    }
}