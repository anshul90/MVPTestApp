package com.mvptestapp.core;

import com.mvptestapp.model.Row;

import java.util.ArrayList;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     */
    interface presenter {

        //To call web service
        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetRowInteractorImpl class
     **/
    interface MainView {

        //To show progress bar
        void showProgress();

        //To hide progress bar
        void hideProgress();

        //To show data into list
        void setDataToRecyclerView(ArrayList<Row> rowArrayList);

        //To update title of action bar
        void setActionBarTitle(String actionBarTitle);

        //To display failure message if API call gets failed
        void onResponseFailure(Throwable throwable);

    }

    /**
     * Interactors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetRowInteractor {

        void getRowArrayList(OnFinishedListener onFinishedListener);

        interface OnFinishedListener {
            void onFinished(ArrayList<Row> rowArrayList, String title);

            //If API gets failure
            void onFailure(Throwable t);
        }
    }
}
