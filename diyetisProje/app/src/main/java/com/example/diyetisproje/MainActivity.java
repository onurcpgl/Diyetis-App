package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btn_giris;
    Button btn_kayit;
    TextView devamet;
    FirebaseUser currentUser;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_giris=findViewById(R.id.btn_giris);
        btn_kayit=findViewById(R.id.btn_kayit);
        devamet=findViewById(R.id.devamet);

        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();

        btn_giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent girisyap=new Intent(MainActivity.this,user_login.class);
                    startActivity(girisyap);
            }
        });
        btn_kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kayityap=new Intent(MainActivity.this,user_sign.class);
                startActivity(kayityap);
            }
        });
        devamet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent devam=new Intent(MainActivity.this,anasayfa.class);
                startActivity(devam);
            }
        });


    }

    @Override
    protected void onStart() {
        if(currentUser!=null)
        {
            Intent gitanaya=new Intent(MainActivity.this,anasayfa.class);
            startActivity(gitanaya);

        }
        super.onStart();
    }
}