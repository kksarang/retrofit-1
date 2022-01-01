package com.example.a1stretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a1stretrofit.Interface.MyAPICall;
import com.example.a1stretrofit.Model.DataModel;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private String BASE_URL ="https://run.mocky.io/v3/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.title_txt);

        //Retrofit Builder

        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();


        //instance for interface

        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                //checking the response

                if (response.code() != 200 ) {
                    textView.setText("");
                    return;
                }

                //Get the data into textView

                String jsony ="";

                jsony="ID = "+response.body().getId()+
                        "\n TITLE ="+response.body().getTitle()+
                        "\n COMPLETED ="+response.body().isCompleted();

                textView.append(jsony );


            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });


    }



}