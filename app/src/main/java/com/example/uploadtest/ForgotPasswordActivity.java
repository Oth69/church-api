package com.example.uploadtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseAuth authProfile;

    private EditText editTextPwdResetEmail;

    private ProgressBar progressBar;

    private Button  buttonPwdReset;
    private final static String TAG = "ForgotPasswordActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        progressBar = findViewById(R.id.progressBar);
        editTextPwdResetEmail = findViewById(R.id.editText_password_reset_email);
        buttonPwdReset = findViewById(R.id.button_password_reset);

        buttonPwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email = editTextPwdResetEmail.getText().toString();

              if(TextUtils.isEmpty(email)){
                  Toast.makeText(ForgotPasswordActivity.this,"Please enter your registered email",Toast.LENGTH_LONG).show();
                  editTextPwdResetEmail.setError("EMail is required");
                  editTextPwdResetEmail.requestFocus();
              }else{
                  progressBar.setVisibility(View.VISIBLE);
                  resetPassword(email);
              }
            }
        });


    }

    private void resetPassword(String email) {
        authProfile = FirebaseAuth.getInstance();
        authProfile.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
        if(task.isSuccessful()){
            Toast.makeText(ForgotPasswordActivity.this,"Please check your inbox for password reset link",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(ForgotPasswordActivity.this,ChangePasswordActivity.class);
            //clear stack
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();//close user profile
        } else {
            try{
                throw task.getException();
            }catch (FirebaseAuthInvalidUserException e){
                editTextPwdResetEmail.setError("User does not exists or is no longer valid. Please register again.");
            }catch(Exception e){
                Log.e(TAG,e.getMessage());
                Toast.makeText(ForgotPasswordActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
                    progressBar.setVisibility(View.GONE);
            }
        });
    }


}