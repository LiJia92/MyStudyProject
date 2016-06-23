package com.android.lovesixgod.retrofitstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.send_request);

        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://weatherapi.market.xiaomi.com/wtr-v2/temp/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build();
                RequestService requestService = retrofit.create(RequestService.class);
                Call<String> call = requestService.getString("101010100");
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("TAG", "成功：" + response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("TAG", "失败");
                    }
                });

            }
        });
    }
}
