package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class diyetis_page5 extends AppCompatActivity {
    ImageButton map;
    ImageButton mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetis_page5);
        mesaj=findViewById(R.id.imageButton2);
        mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitmesaj=new Intent(diyetis_page5.this,mesaj_ayse.class);
                startActivity(gitmesaj);
            }
        });
        map=findViewById(R.id.imgbtnmap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(diyetis_page5.this,diy1_map.class);
                String data="yey";
                intent.putExtra("Key", data); //veri gönderiliyor
                startActivity(intent);
            }
        });
    }
}