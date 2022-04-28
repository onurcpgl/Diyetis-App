package com.example.diyetisproje;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class mesaj_ahmet extends AppCompatActivity {
    ScrollView myscroll;
    TextView mesajgoster;
    EditText mesajyaz;
    ImageButton gonder;

    //Firebase
    FirebaseAuth mYetki;
    FirebaseUser acıkkul;

    DatabaseReference kullaniciYolu,mesajAdi,grupmesajadiyolu,onlineKullanici,mesajyazankullanici;

    String aktifKullaniciId,aktifKullaniciAdi,aktifTarih,aktifZaman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesaj_ahmet);
        mesajgoster=findViewById(R.id.mesajgöster);
        mesajyaz=findViewById(R.id.mesajgirdisi);
        gonder=findViewById(R.id.mesajgönder_button);
        myscroll=findViewById(R.id.my_scroolview);

        onlineKullanici= FirebaseDatabase.getInstance().getReference().child("Mesaj").child("Ahmet").child("ad");
        mesajyazankullanici=FirebaseDatabase.getInstance().getReference().child("Kullanıcilar").child("ad");
        //Firebase tanımlama
        mYetki=FirebaseAuth.getInstance();
        acıkkul=mYetki.getCurrentUser();
        aktifKullaniciId=mYetki.getCurrentUser().getUid();

        kullaniciYolu= FirebaseDatabase.getInstance().getReference().child("Kullanıcilar");
        mesajAdi= FirebaseDatabase.getInstance().getReference().child("Mesaj").child("Ahmet");

        //Kullanıcı bilgisi alma

        kullaniciBilgisiAlma();

        //Mesahı veri tabanına kayıt
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mesajiVeriTabaninaKaydet();
                mesajyaz.setText("");
                myscroll.fullScroll(myscroll.FOCUS_DOWN);
            }
        });

    }

    @Override
    protected void onStart() {
        mesajAdi.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists())
                {
                    mesajlarigoster(snapshot);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists())
                {
                    mesajlarigoster(snapshot);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }

    private void mesajlarigoster(DataSnapshot snapshot) {

        Iterator iteratorr=snapshot.getChildren().iterator();

        while(iteratorr.hasNext())
        {

            String kullaniciid=(String)((DataSnapshot)iteratorr.next()).getValue();
            String sohbetTarihi=(String)((DataSnapshot)iteratorr.next()).getValue();
            String sohbetMesaji=(String)((DataSnapshot)iteratorr.next()).getValue();
            String sohbetZamani=(String)((DataSnapshot)iteratorr.next()).getValue();

            mesajgoster.append(sohbetMesaji+"  "+sohbetZamani+"  "+kullaniciid+" \n "+sohbetTarihi+"\n\n\n\n");

            myscroll.fullScroll(myscroll.FOCUS_DOWN);

        }




    }

    private void mesajiVeriTabaninaKaydet() {
        String mesaj=mesajyaz.getText().toString();
        String mesajAnahtariYolu=mesajAdi.push().getKey();
        if (TextUtils.isEmpty(mesaj))
        {
            Toast.makeText(this, "Mesaj alanı boş olamaz", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Calendar tarihİcinTak = Calendar.getInstance();
            SimpleDateFormat aktifTarihFormati=new SimpleDateFormat("MMM dd, yyyy");
            aktifTarih=aktifTarihFormati.format(tarihİcinTak.getTime());

            Calendar zamanİcinTak = Calendar.getInstance();
            SimpleDateFormat aktifZamanFormati=new SimpleDateFormat("hh:mm:ss");
            aktifZaman=aktifZamanFormati.format(zamanİcinTak.getTime());

            HashMap<String,Object> mesajAnahtari=new HashMap<>();
            mesajAdi.updateChildren(mesajAnahtari);

            grupmesajadiyolu=mesajAdi.child(mesajAnahtariYolu);

            HashMap<String,Object> mesajbilgisiMap=new HashMap<>();
            mesajbilgisiMap.put("ad",aktifKullaniciAdi);
            mesajbilgisiMap.put("mesaj",mesaj);
            mesajbilgisiMap.put("tarih",aktifTarih);
            mesajbilgisiMap.put("zaman",aktifZaman);

            grupmesajadiyolu.updateChildren(mesajbilgisiMap);

        }
    }

    private void kullaniciBilgisiAlma() {
        kullaniciYolu.child(aktifKullaniciId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    aktifKullaniciAdi=snapshot.child("adsoyad").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}