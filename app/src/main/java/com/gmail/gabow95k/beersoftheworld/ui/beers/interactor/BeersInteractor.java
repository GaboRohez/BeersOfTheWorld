package com.gmail.gabow95k.beersoftheworld.ui.beers.interactor;

import com.gmail.gabow95k.beersoftheworld.api.BeerEndPoint;
import com.gmail.gabow95k.beersoftheworld.api.RetrofitClient;
import com.gmail.gabow95k.beersoftheworld.model.Beer;
import com.gmail.gabow95k.beersoftheworld.ui.beers.presenter.BeersContract;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BeersInteractor implements BeersContract.Interactor {
    @Override
    public Single<List<Beer>> getBeers(int page) {
        return RetrofitClient.getInstance().retrofit
                .create(BeerEndPoint.class)
                .getBeers(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
