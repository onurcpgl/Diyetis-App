package com.example.diyetisproje;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BKE extends AppCompatActivity {

    EditText textboy;
    EditText textkilo;
    Button hesapla;
    TextView textViewSonuc;

    FirebaseAuth yetki;
    FirebaseDatabase database;
    DatabaseReference yol;
    FirebaseUser currentuser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bke);

        hesapla=findViewById(R.id.hesapla);
        textboy=findViewById(R.id.editTextBoy);
        textkilo=findViewById(R.id.editTextKilo);
        textViewSonuc=findViewById(R.id.textViewSonuc);

        //Firebase

        yetki=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        currentuser=yetki.getCurrentUser();
        FirebaseUser firebaseKullanici=yetki.getCurrentUser();
        String kullaniciId=firebaseKullanici.getUid();

        yol=database.getReference("BMİ").child(kullaniciId);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                int s1= Integer.parseInt(textboy.getText().toString());
                int s2= Integer.parseInt(textkilo.getText().toString());
                hesapla hesap=new hesapla(s1,s2);
                closeKeyboard();
                hesap.bkehesapla();
                bmiVTkaydet(hesap.bkehesapla());

                textViewSonuc.setText("Vucut Kitle İndeksiniz:  "+hesap.bkehesapla()+"\n"+hesap.bkeDeger());
            }
        });


    }

    private void closeKeyboard() {
        View view=this.getCurrentFocus();
        if(view != null)
        {
            InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    private void bmiVTkaydet(String a) {
        yol.setValue(a);
    }

}