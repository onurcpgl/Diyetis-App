package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class diyetis_page3 extends AppCompatActivity {
    ImageButton map;
    ImageButton mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetis_page3);
        mesaj=findViewById(R.id.imageButton2);
        mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitmesaj=new Intent(diyetis_page3.this,mesaj_hakan.class);
                startActivity(gitmesaj);
            }
        });
        map=findViewById(R.id.imgbtnmap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(diyetis_page3.this,diy1_map.class);
                String data="ney";
                intent.putExtra("Key", data); //veri gönderiliyor
                startActivity(intent);
            }
        });
    }
}