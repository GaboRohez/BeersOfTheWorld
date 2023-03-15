package com.gmail.gabow95k.beersoftheworld.ui.beers.presenter;

import com.gmail.gabow95k.beersoftheworld.base.BasePresenter;

public class BeersPresenter extends BasePresenter<BeersContract.View> implements BeersContract.Presenter {

    private BeersContract.Interactor interactor;

    public BeersPresenter(BeersContract.View view, BeersContract.Interactor interactor) {
        super(view);
        this.interactor = interactor;
    }

    @Override
    public void getBeersByApi(int page) {
        addSubscription(interactor.getBeers(page)
                .doOnSubscribe(disposable -> view.showLoader())
                .doAfterTerminate(() -> view.hideLoader())
                .subscribe(response -> {
                    if (response.isEmpty()) {
                        view.noBeers();
                    } else {
                        view.setBeers(response);
                    }
                }, throwable -> {
                    view.showErrorDialog(processError(throwable));
                }));
    }
}
