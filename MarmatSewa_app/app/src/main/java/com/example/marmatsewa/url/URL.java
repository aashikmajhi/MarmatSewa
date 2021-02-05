package com.example.marmatsewa.url;

import android.os.StrictMode;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class URL {

    public static String token = "";
    public static String role = "";
    public static String user_id="";


    public static String BASE_URL = "http://10.0.2.2:3001/";
//    public static String BASE_URL = "http://10.1.1.46:3001/";

    //For connecting with mobile ...
//    private static String ipAddressOfYourHost = "192.168.0.113";
//    private static String ipAddressOfYourHost = " 10.1.10.148";
//    public static String BASE_URL =  "http://" + ipAddressOfYourHost + ":3001/api/";

    public static String IMAGE_BASE_URL = "http://10.0.2.2:3001/";

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
