package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorgeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        textTotal       = findViewById(R.id.textTotal);
        textGorgeta     = findViewById(R.id.textGorjeta);
        seekBarGorjeta  = findViewById(R.id.seekBarGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " % ");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_LONG).show();
        }else {
            // converte string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //calcula a gosjeta total
            double gojeta = valorDigitado * (porcentagem/100);
            double total = gojeta + valorDigitado;

            //exibe a gojeta total
            textGorgeta.setText("R$ " + gojeta);
            textTotal.setText("R$ " + total);
        }

    }

}