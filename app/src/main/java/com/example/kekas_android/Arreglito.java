package com.example.kekas_android;

import java.util.ArrayList;

public class Arreglito {
    ArrayList<Clasesita> akekas = new ArrayList<>();

    public void agregar(Clasesita objetito){
        akekas.add(objetito);
    }

    public ArrayList<Clasesita> regresar(){
        return akekas;
    }
}
