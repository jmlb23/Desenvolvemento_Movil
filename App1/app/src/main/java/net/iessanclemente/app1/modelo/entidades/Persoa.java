package net.iessanclemente.app1.modelo.entidades;

/**
 * Created by a10jesuslb on 11/18/15.
 */
public class Persoa {

    private String id;
    private String descripcion;

    public Persoa(){
        this("","");

    }


    public Persoa(String id,String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString(){
        return String.format("%s %s",this.id,this.descripcion);
    }
}
