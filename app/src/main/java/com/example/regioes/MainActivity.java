package com.example.regioes;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private TextView tvAfirmacao;
        private ConstraintLayout layout;
        private int contadorR, contadorE;

        private int columns = 5;
        private int rows = 9;
        private String regiaoEstados[][];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            regiaoEstados = new String[columns][rows];

            final String regiaoEstados[][] = {
                    {"Região Norte", "Amazonas (AM)", "Roraima (RR)", "Amapá (AP)", "Pará (PA)", "Tocantins (TO)", "Rondônia (RO)", "Acre (AC)"},
                    {"Nordeste", "Maranhão (MA)", "Piauí (PI)", "Ceará (CE)", "Rio Grande do Norte (RN)", "Pernambuco (PE)", "Paraíba (PB)", "Sergipe (SE)", "Alagoas (AL)", "Bahia (BA)"},
                    {"Centro-Oeste", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Goiás (GO)"},
                    {"Sudeste", "São Paulo (SP)", "Rio de Janeiro (RJ)", "Espírito Santo (ES)", "Minas Gerais (MG}"},
                    {"Sul", "Paraná (PR)", "Rio Grande do Sul (RS)", "Santa Catarina (SC)"}};

            contadorR = 0;
            contadorE = 0;

            layout = (ConstraintLayout) findViewById(R.id.layout);
            tvAfirmacao = (TextView) findViewById(R.id.tvAfirmacao);

            tvAfirmacao.setText("Regiao - Estados");


            layout.setOnTouchListener( new OnSwipeTouchListener(this){

                @Override
                public void onSwipeRight() {
                    super.onSwipeRight();
                    if(contadorE > 1) {
                        contadorE--;
                        tvAfirmacao.setText(regiaoEstados[contadorR][0] + " - " + regiaoEstados[contadorR][contadorE]);
                    }
                }

                @Override
                public void onSwipeLeft() {
                    super.onSwipeLeft();
                    if(contadorE < regiaoEstados[contadorR].length) {
                        contadorE++;
                        tvAfirmacao.setText(regiaoEstados[contadorR][0] + " - " + regiaoEstados[contadorR][contadorE]);
                    }
                }

                @Override
                public void onSwipeTop() {
                    super.onSwipeTop();
                    if(contadorR > 1) {
                        contadorR--;
                        contadorE = 1;
                        tvAfirmacao.setText(regiaoEstados[contadorR][0] + " - " + regiaoEstados[contadorR][contadorE]);
                    }
                }

                @Override
                public void onSwipeBottom() {
                    super.onSwipeBottom();
                    if(contadorR < 4) {
                        contadorR++;
                        contadorE = 1;
                        tvAfirmacao.setText(regiaoEstados[contadorR][0] + " - " + regiaoEstados[contadorR][contadorE]);
                    }
                }
            });

        }
    }
