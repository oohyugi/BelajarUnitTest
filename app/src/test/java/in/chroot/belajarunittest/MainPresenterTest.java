package in.chroot.belajarunittest;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by yogi on 27/03/17.
 */

public class MainPresenterTest {

    @Test
    public void createNewTestMainPresenter() {
        String username = "android";
        String pass = "dokterdroid";
        MainInterface.View mView = mock(MainInterface.View.class);
        MainPresenterImpl mainPresenter = new MainPresenterImpl();
        mainPresenter.setView(mView);
        mainPresenter.loginUsers(username, pass);
        verify(mView).loginSucces("Login Sukses " + username);


    }

    /**
     * Test Username and password salah
     */
    @Test
    public void checkWrongUsernameorpass() {
        String username = "androi";
        String pass = "dokterdroi";
        MainInterface.View mView = mock(MainInterface.View.class);
        MainPresenterImpl mainPresenter = new MainPresenterImpl();
        mainPresenter.setView(mView);
        mainPresenter.loginUsers(username, pass);
        verify(mView).loginError("Username salah atau Pass Salah");


    }
}