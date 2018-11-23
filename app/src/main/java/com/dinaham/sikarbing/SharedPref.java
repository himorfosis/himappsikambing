package com.dinaham.sikarbing;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by him on 5/8/2018.
 */

public class SharedPref {

    public static final String GEJALA = "gejala";
//    public static final String FAVORITES = "Product_Favorite";

    public SharedPref() {
        super();
    }

    // This four methods are used for maintaining favorites.
    public void saveFavorites(Context context, List<ClassDataGejala> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(GEJALA,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(GEJALA, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, ClassDataGejala product) {
        List<ClassDataGejala> gejala = getGejala(context);
        if (gejala == null)
            gejala = new ArrayList<ClassDataGejala>();
        gejala.add(product);
        saveFavorites(context, gejala);
    }

    public void removeFavorite(Context context, ClassDataGejala product) {
        ArrayList<ClassDataGejala> gejala = getGejala(context);
        if (gejala != null) {
            gejala.remove(product);
            saveFavorites(context, gejala);
        }
    }

    public ArrayList<ClassDataGejala> getGejala(Context context) {
        SharedPreferences settings;
        List<ClassDataGejala> favorites;

        settings = context.getSharedPreferences(GEJALA,
                Context.MODE_PRIVATE);

        if (settings.contains(GEJALA)) {
            String jsonFavorites = settings.getString(GEJALA, null);
            Gson gson = new Gson();
            ClassDataGejala[] favoriteItems = gson.fromJson(jsonFavorites,
                    ClassDataGejala[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<ClassDataGejala>(favorites);
        } else
            return null;

        return (ArrayList<ClassDataGejala>) favorites;
    }
}
