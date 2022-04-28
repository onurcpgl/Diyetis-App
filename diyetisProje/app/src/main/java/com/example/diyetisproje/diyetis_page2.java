package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class diyetis_page2 extends AppCompatActivity {
    ImageButton btn3;
    ImageButton mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetis_page2);
        mesaj=findViewById(R.id.imageButton2);
        mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitmesaj=new Intent(diyetis_page2.this,mesaj_ahmet.class);
                startActivity(gitmesaj);
            }
        });
        btn3=findViewById(R.id.imgbtnmap);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(diyetis_page2.this,diy1_map.class);
                String data="key";
                intent.putExtra("Key", data); //veri gönderiliyor
                startActivity(intent);



            }
        });
    }
}