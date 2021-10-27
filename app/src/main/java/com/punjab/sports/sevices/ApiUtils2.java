package com.punjab.sports.sevices;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils2 { public static final String Appname = "Khedo Punjab";




    private static final String API_BASE_URL = "https://apipis.pbsports.in/api/Login/";


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson));

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);


    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder()
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS).retryOnConnectionFailure(false);

    private static Retrofit retrofit = builder.build();

    static Retrofit getRetrofit() {
        return retrofit;
    }



    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(
            Class<S> serviceClass, String username, String password) {
        if (!TextUtils.isEmpty(username)
                && !TextUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return createService(serviceClass, authToken);
        }

        return createService(serviceClass, null);
    }


    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        //   VersioningInterceptor interceptorVersioning = new VersioningInterceptor(Tools.getVersionName(),Tools.getLang());

       /* if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptorToken = new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptorToken)) {
                httpClient.addInterceptor(interceptorToken);
            }
        }
*/
        /*if (!httpClient.interceptors().contains(interceptorVersioning)) {
            httpClient.addInterceptor(interceptorVersioning);
        }*/


        httpClient.addInterceptor(logging);
        retrofit = builder.client(httpClient.build()).build();

        return retrofit.create(serviceClass);
    }
}
