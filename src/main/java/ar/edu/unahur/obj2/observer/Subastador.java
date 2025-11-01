package ar.edu.unahur.obj2.observer;

public class Subastador implements Observador{

    private final String nombre;
    private Oferta ultimaOfertaRecibida = new Oferta(this, 0.0);

    public Subastador(String nombre) {
        this.nombre = nombre;
    }

    public Oferta getUltimaOfertaRecibida() {
        return ultimaOfertaRecibida;
    }

    @Override
    public void actualizar(Oferta oferta) {
        ultimaOfertaRecibida = oferta;
    }

    public Oferta ofertar() {
        if(this.ultimaOfertaRecibida == null){
            return new Oferta(this,10.0);
        }
        return new Oferta(this, ultimaOfertaRecibida.getValor() + 10.0);
    }

    public String getNombre() {
        return nombre;
    }

}
