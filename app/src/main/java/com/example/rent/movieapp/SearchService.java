package com.example.rent.movieapp;

import java.util.Observable;

import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * Created by RENT on 2017-03-08.
 */


public interface SearchService {

    @GET("/")
    io.reactivex.Observable<SearchResult> search(@Field("s") String title);
}
