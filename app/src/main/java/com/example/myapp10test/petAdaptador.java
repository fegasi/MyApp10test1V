package com.example.myapp10test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class petAdaptador extends RecyclerView.Adapter<petAdaptador.contactoViewHolder> {

    ArrayList<pet> contactos;
public petAdaptador(ArrayList<pet> contactos)
    {
        this.contactos=contactos;
    }

    public contactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.petscard,parent,false);
        return new contactoViewHolder(v);
    }

    @Override

    public void onBindViewHolder(@NonNull contactoViewHolder holder, int position) {
pet contacto=contactos.get(position);
contactoViewHolder.imfoto.setImageResource(contacto.getFoto());
contactoViewHolder.tvnombre.setText(contacto.getNombre());
        contactoViewHolder.tvlikes.setText(contacto.getLikes()+"");
        //contactoViewHolder.tvemail.setText(contacto.getCorreo());
contactoViewHolder.tvemail.setOnClickListener(new View.OnClickListener()
{
    public void onClick(View view)
    {
        //holder.getBindingAdapterPosition();
        Toast.makeText(view.getContext(), contacto.getNombre()+contacto.getLikes(), Toast.LENGTH_SHORT).show();
        int suma=contacto.getLikes();
        suma++;
        contacto.setlikes(suma);
        //pet contacto=contactos.get(position);
        //contactoViewHolder.tvlikes.setText(contacto.getLikes()+"");
        //contactoViewHolder.tvlikes.setText(suma+"");
    }
});
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class contactoViewHolder extends RecyclerView.ViewHolder {

         private static ImageView imfoto;
         private static TextView tvnombre;
         private static TextView tvlikes;

        private static ImageView tvemail;


        public contactoViewHolder(View itemView) {
            super(itemView);
            imfoto= itemView.findViewById(R.id.imfoto);
            tvnombre= itemView.findViewById(R.id.tvnombre);
            tvlikes= itemView.findViewById(R.id.tvlikes);
            tvemail= itemView.findViewById(R.id.tvemail);

        }
    }
}
