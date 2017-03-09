package com.example.rent.movieapp;

import java.util.Observable;

import retrofit2.http.Query;
import retrofit2.http.GET;

/**
 * Created by RENT on 2017-03-08.
 */


public interface SearchService {

    @GET("/")
    io.reactivex.Observable<SearchResult> search(@Query("s") String title, @Query("y") String year, @Query("type") String type);
}
