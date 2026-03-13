package com.example.myapp10test.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp10test.R;
import com.example.myapp10test.pojo.pet;

import java.util.ArrayList;

public class petAdaptador2 extends RecyclerView.Adapter<petAdaptador2.contactoViewHolder> {

    ArrayList<pet> contactos2;
public petAdaptador2(ArrayList<pet> contactos)
    {
        this.contactos2=contactos;
    }

    public contactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.petscardcontact,parent,false);
        return new contactoViewHolder(v);
    }

    @Override

    public void onBindViewHolder(@NonNull contactoViewHolder holder, int position) {
pet contacto=contactos2.get(position);
contactoViewHolder.imfoto.setImageResource(contacto.getFoto());
//contactoViewHolder.tvnombre.setText(contacto.getNombre());
        //contactoViewHolder.tvlikes.setText(String.valueOf(contacto.getLikes()));
        //contactoViewHolder.tvemail.setText(contacto.getCorreo());

    }

    @Override
    public int getItemCount() {
        return contactos2.size();
    }

    public static class contactoViewHolder extends RecyclerView.ViewHolder {

         private static ImageView imfoto;
         private static TextView tvnombre;



        public contactoViewHolder(View itemView) {
            super(itemView);
            imfoto= itemView.findViewById(R.id.imfoto);
            tvnombre= itemView.findViewById(R.id.tvnombre);


        }
    }
}
