package com.example.myapp10test.pojo;

public class pet {



private int id;
        private String nombre;
        private int likes;
        private int foto;
        public pet(int id,String name,int gustas, int photo)
        {

            this.id=id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


