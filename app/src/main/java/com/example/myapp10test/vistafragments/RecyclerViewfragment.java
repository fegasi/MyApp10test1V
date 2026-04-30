package com.example.myapp10test.vistafragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp10test.R;
import com.example.myapp10test.adapters.petAdaptador;
import com.example.myapp10test.pojo.pet;
import com.example.myapp10test.presentador.IRecyclerViewFragmentPresenter;
import com.example.myapp10test.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewfragment extends Fragment implements IRecyclerViewFragmentView {
    @Nullable
    private IRecyclerViewFragmentPresenter presenter;


    ArrayList<pet> contactos= new ArrayList<pet>();
    private RecyclerView listaContactos;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmentrecyclerview,container,false);


        listaContactos=v.findViewById(R.id.rvContactos);
        presenter=new RecyclerViewFragmentPresenter(this,getContext());
       // GridLayoutManager glm=new GridLayoutManager(getActivity(),2);

      // listaContactos.setLayoutManager(glm);




    return v;
    }






    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public petAdaptador crearAdaptador(ArrayList<pet> contactos) {
        petAdaptador adaptador=new petAdaptador(contactos,getActivity());
        return adaptador;
    }

    @Override
    public void inicializaradaptadorRV(petAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
