package com.lusia.pytania;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();

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
    }
}