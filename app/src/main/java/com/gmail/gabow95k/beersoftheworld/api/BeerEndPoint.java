package com.gmail.gabow95k.beersoftheworld.api;

import com.gmail.gabow95k.beersoftheworld.model.Beer;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerEndPoint {

    @GET("beers")
    Single<List<Beer>> getBeers(@Query("page") int page);
}
