package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class anasayfa extends AppCompatActivity {

    ImageButton quitbutton;
    ImageButton imagebtn1;
    ImageButton imagebtn5;
    ImageButton imagebtn4;
    ImageButton imagebtn7;
    ImageButton imagebtn6;
    ImageButton imagebtn2;
    ImageButton imagebtn3;
    FirebaseUser currentUser;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();

        imagebtn2=findViewById(R.id.menubar_btn2);
        imagebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git2=new Intent(anasayfa.this,profile.class);
                startActivity(git2);
            }
        });
        quitbutton=findViewById(R.id.menubar_quit);
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(anasayfa.this, "Çıkış Başarılı !", Toast.LENGTH_SHORT).show();
            }
        });
        imagebtn3=findViewById(R.id.menubar_btn3);
        imagebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git3=new Intent(anasayfa.this,diyetal.class);
                startActivity(git3);
            }
        });
        imagebtn6=findViewById(R.id.menubar_btn6);
        imagebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git6=new Intent(anasayfa.this,message.class);
                startActivity(git6);
            }
        });

        imagebtn7=findViewById(R.id.menubar_btn7);
        imagebtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git7=new Intent(anasayfa.this,besinkaloritablo.class);
                startActivity(git7);
            }
        });

        imagebtn4=findViewById(R.id.menubar_btn4);
        imagebtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git4=new Intent(anasayfa.this,sutuketimi.class);
                startActivity(git4);
            }
        });

        imagebtn1=findViewById(R.id.menubar_btn1);
        imagebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git2=new Intent(anasayfa.this,BKE.class);
                startActivity(git2);
            }
        });
        imagebtn5=findViewById(R.id.menubar_btn5);
        imagebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git5=new Intent(anasayfa.this,diyetis.class);
                startActivity(git5);
            }
        });

    }
}