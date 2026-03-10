package com.example.myapp10test;

public class pet {




        private String nombre;
        private int likes;
        private int foto;
        public pet(String name,int gustas, int photo)
        {
            nombre=name;
            likes=gustas;
            foto=photo;

        }

        public int getFoto() {
            return foto;
        }

        public void setFoto(int foto) {
            this.foto = foto;
        }



        public int getLikes() {
            return likes;
        }

        public void setlikes(int likes) {
            this.likes = likes;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }


