package com.lusia.pytania;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private Button buttonTak;
    private Button buttonNie;
    private Button buttonNastepne;
    private TextView textViewPytanie;
    private ImageView imageViewPytanie;
    private int punkty = 0, licznikPytania = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pytania.add(new Pytanie(R.drawable.geni, "Czy to jest gra RPG?", true, "Gra ma otwarty świat."));
        pytania.add(new Pytanie(R.drawable.gen, "Czy to jest bóg ognia?", false, "Bogowie są nieśmiertelni."));
        pytania.add(new Pytanie(R.drawable.genim, "Czy to jest pięcio gwiazdkowa postać?", true, "Pięcio gwiadkowe postaci ciężko wylosować i są bardzo silne."));

        buttonNie = findViewById(R.id.buttonNie);
        buttonTak = findViewById(R.id.buttonTak);
        textViewPytanie = findViewById(R.id.textViewPytanie);
        imageViewPytanie = findViewById(R.id.imageViewPytanie);
        buttonNastepne = findViewById(R.id.buttonNastepne);

        wyswietlPytanie(0);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikPytania++;
                        if (licznikPytania < pytania.size()) {
                            wyswietlPytanie(licznikPytania);
                        }
                    }
                }
        );
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzOdpowiedz(licznikPytania, true);
                    }
                }
        );
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzOdpowiedz(licznikPytania, false);
                    }
                }
        );
    }
    private void wyswietlPytanie(int ktorePytanie){
        textViewPytanie.setText(pytania.get(ktorePytanie).getTrescPytania());
        imageViewPytanie.setImageResource(pytania.get(ktorePytanie).getIdobrazka());
    }
    private void sprawdzOdpowiedz(int ktorePytanie, boolean udzielonaOdpowiedz){
        if (pytania.get(ktorePytanie).isOdpowiedz() == udzielonaOdpowiedz){
            pytania.get(ktorePytanie).setCzyOdpOk( true);
            Toast.makeText(this, "Udzielono poprawną odpowiedż.", Toast.LENGTH_SHORT).show();
        }
        if (pytania.get(ktorePytanie).isOdpowiedz() != udzielonaOdpowiedz){
            pytania.get(ktorePytanie).setCzyOdpOk(false);
            Toast.makeText(this, "Udzielono złą odpowiedż.", Toast.LENGTH_SHORT).show();
        }
    }
}