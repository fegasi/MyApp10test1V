package com.example.myapp10test.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.myapp10test.R;
import com.example.myapp10test.pojo.pet;

import java.util.ArrayList;

public class ConstructorContactos {

    Context context;
    public ConstructorContactos(Context context) {
        this.context=context;

    }

    public ArrayList<pet> obtenerContactos() {
        /*public void inicializarListaContactos(){*/
        ArrayList<pet> contactos = new ArrayList<pet>();
BaseDatos db=new BaseDatos(context);
        insertarTresContactos(db);
return db.obtenerTodosLosContactos();
      /*  contactos.add(new pet(1,"púas", 0, R.drawable.gato1));
        contactos.add(new pet(1,"peluche", 0, R.drawable.perro1));
        contactos.add(new pet(1,"juanelo", 0, R.drawable.gato2));
        contactos.add(new pet(1,"bigotes", 0, R.drawable.perro2));
        contactos.add(new pet(1,"rasta", 0, R.drawable.gato3));
        contactos.add(new pet(1,"picky", 0, R.drawable.perro3));
        contactos.add(new pet(1,"picky", 0, R.drawable.perro3));
        contactos.add(new pet(1,"rayitas", 0, R.drawable.gato4));
        contactos.add(new pet(1,"pingu", 0, R.drawable.perro4));
        contactos.add(new pet(1,"greñas", 0, R.drawable.gato5));
        contactos.add(new pet(1,"quesito", 0, R.drawable.perro5));
        contactos.add(new pet(1,"manigüis", 0, R.drawable.gato6));
        contactos.add(new pet(1,"canelas", 0, R.drawable.perro6));
        contactos.add(new pet(1,"patitas", 0, R.drawable.gato7));
        contactos.add(new pet(1,"comelón", 0, R.drawable.perro7));
        contactos.add(new pet(1,"sombra", 0, R.drawable.perro8));
        contactos.add(new pet(1,"bolita", 0, R.drawable.gato8));
return contactos;*/
    }
    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "púas");
      //  contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "77779999");
      //  contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "anahi@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.gato1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "peluche");
       // contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "88882222");
        //contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pedro@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.perro1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "juanelo");
      //  contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "33331111");
      //  contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mireya@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.gato2);

        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(pet contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, contacto.getLikes()+1);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(pet contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
