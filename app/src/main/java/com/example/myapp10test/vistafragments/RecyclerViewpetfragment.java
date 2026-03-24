package com.example.myapp10test.vistafragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp10test.R;
import com.example.myapp10test.adapters.petAdaptador2;
import com.example.myapp10test.pojo.pet;

import java.util.ArrayList;

public class RecyclerViewpetfragment extends Fragment {
    @Nullable

    ArrayList<pet> contactos2= new ArrayList<pet>();
    private RecyclerView listaContactos2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfil,container,false);


        listaContactos2=v.findViewById(R.id.rvpets);
       // LinearLayoutManager llm=new LinearLayoutManager(getActivity());
//llm.setOrientation(LinearLayoutManager.VERTICAL);
//listaContactos.setLayoutManager(llm);
        GridLayoutManager glm=new GridLayoutManager(getActivity(),3);

       listaContactos2.setLayoutManager(glm);
        inicializarListaContactos();

        inicializarAdaptador();

    return v;
    }
    public void inicializarAdaptador()
    {
        petAdaptador2 adaptador2=new petAdaptador2(contactos2);
        listaContactos2.setAdapter(adaptador2);
    }
    public void inicializarListaContactos(){
        //ArrayList<Contacto> contactos= new ArrayList<Contacto>();

        contactos2.add(new pet(1,"sombra",0,R.drawable.perro8));
        contactos2.add(new pet(1,"sombra",0,R.drawable.perro8));
        contactos2.add(new pet(1,"sombra",0,R.drawable.perro8));
        contactos2.add(new pet(1,"sombra",0,R.drawable.perro8));
        contactos2.add(new pet(1,"sombra",0,R.drawable.perro8));
        /*contactos.add(new pet("picky",0,R.drawable.perro3));
        contactos.add(new pet("rayitas",0,R.drawable.gato4));
        contactos.add(new pet("pingu",0,R.drawable.perro4));
        contactos.add(new pet("greñas",0,R.drawable.gato5));
        contactos.add(new pet("quesito",0,R.drawable.perro5));
        contactos.add(new pet("manigüis",0,R.drawable.gato6));
contactos.add(new pet("canelas",0,R.drawable.perro6));
contactos.add(new pet("patitas",0,R.drawable.gato7));
contactos.add(new pet("comelón",0,R.drawable.perro7));
        contactos.add(new pet("sombra",0,R.drawable.perro8));
        contactos.add(new pet("bolita",0,R.drawable.gato8));*/
    }
}
