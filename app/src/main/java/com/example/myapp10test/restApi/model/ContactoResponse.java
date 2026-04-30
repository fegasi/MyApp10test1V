package com.example.myapp10test.restApi.model;

//import pojo.pet;

import com.example.myapp10test.pojo.Contacto;

import java.util.ArrayList;


public class ContactoResponse {

    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
