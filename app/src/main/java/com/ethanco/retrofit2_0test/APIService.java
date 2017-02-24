package com.ethanco.retrofit2_0test;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Zhk on 2015/12/20.
 */
public interface APIService {
    @GET("weather")
    Call<Weather> loadeather(@Query("cityname") String cityname, @Query("key") String apiKey);

    /**
     * retrofit 支持 rxjava 整合
     * 这种方法适用于新接口
     */
    @GET("weather")
    Observable<Weather> getWeatherData(@Query("cityname") String cityname, @Query("key") String apiKey);

    //    http://abc.webbiao.com/postinterface/getAPI.aspx?ac=xypjgr&keywords=
//    http://abc.webbiao.com/postinterface/getAPI.aspx?ac=xypjqy&keywords=李
    @GET("getAPI.aspx")
    Observable<CreditBean> getCreditQy(@Query("ac") String ac, @Query("keywords") String keywords);

    @GET("getAPI.aspx?ac=xypjgr&keywords=")
    Observable<CreditBean> getCreditGr();

    @GET("search.php?keywords=张杰&page=1")
    Observable<String> getCtring();
}
