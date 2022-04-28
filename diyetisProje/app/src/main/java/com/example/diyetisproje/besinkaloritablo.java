package com.example.diyetisproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class besinkaloritablo extends AppCompatActivity {
    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> chapterList;
    HashMap<String,List<String>> topicList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_besinkaloritablo);

        expandableListView = findViewById(R.id.expandList);
        showList();

        listViewAdapter = new ExpandableListViewAdapter(this,chapterList,topicList);
        expandableListView.setAdapter(listViewAdapter);

    }

    private void showList()
    {
        chapterList = new ArrayList<String>();
        topicList = new HashMap<String, List<String>>();

        chapterList.add("Meyveler");
        chapterList.add("Sebzeler");
        chapterList.add("Süt Ürünleri");
        chapterList.add("Et & Et Ürünleri");
        chapterList.add("Yemek & Ögünler");

        List<String> topic1=new ArrayList<>();
        topic1.add("Ahududu\t100g\t52 kcal\n\n" +
                "Akai\t100g\t70 kcal\n\n" +
                "Altın Çilek\t100g\t49 kcal\n\n" +
                "Ananas\t100g\t50 kcal\n\n" +
                "Armut\t100g\t57 kcal\n\n" +
                "Avokado\t100g\t160 kcal\n\n" +
                "Ayva\t100g\t57 kcal\n\n" +
                "Böğürtlen\t100g\t43 kcal\n\n" +
                "Dut\t100g\t43 kcal\n\n" +
                "Elma\t100g\t52 kcal\n\n" +
                "Elma Püresi\t100g\t68 kcal\n\n" +
                "Erik\t100g\t46 kcal\n\n" +
                "Frenk Üzümü\t100g\t56 kcal\n\n" +
                "Guava\t100g\t68 kcal\n\n" +
                "Hint Hurması\t100g\t239 kcal\n\n" +
                "Hurma\t100g\t282 kcal\n\n" +
                "İncir\t100g\t74 kcal\n\n" +
                "İri Muz\t100g\t122 kcal\n\n" +
                "Jackfruit (tayland meyvesi\t100g\t95 kcal\n\n" +
                "Kan Portakalı\t100g\t50 kcal\n\n" +
                "Kantalup Kavun\t100g\t34 kcal\n\n" +
                "Karpuz\t100g\t30 kcal\n\n" +
                "Kayısı\t100g\t48 kcal\n\n" +
                "Kiraz\t100g\t50 kcal\n\n" +
                "Kivi\t100g\t61 kcal\n\n" +
                "Klementin Mandalina\t100g\t47 kcal\n\n" +
                "Kuru Üzüm\t100g\t299 kcal\n\n" +
                "Kızılcık\t100g\t46 kcal\n\n" +
                "Limon\t100g\t29 kcal\n\n" +
                "Liçi (tropik bir meyve)\t100g\t66 kcal\n\n" +
                "Mandarin / Mandalina\t100g\t53 kcal\n\n" +
                "Mango\t100g\t60 kcal\n\n" +
                "Meyve Salatası\t100g\t50 kcal\n\n" +
                "Misket Limonu\t100g\t30 kcal\n\n" +
                "Muz\t100g\t89 kcal\n\n" +
                "Nar\t100g\t83 kcal\n\n" +
                "Nektarin\t100g\t44 kcal\n\n" +
                "Papaya\t100g\t43 kcal\n\n" +
                "Portakal\t100g\t47 kcal\n\n" +
                "Rambutan\t100g\t82 kcal\n\n" +
                "Trabzon Hurması\t100g\t127 kcal\n\n" +
                "Yabanmersini\t100g\t57 kcal\n\n" +
                "Yayla Muzu\t100g\t21 kcal\n\n" +
                "Yeşil Erik\t100g\t41 kcal\n\n" +
                "Yıldız Meyvesi\t100g\t31 kcal\n\n" +
                "Zeytin\t100g\t115 kcal\n\n" +
                "Çarkıfelek\t100g\t97 kcal\n\n" +
                "Çilek\t100g\t32 kcal\n\n" +
                "Üzüm\t100g\t69 kcal\n\n" +
                "Şeftali\t100g\t39 kcal");


        List<String> topic2=new ArrayList<>();

        topic2.add("Acur\t100g\t14 kcal\n\n" +
                "Acı Marul\t100g\t17 kcal\n\n" +
                "Bamya\t100g\t33 kcal\n\n" +
                "Bayırturpu\t100g\t48 kcal\n\n" +
                "Bebek Soğan\t100g\t72 kcal\n" +
                "Bezelye\t100g\t81 kcal\n\n" +
                "Biber\t100g\t27 kcal\n\n" +
                "Brokoli\t100g\t34 kcal\n\n" +
                "Brüksel Lahanası\t100g\t43 kcal\n\n" +
                "Deniz Börülcesi\t100g\t133 kcal\n\n" +
                "Dolmalık Kabak\t100g\t17 kcal\n\n" +
                "Domates\t100g\t18 kcal\n\n" +
                "Enginar\t100g\t47 kcal\n\n" +
                "Frenksoğanu\t100g\t30 kcal\n\n" +
                "Hardal Otu\t100g\t27 kcal\n\n" +
                "Havuz\t100g\t41 kcal\n\n" +
                "Hindiba\t100g\t72 kcal\n\n" +
                "Ispanak\t100g\t23 kcal\n\n" +
                "Ispanak Ezmesi\t100g\t74 kcal\n\n" +
                "Kabak\t100g\t26 kcal\n\n" +
                "Kara Lahana\t100g\t32 kcal\n\n" +
                "Karnabahar\t100g\t25 kcal\n\n" +
                "Kereviz\t100g\t16 kcal\n\n" +
                "Kuşkonmaz\t100g\t20 kcal\n\n" +
                "Kırmızı Biber\t100g\t27 kcal\n\n" +
                "Kırmızı Kabak\t100g\t31 kcal\n\n" +
                "Kırmızı Pancar\t100g\t43 kcal\n\n" +
                "Kırmızı Turp\t100g\t16 kcal\n\n" +
                "Kıvırcık Lahana\t100g\t49 kcal\n\n" +
                "Lahana\t100g\t25 kcal\n\n" +
                "Mantar\t100g\t22 kcal\n\n" +
                "Marul\t100g\t15 kcal\n\n" +
                "Mısır\t100g\t365 kcal\n\n" +
                "Nori Denizyosunu\t100g\t35 kcal\n\n" +
                "Patates\t100g\t77 kcal\n\n" +
                "Patlıcan\t100g\t25 kcal\n\n" +
                "Pazı\t100g\t19 kcal\n\n" +
                "Pırasa\t100g\t61 kcal\n\n" +
                "Rezene\t100g\t31 kcal\n\n" +
                "Roka\t100g\t25 kcal\n\n" +
                "Salatalık\t100g\t16 kcal\n\n" +
                "Sarımsak\t100g\t149 kcal\n\n" +
                "Siyah Zeytin\t100g\t115 kcal\n\n" +
                "Soğan\t100g\t40 kcal\n\n" +
                "Su Kabağı\t100g\t14 kcal\n\n" +
                "Tatlı Patates\t100g\t86 kcal\n\n" +
                "Turp\t100g\t28 kcal\n\n" +
                "Wasabi\t100g\t109 kcal\n\n" +
                "Yabani Havuç\t100g\t75 kcal\n\n" +
                "Yapraklı Turp\t100g\t20 kcal\n\n" +
                "Yer Lahanası\t100g\t27 kcal\n\n" +
                "Yeşil Fasulye\t100g\t31 kcal\n\n" +
                "Yeşil Soğan\t100g\t32 kcal\n\n" +
                "Yeşil Zeytin\t100g\t115 kcal\n\n" +
                "Zeytin\t100g\t115 kcal\n\n" +
                "Çin Kabağı\t100g\t16 kcal\n\n" +
                "Şalgam\t100g\t38 kcal\n\n" +
                "Şeri Domates\t100g\t100 kcal\n\n" +
                "Şevketibostan\t100g\t158 kcal");



        List<String> topic3=new ArrayList<>();

        topic3.add("Ayran\t100g\t34 kcal\n\n" +
                "Az Yağlı Süt\t100g\t35 kcal\n\n" +
                "Badem Sütü\t100g\t17 kcal\n\n" +
                "Cacık\t100g\t117 kcal\n\n" +
                "Ekşi Krema\t100g\t181 kcal\n\n" +
                "Fraiche Kreması\t100g\t393 kcal\n\n" +
                "Hindistan Cevizi Sütü\t100g\t230 kcal\n\n" +
                "İrmikli Puding\t100g\t67 kcal\n\n" +
                "Kahve Kreması\t100g\t195 kcal\n\n" +
                "Kefir\t100g\t55 kcal\n\n" +
                "Kesilmiş Süt\t100g\t98 kcal\n\n" +
                "Keçi Sütü\t100g\t69 kcal\n\n" +
                "Krema\t100g\t242 kcal\n\n" +
                "Kremşanti\t100g\t257 kcal\n\n" +
                "Laktozsuz Süt\t100g\t52 kcal\n\n" +
                "Lassi\t100g\t75 kcal\n\n" +
                "Pirinç Sütü\t100g\t49 kcal\n\n" +
                "Soya Sütü\t100g\t45 kcal\n\n" +
                "Süt\t100g\t61 kcal\n\n" +
                "Süt Tozu\t100g\t496 kcal\n\n" +
                "Sütlaç\t100g\t118 kcal\n\n" +
                "Süzme Peynir\t100g\t98 kcal\n\n" +
                "Sıcak Çikolata\t100g\t89 kcal\n\n" +
                "Tam Yağlı Süt\t100g\t61 kcal\n\n" +
                "Tatlandırılmış Yoğun Süt\t100g\t321 kcal\n\n" +
                "Yarım Yağlı Süt\t100g\t50 kcal\n\n" +
                "Yayık Ayranı\t100g\t62 kcal\n\n" +
                "Yoğunlaştırılmış Süt\t100g\t321 kcal\n\n" +
                "Yoğurt\t100g\t61 kcal\n\n" +
                "Çikolata Mousse\t100g\t225 kcal");

        List<String> topic4=new ArrayList<>();

        topic4.add("Antrikot\t100g\t121 kcal\n\n" +
                "Biftek Döş\t100g\t242 kcal\n\n" +
                "Bonfile\t100g\t138 kcal\n\n" +
                "Dana Kıyması\t100g\t246 kcal\n\n" +
                "Devekuşu\t100g\t145 kcal\n\n" +
                "Domuz Budu\t100g\t163 kcal\n\n" +
                "Domuz Eti\t100g\t196 kcal\n\n" +
                "Domuz Geri Kaburga\t100g\t212 kcal\n\n" +
                "Domuz Kontrfile\t100g\t204 kcal\n\n" +
                "Domuz Pirzolası\t100g\t196 kcal\n\n" +
                "Domuz Rostosu\t100g\t254 kcal\n\n" +
                "Domuz Steak\t100g\t196 kcal\n\n" +
                "Fleminyon\t100g\t267 kcal\n\n" +
                "Gerdan Steak\t100g\t277 kcal\n\n" +
                "Hindi\t100g\t189 kcal\n\n" +
                "Hindi Budu\t100g\t208 kcal\n\n" +
                "Hindi Göğsü\t100g\t135 kcal\n\n" +
                "Hindi Kanadı\t100g\t221 kcal\n\n" +
                "Hindi Steak\t100g\t189 kcal\n\n" +
                "Kaburga\t100g\t238 kcal\n\n" +
                "Kaburga Rosto\t100g\t333 kcal\n\n" +
                "Kontrfile\t100g\t163 kcal\n\n" +
                "Kuzu İncik\t100g\t201 kcal\n\n" +
                "Kuzu Pirzola\t100g\t276 kcal\n\n" +
                "Pançeta\t100g\t194 kcal\n\n" +
                "Rozbif\t100g\t140 kcal\n\n" +
                "Sığır Eti\t100g\t248 kcal\n\n" +
                "Sığır Filetosu\t100g\t218 kcal\n\n" +
                "Sığır Kaburgası\t100g\t238 kcal\n\n" +
                "T-Bone Steak\t100g\t202 kcal\n\n" +
                "Tavuk\t100g\t219 kcal\n\n" +
                "Tavuk Butu\t100g\t174 kcal\n\n" +
                "Tavuk Ciğeri\t100g\t167 kcal\n\n" +
                "Tavuk Eti\t100g\t172 kcal\n\n" +
                "Tavuk Göğsü\t100g\t172 kcal\n\n" +
                "Tavuk İç Organları\t100g\t158 kcal\n\n" +
                "Tavuk Kanadı\t100g\t266 kcal\n\n" +
                "Tavuk Taşlığı\t100g\t146 kcal\n\n" +
                "Tavuk Yağı\t100g\t898 kcal\n\n" +
                "Tranç\t100g\t182 kcal\n\n" +
                "Ördek\t100g\t337 kcal\n\n" +
                "Şinitzel\t100g\t156 kcal");

        List<String> topic5=new ArrayList<>();

        topic5.add("Bezelye Çorbası\t100g\t75 kcal\n\n" +
                "Bulgur Pilavı\t100g\t215 kcal\n\n" +
                "Burrito (Meksika Dürümü)\t100g\t163 kcal\n\n" +
                "Chili con Carne (Kıymalı Fasulye)\t100g\t105 kcal\n\n" +
                "Dal Makhani (Hint Bezelye Yemeği\t100g\t330 kcal\n\n" +
                "Domuz Pirzola\t100g\t225 kcal\n\n" +
                "Enchilada\t100g\t168 kcal\n\n" +
                "Esmer Pirinç\t100g\t362 kcal\n\n" +
                "Fajita\t100g\t117 kcal\n\n" +
                "Fish and Chips\t100g\t195 kcal\n\n" +
                "Fırında Kurufasulye\t100g\t94 kcal\n\n" +
                "Fırında Tavuk\t100g\t164 kcal\n\n" +
                "Humus\t100g\t177 kcal\n\n" +
                "Hünkar Beğendi\t100g\t174 kcal\n\n" +
                "Karnıyarık\t100g\t134 kcal\n\n" +
                "Kebap\t100g\t215 kcal\n\n" +
                "Kuzu Tandır\t100g\t150 kcal\n\n" +
                "Kıymalı Dolma\t100g\t114 kcal\n\n" +
                "Kıymalı/Etli Pide\t100g\t297 kcal\n\n" +
                "Kızarmış Pirinç\t100g\t186 kcal\n\n" +
                "Lazanya\t100g\t132 kcal\n\n" +
                "Makarna ve Peynir\t100g\t370 kcal\n\n" +
                "Paella\t100g\t156 kcal\n\n" +
                "Patates Püresi\t100g\t83 kcal\n\n" +
                "Patates Salatası\t100g\t143 kcal\n\n" +
                "Pekin Ördeği\t100g\t225 kcal\n\n" +
                "Peynirli Pide\t100g\t275 kcal\n\n" +
                "Pilav\t100g\t352 kcal\n\n" +
                "Pizza\t100g\t267 kcal\n\n" +
                "Ravioli\t100g\t203 kcal\n\n" +
                "Rozbif\t100g\t111 kcal\n\n" +
                "Rulo Köfte\t100g\t254 kcal\n\n" +
                "Spagetti Bolonez\t100g\t132 kcal\n\n" +
                "Sığır Eti Güveci\t100g\t95 kcal\n\n" +
                "Taco\t100g\t217 kcal\n\n" +
                "Tandır Ekmeği\t100g\t310 kcal\n\n" +
                "Tavuklu Sezar Salata\t100g\t127 kcal\n\n" +
                "Yaprak Sarması\t100g\t141 kcal\n\n" +
                "Zeytinyağlı Dolma\t100g\t173 kcal\n\n" +
                "Zeytinyağlı Enginar\t100g\t166 kcal\n\n" +
                "Zeytinyağlı Kereviz\t100g\t66 kcal\n\n" +
                "Zeytinyağlı Taze Fasulye\t100g\t56 kcal\n\n" +
                "Çin Böreği\t100g\t250 kcal");

        topicList.put(chapterList.get(0),topic1);
        topicList.put(chapterList.get(1),topic2);
        topicList.put(chapterList.get(2),topic3);
        topicList.put(chapterList.get(3),topic4);
        topicList.put(chapterList.get(4),topic5);


    }

}