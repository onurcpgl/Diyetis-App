package com.example.diyetisproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class profilayar extends AppCompatActivity {

    EditText boy;
    EditText kilo;
    EditText suhedef;
    Button kaydet;



    FirebaseAuth yetki;
    FirebaseDatabase database;
    DatabaseReference yol,yol2;
    FirebaseUser currentuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilayar);

        boy=findViewById(R.id.boy_ayar);
        suhedef=findViewById(R.id.suhedef_ayar);
        kilo=findViewById(R.id.kilo_ayar);
        kaydet=findViewById(R.id.button_ayar);


        //Firebase
        yetki=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();

        FirebaseUser firebaseKullanici=yetki.getCurrentUser();
        String kullaniciId=firebaseKullanici.getUid();

        yol2=database.getReference("BMİ").child(kullaniciId);

        yol=database.getReference("KisiselBilgiler").child(kullaniciId);



        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String boyu=boy.getText().toString();
                String kilosu=kilo.getText().toString();
                String suhedefim=suhedef.getText().toString();

                Integer boyum=Integer.parseInt(boy.getText().toString());
                Integer kilom=Integer.parseInt(kilo.getText().toString());
                    //Yeni kullanıcı kaydetme kodlarını çağır.
                    kaydet(boyu,kilosu,suhedefim);
                    hesapla hesap=new hesapla(boyum,kilom);
                    kaydetbmi(hesap.bkehesapla());


            }
        });

    }

    private void kaydetbmi(String bmi) {
        yol2.setValue(bmi);

    }

    private void kaydet(String boyu, String kilosu, String suhedefim) {

        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("boy",boyu);
        hashMap.put("kilo",kilosu);
        hashMap.put("suhedefi",suhedefim);

        yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Intent intent=new Intent(profilayar.this,anasayfa.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });


    }



}