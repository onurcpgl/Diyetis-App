package com.example.diyetisproje;

import java.text.NumberFormat;

public class hesapla {
    private float s1,s2,sonuc;


    public hesapla(int sayi1,int sayi2)
    {
        this.s1=sayi1;
        this.s2=sayi2;
    }

    public String bkehesapla()
    {
        NumberFormat nf=NumberFormat.getInstance();
        nf.setMinimumFractionDigits(1);
        sonuc=((s2*1000)/(s1*s1))*10;
        String sayi=nf.format(sonuc);
        return sayi;

    }
    public String bkeDeger()
    {
        String deger;
        if (sonuc<18.4) deger="Zayıfsınız.";
        else if(sonuc<24.9) deger="Normal.";
        else if(sonuc<29.9) deger="Fazla Kilolusunuz.";
        else if(sonuc<34.9) deger="Şişman birinci derece obez.";
        else if(sonuc<44.9) deger="Şişman ikinci derece obez.";
        else deger="Aşırı şişman üçüncü derece obez.";

        return deger;
    }
}
