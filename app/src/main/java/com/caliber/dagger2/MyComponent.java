package com.caliber.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Caliber on 09-04-2018.
 */
@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
}
