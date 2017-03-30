package in.chroot.belajarunittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import in.chroot.belajarunittest.dagger.Injector;

public class MainActivity extends AppCompatActivity implements MainInterface.View {

    @Inject
    MainInterface.Presenter presenter;
    Button btLogin;
    EditText etUsername;
    EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.component.inject(this);
        presenter.setView(this);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_pass);
        btLogin =(Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginUsers(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });


    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucces(String username) {
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

    }
}
