package com.example.myapp10test.vistafragments;
import com.example.myapp10test.adapters.petAdaptador;

import com.example.myapp10test.pojo.pet;

import java.util.ArrayList;


public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public petAdaptador crearAdaptador(ArrayList<pet> contactos);
    public void inicializaradaptadorRV(petAdaptador adaptador);
}
