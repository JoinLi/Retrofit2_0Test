package com.ethanco.retrofit2_0test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity1 extends AppCompatActivity {
    String baseUrl = " http://abc.webbiao.com/postinterface/";
    List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getByRxJava();
        getByRxJavas();
    }

    private void getByRxJava() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Observable<CreditBean> creditGr = service.getCreditGr();
        Observable<CreditBean> creditQy = service.getCreditQy("xypjqy", "李");
        Observable.merge(creditGr, creditQy)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CreditBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i("zhk-MainActivity", "onCompleted: ");
                        Toast.makeText(getApplicationContext(),
                                "Completed",
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("zhk-MainActivity", "onError: ", e);
                        Toast.makeText(getApplicationContext(),
                                "Error:" + e.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onNext(CreditBean creditBean) {
                        for (int i = 0; i < creditBean.getMydata().size(); i++) {
                            String credit = creditBean.getMydata().get(i).getUser_cname();
                            Log.i("zhk-MainActivity", credit);
                            list.add(credit);
                        }


                        Log.i("zhk-MainActivity", list.toString());

                    }

//                    @Override
//                    public void onNext(Weather weather) {
//                        Weather.ResultEntity.TodayEntity todayEntiry = weather.getResult().getToday();
//                        Log.i("zhk-MainActivity", "onNext: 城市:" + todayEntiry.getCity() + " 温度:" + todayEntiry.getTemperature());
//                        Toast.makeText(MainActivity1.this, "城市:" + todayEntiry.getCity() + " 温度:" + todayEntiry.getTemperature(), Toast.LENGTH_SHORT).show();
//                    }
                });
    }

    private void getByRxJavas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3g.gljlw.com/music/qq/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Observable<String> observable = service.getCtring();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("" + e);
                    }

                    @Override
                    public void onNext(String s) {
                        System.err.println("" + s);
                    }
                });
    }

}
