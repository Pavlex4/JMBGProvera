package com.example.pavle.jmbgprovera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by pavle on 15-Apr-17.
 */

public class About extends AppCompatActivity
{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView = (TextView) findViewById(R.id.textView);

        textView.setText("Jedinstveni matični broj građana (ćirilica: Јединствени матични број грађана, skraćeno JMBG) je identifikaciji broj dat svim novorođenim građanima SFRJ (Socijalističke Federativne Republike Jugoslavije) od 1976. godine.\n" +
                "\n" +
                "Svi građani rođeni prije 1976. godine su dobili broj zavisni od regija u kojem su tada živjeli. Broj je još uvijek u upotrebi u novonastalim državama od bivših republika SFRJ." + "\n\n"
                +"Broj treba da se sastoji od 13 cifara u formi „DD MM GGG RR BBB K“ (bez bijelih mjesta), gdje su:\n" +
                "\n" +
                "DD – dan rođenja\n" +
                "\n" +
                "MM – mjesec rođenja\n" +
                "\n" +
                "GGG – zadnje tri cifre godine rođenja\n" +
                "\n" +
                "RR – politički regija rođenja (za građane rođene prije 1976. godine politički regija gdje su trenutno živjeli)" +
                "\n\n" +
                "BBB – jedinstveni broj\n" +
                "000-499 – muški\n" +
                "500-999 – ženski\n\n" +
                "K - kontrolna cifra\n" +
                "Kontrolna cifra se izračunava formulom gdje:\nDDMMGGGRRBBBK = ABVGDĐEŽZIJKL\n\n\n" +
                "L = 11 - (( 7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Đ+K) ) % 11)\n\n" +
                " % predstavlja MOD ili ostatak deljenja a ne / ili znak za deljenje\n" +
                "Izraz u zagradi deli se sa 11. Pri deljenju se dobija ostatak koji se oduzima od 11 i tako se dobija L\n" +
                "\n" +
                "ako je kontrolna cifra između 1 i 9, ostaje ista (L = K)\n" +
                "ako je kontrolna cifra veća od 9, postaje nula (L = 0)\n\n" +
                "Na primjer, prvo muško dijete rođeno 1. januara 2100. godine u Beogradu će imati JMBG 0101100710006");
    }
}
