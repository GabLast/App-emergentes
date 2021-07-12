package org.Models;

import org.Database.MongoDB;

import java.util.Date;

public class MovimientoInventario {

    private long codigoMovimiento;
    private long codigoArticulo;
    private String tipoMovimiento;
    private int cantidad;
    private Date fechaMovimiento;

    public MovimientoInventario(long codigoMovimiento, long codigoArticulo, String tipoMovimiento, int cantidad, Date fechaMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
        this.codigoArticulo = codigoArticulo;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.fechaMovimiento = fechaMovimiento;
    }

    public MovimientoInventario(long codigoArticulo, String tipoMovimiento, int cantidad, Date fechaMovimiento) {
        this.codigoMovimiento = MongoDB.getDB().getCollection("movimientos").countDocuments()+1;
        this.codigoArticulo = codigoArticulo;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.fechaMovimiento = fechaMovimiento;
    }

    public long getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(long codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
}
