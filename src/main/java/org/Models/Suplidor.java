package org.Models;

import java.math.BigDecimal;

public class Suplidor {
    private long codigoArticulo;
    private long codigoSuplidor;
    private int tiempoEntrega;
    private BigDecimal precioCompra;

    public Suplidor(long codigoArticulo, long codigoSuplidor, int tiempoEntrega, BigDecimal precioCompra) {
        this.codigoArticulo = codigoArticulo;
        this.codigoSuplidor = codigoSuplidor;
        this.tiempoEntrega = tiempoEntrega;
        this.precioCompra = precioCompra;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public long getCodigoSuplidor() {
        return codigoSuplidor;
    }

    public void setCodigoSuplidor(long codigoSuplidor) {
        this.codigoSuplidor = codigoSuplidor;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
}
