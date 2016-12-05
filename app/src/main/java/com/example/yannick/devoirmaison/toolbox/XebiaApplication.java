package com.example.yannick.devoirmaison.toolbox;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by yannick on 07/11/2016.
 */

public class XebiaApplication extends Application {

    private RequestQueue mVolleyRequestQueue;
    private ImageLoader mVolleyImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        // On initialise notre Thread-Pool et notre ImageLoader
        mVolleyRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new BitmapLruCache());
        mVolleyRequestQueue.start();
    }

    public RequestQueue getVolleyRequestQueue() {
        return mVolleyRequestQueue;
    }

    public ImageLoader getVolleyImageLoader() {
        return mVolleyImageLoader;
    }

    @Override
    public void onTerminate() {
        mVolleyRequestQueue.stop();
        super.onTerminate();
    }
}