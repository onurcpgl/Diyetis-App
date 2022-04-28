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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class user_login extends AppCompatActivity {

    TextView kayitoltext;
    EditText epostagiris;
    EditText sifregiris;
    Button girisbutton;

    FirebaseAuth girisyetkisi;
    FirebaseUser currentUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        kayitoltext=findViewById(R.id.kayit_ol_btn);
        girisbutton=findViewById(R.id.giris_btn);
        epostagiris=findViewById(R.id.giris_eposta);
        sifregiris=findViewById(R.id.giris_sifre);

        girisyetkisi=FirebaseAuth.getInstance();

        currentUser = girisyetkisi.getCurrentUser();

        //Kayit ol textine tıklandığında yapılacak işlemler.
        kayitoltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kayit ol sayfasına geçiş.
                Intent kayitsayfasi=new Intent(user_login.this,user_sign.class);
                startActivity(kayitsayfasi);
            }
        });

        girisbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pGiris=new ProgressDialog(user_login.this);
                pGiris.setMessage("Giriş Yapılıyor...");
                pGiris.show();

                String giris_eposta=epostagiris.getText().toString();
                String giris_sifre=sifregiris.getText().toString();
                if(TextUtils.isEmpty(giris_eposta) || TextUtils.isEmpty(giris_sifre))
                {
                    Toast.makeText(user_login.this, "Bütün alanları doldurun !", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //Giris yap komuıtları
                    girisyetkisi.signInWithEmailAndPassword(giris_eposta,giris_sifre)
                            .addOnCompleteListener(user_login.this, task -> {
                                if(task.isSuccessful())
                                {
                                    DatabaseReference yolGiris= FirebaseDatabase.getInstance().getReference()
                                            .child("Kullanıcilar").child(Objects.requireNonNull(girisyetkisi.getCurrentUser()).getUid());

                                    yolGiris.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                            pGiris.dismiss();

                                            Intent intent = new Intent(user_login.this,anasayfa.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            finish();//Geri tuşuna bastıgımızda aynı yere dönmesin diye.
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {
                                            pGiris.dismiss();
                                        }
                                    });

                                }
                                else
                                {
                                    pGiris.dismiss();
                                    Toast.makeText(user_login.this, "Giriş başarısız oldu..", Toast.LENGTH_LONG).show();

                                }
                            });

                }
            }
        });


    }
}