package com.caliber.dagger2;

import android.app.Application;
import android.content.Context;

/**
 * Created by Caliber on 13-04-2018.
 */

public class App extends Application {
    public MyComponent myComponent;

    public static MyComponent myComponent(Context context){
        App app = (App) context.getApplicationContext();
        return app.myComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myComponent = DaggerMyComponent.builder()
                .sharedPrefModule(new SharedPrefModule(this))
                .build();
    }
}
