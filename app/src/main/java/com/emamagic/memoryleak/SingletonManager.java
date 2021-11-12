package com.emamagic.memoryleak;

import android.content.Context;

import java.lang.ref.WeakReference;

public class SingletonManager {

    private static SingletonManager singleton;
    private Context context;
//  way: 3  private WeakReference<Context> context;

    private SingletonManager(Context context) {
//   way: 3     this.context = new WeakReference<>(context);
        this.context = context;
    }

    public synchronized static SingletonManager getInstance(Context context) {
        if (singleton == null) {
            singleton = new SingletonManager(context);
        }
        return singleton;
    }

    public void destroy() {
        this.context = null;
    }
}