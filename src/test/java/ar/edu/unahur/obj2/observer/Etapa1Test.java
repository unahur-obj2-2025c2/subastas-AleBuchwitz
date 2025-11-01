package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Etapa1Test {
    @Test
    void subastadorRecibeLaOferta() {
        ProductoSubastado producto = new ProductoSubastado("cuadro de picazo");
        Subastador gonzager = new Subastador("gonzager");

        producto.registrarSubastador(gonzager);
        producto.agregarOferta(new Oferta(gonzager, 10.0));

        assertEquals(10.0, gonzager.getUltimaOfertaRecibida().getValor());
    }

    @Test
    void subastadorRecibeLaUltimaOferta() {
        ProductoSubastado producto = new ProductoSubastado("jarron ming");
        Subastador gonzager = new Subastador("gonzager");
        Subastador martomau = new Subastador("martomau");

        producto.registrarSubastador(gonzager);
        producto.registrarSubastador(martomau);
        producto.agregarOferta(new Oferta(martomau, 10.0));
        producto.agregarOferta(new Oferta(gonzager, 20.0));
        producto.agregarOferta(new Oferta(martomau, 30.0));

        assertEquals(30.0, gonzager.getUltimaOfertaRecibida().getValor());
        assertEquals(30.0, martomau.getUltimaOfertaRecibida().getValor());
    }
}
