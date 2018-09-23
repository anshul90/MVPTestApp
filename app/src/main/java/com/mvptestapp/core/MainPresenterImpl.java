package com.mvptestapp.core;

import com.mvptestapp.model.Row;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetRowInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetRowInteractor getRowInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetRowInteractor getRowInteractor) {
        this.mainView = mainView;
        this.getRowInteractor = getRowInteractor;
    }

    @Override
    public void requestDataFromServer() {
        //To make a network call to server
        if (mainView != null) {
            mainView.showProgress();
        }
        getRowInteractor.getRowArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<Row> rowArrayList, String title) {
        //To hide progress on getting data successfully and display into list
        if (mainView != null) {
            mainView.setDataToRecyclerView(rowArrayList);
            mainView.setActionBarTitle(title);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        //To hide progress bar and display message of failure
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
