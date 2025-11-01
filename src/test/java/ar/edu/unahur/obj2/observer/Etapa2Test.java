package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Etapa2Test {

    private ProductoSubastado producto;
    private Subastador gonzager;
    private Subastador martomau;
    private Subastador diasdan;

    @BeforeEach
    void setUp() {
        producto = new ProductoSubastado("cuadro de picazo");
        gonzager = new Subastador("gonzager");
        martomau = new Subastador("martomau");
        diasdan = new Subastador("diasdan");

        producto.registrarSubastador(gonzager);
        producto.registrarSubastador(martomau);
    }

    @Test
    void subastaConIncrementoYRegistroCorrecto() {
        //deberia valer 10
        producto.agregarOferta(martomau.ofertar());
        //deberia valer 20
        producto.agregarOferta(gonzager.ofertar());
        //deberia valer 30
        producto.agregarOferta(martomau.ofertar());

        assertEquals(3, producto.getOfertas().size());
        assertEquals(30.0, producto.getUltimaOferta().getValor(), 0.01);
        assertEquals("martomau", ((Subastador) producto.getUltimaOferta().getSubastador()).getNombre());
    }

    @Test
    void subastadorNoRegistradoAlIntentarOfertarLanzaExcepcion() {
        assertThrows(OfertaSubastadorException.class, () -> {
            producto.agregarOferta(diasdan.ofertar());
        });
    }
}
