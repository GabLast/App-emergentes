package org.Models;

public class Articulo {

    private long codigoArticulo;
    private String descripcion;
    private Almacen infoAlmacen;
    private String unidadCompra;

    public Articulo(long codigoArticulo, String descripcion, Almacen infoAlmacen, String unidadCompra) {
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.infoAlmacen = infoAlmacen;
        this.unidadCompra = unidadCompra;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Almacen getInfoAlmacen() {
        return infoAlmacen;
    }

    public void setInfoAlmacen(Almacen infoAlmacen) {
        this.infoAlmacen = infoAlmacen;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }


}
