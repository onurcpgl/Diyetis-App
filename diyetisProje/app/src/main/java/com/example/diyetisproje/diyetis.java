package com.example.diyetisproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class diyetis extends AppCompatActivity {

    ImageButton diy1;
    ImageButton diy2;
    ImageButton diy3;
    ImageButton diy4;
    ImageButton diy5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetis);

        diy1=findViewById(R.id.diyet1);
        diy2=findViewById(R.id.diyet2);
        diy3=findViewById(R.id.diyet3);
        diy4=findViewById(R.id.diyet4);
        diy5=findViewById(R.id.diyet5);

        diy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git1=new Intent(diyetis.this,diyetis_page1.class);
                startActivity(git1);
            }
        });
        diy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git2=new Intent(diyetis.this,diyetis_page2.class);
                startActivity(git2);
            }
        });
        diy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git3=new Intent(diyetis.this,diyetis_page3.class);
                startActivity(git3);
            }
        });
        diy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git4=new Intent(diyetis.this,diyetis_page4.class);
                startActivity(git4);
            }
        });
        diy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git5=new Intent(diyetis.this,diyetis_page5.class);
                startActivity(git5);
            }
        });




    }
}