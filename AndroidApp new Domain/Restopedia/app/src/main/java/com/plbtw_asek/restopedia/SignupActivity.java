package com.plbtw_asek.restopedia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.plbtw_asek.restopedia.API.ApiClient;
import com.plbtw_asek.restopedia.API.ApiInterface;
import com.plbtw_asek.restopedia.Model.StatusMessage;
import com.restopedia_team.restopedia.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    StatusMessage statusMessage;
    String API_KEY = "7cBXDawjrOECIlpMmz8n19";

    @Bind(R.id.input_username)
    EditText _usernameText;
    @Bind(R.id.input_password)
    EditText _passwordText;
    @Bind(R.id.input_reEnterPassword)
    EditText _reEnterPasswordText;
    @Bind(R.id.btn_signup)
    Button _signupButton;
    @Bind(R.id.link_login)
    TextView _loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String username = _usernameText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.

        progressDialog.dismiss();

        userRegister(username, password);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        Toast.makeText(getBaseContext(), "Sign Up Success", Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    public void onSignupFailed() {
        _signupButton.setEnabled(true);

        Toast.makeText(getBaseContext(), "Sign Up Failed", Toast.LENGTH_LONG).show();
    }

    public boolean validate() {
        boolean valid = true;

        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }

    void userRegister(String username, String password) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StatusMessage> call = apiService.signUp(username, password, API_KEY);
        call.enqueue(new Callback<StatusMessage>() {
            @Override
            public void onResponse(Call<StatusMessage> call, Response<StatusMessage> response) {
                statusMessage = response.body();
                Log.i("Success", "Sign Up Success");
                onSignupSuccess();
            }

            @Override
            public void onFailure(Call<StatusMessage> call, Throwable t) {
                Log.i("Failed", "Sign Up Failed");
                onSignupFailed();
            }
        });
    }
}
