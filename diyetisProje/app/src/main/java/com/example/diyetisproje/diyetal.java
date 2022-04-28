package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class diyetal extends AppCompatActivity {

    ImageButton diyetal1;
    ImageButton diyetal2;
    ImageButton diyetal3;
    ImageButton diyetal4;
    ImageButton diyetal5;
    ImageButton diyetal6;
    ImageButton diyetal7;
    ImageButton diyetal8;
    ImageButton diyetal9;
    ImageButton diyetal10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetal);

        diyetal1=findViewById(R.id.diyet1);
        diyetal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git1=new Intent(diyetal.this,diyet1page.class);
                startActivity(git1);

            }
        });

        diyetal2=findViewById(R.id.diyet2);
        diyetal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git2=new Intent(diyetal.this,diyet2page.class);
                startActivity(git2);
            }
        });

        diyetal3=findViewById(R.id.diyet3);
        diyetal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git3=new Intent(diyetal.this,diyet3page.class);
                startActivity(git3);
            }
        });
        diyetal4=findViewById(R.id.diyet4);
        diyetal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git4=new Intent(diyetal.this,diyet4page.class);
                startActivity(git4);
            }
        });
        diyetal5=findViewById(R.id.diyet5);
        diyetal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git5=new Intent(diyetal.this,diyet5page.class);
                startActivity(git5);
            }
        });
        diyetal6=findViewById(R.id.diyet6);
        diyetal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git6=new Intent(diyetal.this,diyet6page.class);
                startActivity(git6);
            }
        });
        diyetal7=findViewById(R.id.diyet7);
        diyetal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git7=new Intent(diyetal.this,diyet7page.class);
                startActivity(git7);
            }
        });
        diyetal8=findViewById(R.id.diyet8);
        diyetal8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git8=new Intent(diyetal.this,diyet8page.class);
                startActivity(git8);
            }
        });
        diyetal9=findViewById(R.id.diyet9);
        diyetal9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git9=new Intent(diyetal.this,diyet9page.class);
                startActivity(git9);
            }
        });
        diyetal10=findViewById(R.id.diyet10);
        diyetal10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git10=new Intent(diyetal.this,diyet10page.class);
                startActivity(git10);
            }
        });



    }


}