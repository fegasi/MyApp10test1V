package com.example.myapp10test.presentador;

import android.content.Context;

import com.example.myapp10test.adapters.petAdaptador;
import com.example.myapp10test.db.ConstructorContactos;
import com.example.myapp10test.pojo.pet;
import com.example.myapp10test.vistafragments.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<pet> contactos;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView= iRecyclerViewFragmentView;
        this.context=context;
        obtenerContactosBaseDatos();

    }


    @Override
    public void obtenerContactosBaseDatos() {
          constructorContactos=new ConstructorContactos(context);
          contactos=constructorContactos.obtenerContactos();
          mostrarContactosBaseDatosRV();
    }

    @Override
    public void mostrarContactosBaseDatosRV() {
              iRecyclerViewFragmentView.inicializaradaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
              iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
