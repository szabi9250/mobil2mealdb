package com.example.mobil2mealdb.api;

public class IngredientItem {
    public String ingredient;
    public String measure;

    public IngredientItem(String ingredient, String measure) {
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public String getDisplayText() {
        return ingredient + " - " + measure;
    }
}
