package org.Models;

import java.math.BigDecimal;

public class ArticuloCompra {

    private long codigoArticulo;
    private int cantidadOrdenada;
    private String unidadCompra;
    private BigDecimal precioCompra;


    public ArticuloCompra(long codigoArticulo, int cantidadOrdenada, String unidadCompra, BigDecimal precioCompra) {
        this.codigoArticulo = codigoArticulo;
        this.cantidadOrdenada = cantidadOrdenada;
        this.unidadCompra = unidadCompra;
        this.precioCompra = precioCompra;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidadOrdenada() {
        return cantidadOrdenada;
    }

    public void setCantidadOrdenada(int cantidadOrdenada) {
        this.cantidadOrdenada = cantidadOrdenada;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
}
