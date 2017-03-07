package com.example.rent.movieapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RENT on 2017-03-07.
 */

public class MovieListingItem {
    @SerializedName("Title")
    private String Title;
    @SerializedName("Year")
    private String Year;

    private String imdbID;
    @SerializedName("Type")
    private String Type;
    @SerializedName("Poster")
    private String Poster;


    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return Type;
    }

    public String getPoster() {
        return Poster;
    }
}
