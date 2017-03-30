package in.chroot.belajarunittest.dagger;

import android.app.Application;

/**
 * Created by yogi on 27/03/17.
 */

public class Injector {
    public static DiComponent component;
    public static DiComponent initialize(Application mApplication){
        component = DaggerDiComponent.builder()
                .appModule(new AppModule(mApplication))
                .build();
        return component;
    }

    public static DiComponent getComponent() {
        return component;
    }
}
