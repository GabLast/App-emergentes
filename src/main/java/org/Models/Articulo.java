package org.Models;

import org.Database.MongoDB;
import org.bson.Document;

import java.util.List;

public class Articulo {

    private long codigoArticulo;
    private String descripcion;
    private String unidadCompra;
    public int balanceActual;

    public Articulo(long codigoArticulo, String descripcion, String unidadCompra, int balanceActual) {
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.unidadCompra = unidadCompra;
        this.balanceActual = balanceActual;
    }

    public Articulo(String descripcion, String unidadCompra, int balanceActual) {
        this.codigoArticulo = MongoDB.getDB().getCollection("articulos").countDocuments()+1;
        this.descripcion = descripcion;
        this.unidadCompra = unidadCompra;
        this.balanceActual = balanceActual;
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

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }

    public int getBalanceActual() {
        return balanceActual;
    }

    public void setBalanceActual(int balanceActual) {
        this.balanceActual = balanceActual;
    }
}
