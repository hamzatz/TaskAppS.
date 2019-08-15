package com.e.taskapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private EditText editPhone;
    private EditText editCountryCode;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editPhone=findViewById(R.id.editPhone);
        editCountryCode=findViewById(R.id.editCountryCode);
        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                singIn(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }
        };
    }

    private void singIn(PhoneAuthCredential phoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    Toast.makeText(LoginActivity.this,"Успешно",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void OnClickNext(View view) {
        String countryCode= editCountryCode.getText().toString().trim();
        String phone= countryCode + editPhone.getText().toString().trim();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,
                60, TimeUnit.SECONDS,this,callbacks);
    }
}
