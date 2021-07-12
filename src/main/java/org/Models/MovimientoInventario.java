package org.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovimientoInventario {

    private long codigoMovimiento;
    private long codigoAlmacen;
    private String tipoMovimiento;
    private int cantidad;
    private Date fechaMovmiento;

    public MovimientoInventario(long codigoMovimiento, long codigoAlmacen, String tipoMovimiento, int cantidad, Date fechaMovmiento) {
        this.codigoMovimiento = codigoMovimiento;
        this.codigoAlmacen = codigoAlmacen;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.fechaMovmiento = fechaMovmiento;
    }

    public long getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(long codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public long getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(long codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
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

    public Date getFechaMovmiento() {
        return fechaMovmiento;
    }

    public void setFechaMovmiento(Date fechaMovmiento) {
        this.fechaMovmiento = fechaMovmiento;
    }
}
