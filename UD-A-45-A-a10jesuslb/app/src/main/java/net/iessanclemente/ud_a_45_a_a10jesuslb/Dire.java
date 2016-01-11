package net.iessanclemente.ud_a_45_a_a10jesuslb;

/**
 * Created by a10jesuslb on 1/11/16.
 */
public class Dire {

    private String nome;
    private String descripcion;

    public Dire(){

    }
    public Dire(String descripcion, String nome) {
        this.setDescripcion(descripcion);
        this.setNome(nome);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override public String toString(){
        return String.format("%s : %s\n",this.nome,this.descripcion);
    }
}
