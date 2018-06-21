package com.jsecode.zhan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jsecode.zhan.view.PhoneView;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

//    PhoneView phoneView;
//
   Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
//        phoneView = findViewById(R.id.view_phone);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(LoginActivity.this, phoneView.getPhoneText(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });



       // UserManger userManger = UserManger.getInstance(this);

//        Intent intent = new Intent(this,TestActivity.class);
//        startActivity(intent);



    }
}

