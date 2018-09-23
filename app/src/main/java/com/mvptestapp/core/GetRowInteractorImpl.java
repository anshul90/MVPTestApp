package com.mvptestapp.core;

import android.support.annotation.NonNull;

import com.mvptestapp.interfaces.ApiInterface;
import com.mvptestapp.model.ApiResponse;
import com.mvptestapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetRowInteractorImpl implements MainContract.GetRowInteractor {

    @Override
    public void getRowArrayList(final OnFinishedListener onFinishedListener) {

        /* Create handle for the RetrofitInstance interface */
        ApiInterface service = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        /* Call the method with parameter in the interface to get the data */
        Call<ApiResponse> call = service.getData();

        /* API Response callback */
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                try {
                    //When API returns data successfully
                    onFinishedListener.onFinished(response.body().getRows(), response.body().getTitle());
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, @NonNull Throwable t) {
                //If API call gets failed
                onFinishedListener.onFailure(t);
            }

        });

    }

}
