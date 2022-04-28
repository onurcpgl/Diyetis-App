package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class message extends AppCompatActivity {

    ImageButton mesaj_diy1;
    ImageButton mesaj_diy2;
    ImageButton mesaj_diy3;
    ImageButton mesaj_diy4;
    ImageButton mesaj_diy5;

    FirebaseAuth auth;
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();


        mesaj_diy1=findViewById(R.id.diy_mes1);
        mesaj_diy2=findViewById(R.id.diy_mes2);
        mesaj_diy3=findViewById(R.id.diy_mes3);
        mesaj_diy4=findViewById(R.id.diy_mes4);
        mesaj_diy5=findViewById(R.id.diy_mes5);

        mesaj_diy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orkungit=new Intent(message.this,mesaj_orkun.class);
                startActivity(orkungit);
            }
        });
        mesaj_diy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ahmetgit=new Intent(message.this,mesaj_ahmet.class);
                startActivity(ahmetgit);
            }
        });
        mesaj_diy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hakangit=new Intent(message.this,mesaj_hakan.class);
                startActivity(hakangit);
            }
        });
        mesaj_diy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aysegit=new Intent(message.this,mesaj_ayse.class);
                startActivity(aysegit);
            }
        });
        mesaj_diy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sinemgit=new Intent(message.this,mesaj_sinem.class);
                startActivity(sinemgit);
            }
        });





    }

    @Override
    protected void onStart() {
        if(currentUser == null)
        {
            Intent welIntent=new Intent(message.this,MainActivity.class);
            startActivity(welIntent);
            finish();
        }
        super.onStart();
    }
}