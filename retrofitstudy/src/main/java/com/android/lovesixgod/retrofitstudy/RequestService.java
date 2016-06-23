package com.android.lovesixgod.retrofitstudy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jaceli on 2016-06-23.
 */
public interface RequestService {

    @GET("realtime")
    Call<String> getString(@Query("cityId") String cityId);
}
