package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.List;

public class ProductoSubastado {

    private final String nombre;
    private List <Observador> observadores = new ArrayList<>();
    private List <Oferta> ofertas = new ArrayList<>();

    public ProductoSubastado(String nombre) {
        this.nombre = nombre;
    }

    public void agregarOferta(Oferta oferta) {
        if (!this.observadores.contains(oferta.getSubastador())) {
            throw new OfertaSubastadorException("El subastador no particiipa en la subasta");
        }
        this.ofertas.add(oferta);
        notificarObservadores(oferta);
    }

    public void registrarSubastador(Subastador subastador) {
        this.observadores.add(subastador);
    }

    private void notificarObservadores(Oferta oferta) {
        for (Observador observadores : this.observadores){
            observadores.actualizar(oferta);
        }
    }

	public List <Oferta> getOfertas() {
		return ofertas;
	}

	public Oferta getUltimaOferta() {
        if(this.ofertas.isEmpty()) return null;
		return this.ofertas.get(this.ofertas.size() - 1);
	}

}
