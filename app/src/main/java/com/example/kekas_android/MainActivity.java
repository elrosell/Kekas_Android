package com.example.kekas_android;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText edit1;
    Spinner combito;
    Button botoncito1, botoncito2;
    TextView textitoview;
    Arreglito aobjetito = new Arreglito();
    ArrayList<Clasesita> aRegreso = new ArrayList<>();

    String saborSeleccionado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        combito = findViewById(R.id.combito);
        botoncito1 = findViewById(R.id.Agregar);
        botoncito2 = findViewById(R.id.Pagar);
        textitoview = findViewById(R.id.resultado);


        String[] cadenitas = {"Elige Sabor", "Pollo", "Picadillo", "Papa"};
        ArrayAdapter<String> adaptadito = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                cadenitas
        );
        adaptadito.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combito.setAdapter(adaptadito);
        combito.setOnItemSelectedListener(this);

        botoncito1.setOnClickListener(this);
        botoncito2.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cadenita = parent.getItemAtPosition(position).toString();
        if ("Pollo".equals(cadenita) || "Picadillo".equals(cadenita) || "Papa".equals(cadenita)) {
            saborSeleccionado = cadenita;
        } else {
            saborSeleccionado = null;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        saborSeleccionado = null;
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if (viewId == R.id.Agregar) {
            agregarOrden();
        } else if (viewId == R.id.Pagar) {
            mostrarCuenta();
        }
    }

    private void agregarOrden() {
        if (saborSeleccionado == null) {
            Toast.makeText(this, "Selecciona un sabor válido", Toast.LENGTH_SHORT).show();
            return;
        }
        String textito = edit1.getText().toString().trim();
        if (textito.isEmpty()) {
            Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show();
            return;
        }
        int cantidad = Integer.parseInt(textito);
        int precio = precioPorSabor(saborSeleccionado);
        int costo = precio * cantidad;

        Clasesita objetito = new Clasesita();
        objetito.setSabor(saborSeleccionado);
        objetito.setCantidad(cantidad);
        objetito.setCosto(costo);

        aobjetito.agregar(objetito);
        Toast.makeText(this, "Orden guardada", Toast.LENGTH_SHORT).show();
    }

    private void mostrarCuenta() {
        aRegreso = aobjetito.regresar();
        if (aRegreso == null) {
            aRegreso = new ArrayList<>();
        }
        int apagar = 0;
        String cadenititita = "";
        Toast.makeText(this, "Tiene: " + aRegreso.size() + " Ordenes ", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < aRegreso.size(); i++) {
            Clasesita objetito = aRegreso.get(i);
            cadenititita = cadenititita
                    + "Sabor: " + objetito.getSabor() + "  "
                    + "Cantidad: " + objetito.getCantidad() + "  "
                    + "Costo Total: " + objetito.getCosto() + "\n";

            apagar = apagar + objetito.getCosto();
        }
        cadenititita = cadenititita + "\nGran total: " + apagar;
        textitoview.setText(cadenititita);
    }

    private int precioPorSabor(String sabor) {
        if ("Pollo".equals(sabor)) {
            return 20;
        } else if ("Picadillo".equals(sabor)) {
            return 25;
        } else if ("Papa".equals(sabor)) {
            return 18;
        }
        return 0;
    }
}
