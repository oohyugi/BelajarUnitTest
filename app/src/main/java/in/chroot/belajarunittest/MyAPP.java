package in.chroot.belajarunittest;

import android.app.Application;

import in.chroot.belajarunittest.dagger.Injector;

/**
 * Created by yogi on 27/03/17.
 */

public class MyAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       Injector.initialize(this);

    }

}
