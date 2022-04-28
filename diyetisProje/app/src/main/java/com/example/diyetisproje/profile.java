package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView kadisoyadi;
    TextView boy;
    TextView kilo;
    TextView bmi;


//veri tabanı
    FirebaseDatabase veritabani;
    FirebaseUser currentUser;
    FirebaseAuth yetki;
    DatabaseReference veriyolu,veriyolu2,veriyolu3,veriyolu4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);






        kadisoyadi=findViewById(R.id.kadisoyadi);
        boy=findViewById(R.id.boy);
        kilo=findViewById(R.id.kilo);
        bmi=findViewById(R.id.bmi);




        yetki=FirebaseAuth.getInstance();
        currentUser=yetki.getCurrentUser();

        FirebaseUser firebaseKullanici=yetki.getCurrentUser();


        String kullaniciId=firebaseKullanici.getUid();

        veritabani=FirebaseDatabase.getInstance();
        veriyolu=veritabani.getReference("Kullanıcilar").child(kullaniciId).child("adsoyad");
        veriyolu2=veritabani.getReference("KisiselBilgiler").child(kullaniciId).child("boy");
        veriyolu3=veritabani.getReference("KisiselBilgiler").child(kullaniciId).child("kilo");
        veriyolu4 = veritabani.getReference("BMİ").child(kullaniciId);






    }




    @Override
    protected void onStart() {
        if(currentUser == null)
        {
            Intent welIntent=new Intent(profile.this,MainActivity.class);
            startActivity(welIntent);
            finish();
        }else
        {
            veriyolu.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String ad=snapshot.getValue(String.class);

                    kadisoyadi.setText(ad);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        veriyolu3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String kilovt=snapshot.getValue().toString();

                kilo.setText("Kilo : "+kilovt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        veriyolu2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String boyuvt=snapshot.getValue().toString();

                boy.setText("Boy : "+boyuvt);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        veriyolu4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String bmivt=snapshot.getValue().toString();

                bmi.setText("BMİ :"+bmivt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        super.onStart();
    }
}