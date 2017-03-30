package in.chroot.belajarunittest;

/**
 * Created by yogi on 27/03/17.
 */

public interface MainInterface {


    interface View {
        void loginError(String message);
        void loginSucces(String username);
    }
    interface Presenter<V> extends BasePresenter<MainInterface.View>{
        boolean validateInputIsNotEmpty(String s);
        void loginUsers(String username, String pass);
    }
}
