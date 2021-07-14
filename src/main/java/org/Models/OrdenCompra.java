package org.Models;

import org.Database.MongoDB;

import java.math.BigDecimal;
import java.util.Date;


public class OrdenCompra {
    private long codigoOrdenCompra;
    private long codigoArticulo;
    private long codigoSuplidor;
    private Date fechaOrden;
    private Date fechaRequerida;
    private BigDecimal precioCompra;
    private int cantidadOrdenada;
    private BigDecimal montoTotal;
    private String unidadCompra;

    public OrdenCompra() {
    }

    public OrdenCompra(long codigoArticulo, long codigoSuplidor, BigDecimal precioCompra, int cantidadOrdenada, String unidadCompra, Date fechaOrden, Date fechaRequerida) {
        this.codigoOrdenCompra = MongoDB.getDB().getCollection("ordenes").countDocuments()+1;
        this.codigoArticulo = codigoArticulo;
        this.codigoSuplidor = codigoSuplidor;
        this.fechaOrden = fechaOrden;
        this.fechaRequerida = fechaRequerida;
        this.precioCompra = precioCompra;
        this.cantidadOrdenada = cantidadOrdenada;
        this.unidadCompra = unidadCompra;
    }

    public Date getFechaRequerida() {
        return fechaRequerida;
    }

    public void setFechaRequerida(Date fechaRequerida) {
        this.fechaRequerida = fechaRequerida;
    }

    public long getCodigoOrdenCompra() {
        return codigoOrdenCompra;
    }

    public void setCodigoOrdenCompra(long codigoOrdenCompra) {
        this.codigoOrdenCompra = codigoOrdenCompra;
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

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidadOrdenada() {
        return cantidadOrdenada;
    }

    public void setCantidadOrdenada(int cantidadOrdenada) {
        this.cantidadOrdenada = cantidadOrdenada;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }
}
