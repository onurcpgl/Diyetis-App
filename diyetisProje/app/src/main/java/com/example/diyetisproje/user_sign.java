package com.example.diyetisproje;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class user_sign extends AppCompatActivity {

    EditText adsoyad;
    EditText eposta;
    EditText sifre;
    Button  kayitbutton;
    TextView zatenhesap;

    FirebaseAuth yetki;
    DatabaseReference yol;
    ProgressDialog pd;
    FirebaseDatabase veriyetki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign);

        adsoyad=findViewById(R.id.kayit_ad);
        eposta=findViewById(R.id.kayit_eposta);
        sifre=findViewById(R.id.kayit_sifre);
        kayitbutton=findViewById(R.id.kayit_btn);
        zatenhesap=findViewById(R.id.textView10);

        yetki=FirebaseAuth.getInstance();
        veriyetki=FirebaseDatabase.getInstance();


        zatenhesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent girisactgit=new Intent(user_sign.this,user_login.class);
                startActivity(girisactgit);
            }
        });

        kayitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd=new ProgressDialog(user_sign.this);
                pd.setMessage("Lütfen bekleyin...");
                pd.show();



                String kullaniciadisoyadi=adsoyad.getText().toString();
                String kullanicieposta=eposta.getText().toString();
                String kullanicisifre=sifre.getText().toString();

                if(TextUtils.isEmpty(kullaniciadisoyadi) || TextUtils.isEmpty(kullanicieposta) || TextUtils.isEmpty(kullanicisifre))
                {
                    Toast.makeText(user_sign.this, "Lütfen bütün alanları doldurun !!!", Toast.LENGTH_SHORT).show();
                }else if(kullanicisifre.length()<6)
                {
                    Toast.makeText(user_sign.this, "Sifreniz minimum 6 karakter olmalı...", Toast.LENGTH_SHORT).show();
                }else{
                    //Yeni kullanıcı kaydetme kodlarını çağır.
                    kaydet(kullaniciadisoyadi,kullanicieposta,kullanicisifre);
                }
            }
        });



    }
    private void kaydet(String kullaniciadi,String kullanicieposta,String kullanicisifre)
    {
        //Yeni kullanıcı kaydetme kodları
        yetki.createUserWithEmailAndPassword(kullanicieposta,kullanicisifre)
                .addOnCompleteListener(user_sign.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            FirebaseUser firebaseKullanici=yetki.getCurrentUser();


                            String kullaniciId=firebaseKullanici.getUid();

                            yol= FirebaseDatabase.getInstance().getReference().child("Kullanıcilar").child(kullaniciId);

                            HashMap<String,Object> hashMap=new HashMap<>();
                            hashMap.put("id",kullaniciId);
                            hashMap.put("adsoyad",kullaniciadi);
                            hashMap.put("eposta",kullanicieposta);
                            hashMap.put("resimurl","https://firebasestorage.googleapis.com/v0/b/diyetisveritabani.appspot.com/o/bosprofil.jpg?alt=media&token=d1b56b74-fda6-4cf1-b40e-04e4bb5dc1f0");

                            yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        pd.dismiss();

                                        Intent intent=new Intent(user_sign.this,profilayar.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    }
                                }
                            });

                        }
                        else
                        {
                            pd.dismiss();
                            Toast.makeText(user_sign.this, "Bu mail veya şifre ile daha önce hesap oluşturulmuş...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}