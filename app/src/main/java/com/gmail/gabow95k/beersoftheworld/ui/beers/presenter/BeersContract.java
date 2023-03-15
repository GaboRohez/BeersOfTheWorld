package com.gmail.gabow95k.beersoftheworld.ui.beers.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BaseView;
import com.gmail.gabow95k.beersoftheworld.model.Beer;

import java.util.List;

import io.reactivex.Single;

public interface BeersContract {
    interface View extends BaseView {

        void noBeers();

        void setBeers(List<Beer> beers);
    }

    interface Presenter {

        void getBeersByApi(int page);
    }

    interface Interactor {

        Single<List<Beer>> getBeers(int page);
    }
}
