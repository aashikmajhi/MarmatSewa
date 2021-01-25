package com.example.marmatsewa.url;

import android.os.StrictMode;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class URL {

    public static String token = "";
    public static String role = "";

<<<<<<< HEAD
   public static String BASE_URL = "http://10.0.2.2:3001/";
   // public static String BASE_URL = "http://10.20.15.102:3001/";
=======
    public static String BASE_URL = "http://10.0.2.2:3001/";
//    public static String BASE_URL = "http://10.1.14.43:3001";

>>>>>>> c6614ab3fa0a8efaacc7b7521d0e05519f024846

    public static Retrofit getInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static void getStrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
