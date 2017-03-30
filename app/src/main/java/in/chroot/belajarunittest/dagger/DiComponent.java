package in.chroot.belajarunittest.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import in.chroot.belajarunittest.MainActivity;
import in.chroot.belajarunittest.MainPresenterImpl;

/**
 * Created by yogi on 27/03/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface DiComponent {
    void inject(MainActivity mainActivity);

}
