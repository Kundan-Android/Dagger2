package com.caliber.dagger2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Caliber on 09-04-2018.
 */
@Module
public class SharedPrefModule {
    private Context context;


    public SharedPrefModule(Context context) {
        this.context = context;
    }
    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }
    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
