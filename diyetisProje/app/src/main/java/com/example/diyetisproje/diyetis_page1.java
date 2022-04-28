package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class diyetis_page1 extends AppCompatActivity {
    ImageButton btn3;
    ImageButton mesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyetis_page1);
        mesaj=findViewById(R.id.imageButton2);

        mesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitmesaj=new Intent(diyetis_page1.this,mesaj_orkun.class);
                startActivity(gitmesaj);
            }
        });

        btn3=findViewById(R.id.imgbtnmap);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitmap=new Intent(diyetis_page1.this,diy1_map.class);
                String gitmapstring1="mey";
                gitmap.putExtra("Key",gitmapstring1);
                startActivity(gitmap);

            }
        });
    }
}