package in.chroot.belajarunittest;

/**
 * Created by yogi on 27/03/17.
 */

public class MainPresenterImpl implements MainInterface.Presenter<MainInterface.View> {

    MainInterface.View mView;

    @Override
    public void setView(MainInterface.View mView) {
        this.mView = mView;
    }

    @Override
    public boolean validateInputIsNotEmpty(String s) {
        return s.isEmpty();
    }

    @Override
    public void loginUsers(String username, String pass) {
        String userDummy = "android";
        String passDummy = "dokterdroid";
        if (validateInputIsNotEmpty(username) && validateInputIsNotEmpty(pass)) {
            mView.loginError("Username and password tidak boleh kosong");
        } else if (validateInputIsNotEmpty(username)) {
            mView.loginError("Username tidak boleh kosong");
        } else if (validateInputIsNotEmpty(pass)) {
            mView.loginError("Pass tidak boleh kosong");
        } else if (!username.equalsIgnoreCase(userDummy) || !pass.equalsIgnoreCase(passDummy)) {
            mView.loginError("Username salah atau Pass Salah");
        } else {
            mView.loginSucces("Login Sukses " + username);
        }
    }
}
