package ar.edu.unahur.obj2.observer;

public class Oferta {

    private final Subastador subastador;
    private double monto = 0.0;

    public Oferta(Subastador subastador, double monto) {
        this.subastador = subastador;
        this.monto = monto;
    }

    public Double getValor() {
        return monto;
    }

    public Object getSubastador() {
        return subastador;
    }

}
