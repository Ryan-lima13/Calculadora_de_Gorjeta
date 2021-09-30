package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText  editValor;
    private TextView textPorcentagem;
    private TextView gorjeta;
    private TextView total;
    private SeekBar seekPorcentagem;
    private  double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editTextValor);
        textPorcentagem = findViewById(R.id.textPorcento);
        gorjeta = findViewById(R.id.textViewGorjeta);
        total = findViewById(R.id.textViewTotal);
        seekPorcentagem = findViewById(R.id.seekBarPorgentagem);

        // adicionar listener seekbar
        seekPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
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
        String valorResultado  = editValor.getText().toString();
        if(valorResultado == null || equals("")){
            Toast.makeText(
                    getApplicationContext(),"Digite um número Primeiro",Toast.LENGTH_LONG
            ).show();
        }else{
            // converter string para double
            double editValor = Double.parseDouble(valorResultado);

            // calcular gorjeta
            double editGorjeta = editValor * (porcentagem /100);
            double totalRecebe = editGorjeta + editValor;
            // exibir gorjeta e o total

            gorjeta.setText("R$ " + Math.round(editGorjeta));
            total.setText("R$ " + totalRecebe);

        }
    }

}