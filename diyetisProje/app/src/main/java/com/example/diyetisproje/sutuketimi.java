package com.example.diyetisproje;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

public class sutuketimi extends AppCompatActivity {
    ImageButton bardak1;
    ImageButton bardak2;
    ImageButton bardak3;
    ImageButton bardak4;
    ImageButton bardak5;
    ImageButton bardak6;
    ImageButton bardak7;
    ImageButton bardak8;
    ImageButton bardak9;
    ImageButton bardak10;
    ImageButton bardak11;
    ImageButton bardak12;
    double toplam=0;
    Button kaydet;
    Button sıfırla;
    TextView hedef;
    TextView tukeliten;

    FirebaseDatabase veritabani;
    FirebaseUser currentUser;
    FirebaseAuth yetki;
    DatabaseReference veriyolu;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sutuketimi);
            //VERİTABANI
        yetki= FirebaseAuth.getInstance();
        currentUser=yetki.getCurrentUser();

        FirebaseUser firebaseKullanici=yetki.getCurrentUser();


        String kullaniciId=firebaseKullanici.getUid();

        veritabani= FirebaseDatabase.getInstance();
        veriyolu=veritabani.getReference("KisiselBilgiler").child(kullaniciId).child("suhedefi");

        tukeliten=findViewById(R.id.txtv2);

        //Bardak ***********
        bardak1=findViewById(R.id.bardak1);
        bardak1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak1.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak1.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });


        //Bardak ***********
        bardak2=findViewById(R.id.bardak2);
        bardak2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak2.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak2.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });







//Bardak ***********
        bardak3=findViewById(R.id.bardak3);
        bardak3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak3.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak3.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });

//Bardak ***********
        bardak4=findViewById(R.id.bardak4);
        bardak4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak4.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak4.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });

//Bardak ***********
        bardak5=findViewById(R.id.bardak5);
        bardak5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak5.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak5.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });

//Bardak ***********
        bardak6=findViewById(R.id.bardak6);
        bardak6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak6.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak6.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });



//Bardak ***********
        bardak7=findViewById(R.id.bardak7);
        bardak7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak7.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak7.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });


//Bardak ***********
        bardak8=findViewById(R.id.bardak8);
        bardak8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak8.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak8.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });



//Bardak ***********
        bardak9=findViewById(R.id.bardak9);
        bardak9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak9.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak9.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });



//Bardak ***********
        bardak10=findViewById(R.id.bardak10);
        bardak10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak10.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak10.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });



//Bardak ***********
        bardak11=findViewById(R.id.bardak11);
        bardak11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak11.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;
            }
        });

        bardak11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak11.setImageResource(R.drawable.dolu);
                toplam=toplam+1;
            }
        });


//Bardak ***********
        bardak12=findViewById(R.id.bardak12);
        bardak12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                bardak12.setImageResource(R.drawable.bos);
                toplam=toplam-1;
                return true;

            }
        });

        bardak12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bardak12.setImageResource(R.drawable.dolu);

                toplam=toplam+1;
            }
        });

        kaydet=findViewById(R.id.button2);
        sıfırla=findViewById(R.id.button3);


        hedef=findViewById(R.id.txtv1);
        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hedef.setText("Tuketilen "+toplam*(0.2)+"ml");
            }
        });

        sıfırla.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                toplam=0;
                hedef.setText("Tuketilen "+toplam+"ml");
                bardak1.setImageResource(R.drawable.bos);
                bardak2.setImageResource(R.drawable.bos);
                bardak3.setImageResource(R.drawable.bos);
                bardak4.setImageResource(R.drawable.bos);
                bardak5.setImageResource(R.drawable.bos);
                bardak6.setImageResource(R.drawable.bos);
                bardak7.setImageResource(R.drawable.bos);
                bardak8.setImageResource(R.drawable.bos);
                bardak9.setImageResource(R.drawable.bos);
                bardak10.setImageResource(R.drawable.bos);
                bardak11.setImageResource(R.drawable.bos);
                bardak12.setImageResource(R.drawable.bos);
            }
        });




    }

    @Override
    protected void onStart() {
        veriyolu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String hedefsuyuvt=snapshot.getValue().toString();
                tukeliten.setText("Hedef :"+hedefsuyuvt);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}