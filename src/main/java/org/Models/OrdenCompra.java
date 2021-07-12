package org.Models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdenCompra {
    private long codigoOrdenCompra;
    private long codigoSuplidor;
    private Date fechaOrden;
    private BigDecimal montoTotal;
    private List<ArticuloCompra> articulos;

    public OrdenCompra(long codigoOrdenCompra, long codigoSuplidor, Date fechaOrden, BigDecimal montoTotal, List<ArticuloCompra> articulos) {
        this.codigoOrdenCompra = codigoOrdenCompra;
        this.codigoSuplidor = codigoSuplidor;
        this.fechaOrden = fechaOrden;
        this.montoTotal = montoTotal;
        this.articulos = articulos;
    }

    public long getCodigoOrdenCompra() {
        return codigoOrdenCompra;
    }

    public void setCodigoOrdenCompra(long codigoOrdenCompra) {
        this.codigoOrdenCompra = codigoOrdenCompra;
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

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<ArticuloCompra> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloCompra> articulos) {
        this.articulos = articulos;
    }
}
