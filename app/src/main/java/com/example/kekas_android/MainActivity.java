package com.example.kekas_android;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1;
    Spinner combito;
    Button botoncito1, botoncito2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String cadenitas[] = {"Elige", "Pollo", "Picadillo", "Papa"};

        ArrayAdapter adaptadito;
        adaptadito = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                cadenitas);
        combito.setAdapter(adaptadito);

        edit1 = findViewById(R.id.edit1);

        botoncito1 = findViewById(R.id.Agregar);
        botoncito1.setOnClickListener(this);
        botoncito2 = findViewById(R.id.Pagar);
        botoncito2.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

    }
}