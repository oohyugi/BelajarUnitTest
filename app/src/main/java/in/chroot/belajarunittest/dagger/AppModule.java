package in.chroot.belajarunittest.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.chroot.belajarunittest.MainInterface;
import in.chroot.belajarunittest.MainPresenterImpl;

/**
 * Created by yogi on 27/03/17.
 */

@Module
public class AppModule {
    Application mApplication;
    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }
    @Provides
    @Singleton
    public Application provideApplication(){
        return mApplication;
    }
    @Provides
    @Singleton
    public MainInterface.Presenter
    provideMainPresenter(){
        return new MainPresenterImpl();
    }
}
