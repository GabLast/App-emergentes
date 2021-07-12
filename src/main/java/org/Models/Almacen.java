package org.Models;

import java.math.BigDecimal;

public class Almacen {

    private Long codigoAlmacen;
    private BigDecimal balanceActual;

    public Almacen(Long codigoAlmacen, BigDecimal balanceActual) {
        this.codigoAlmacen = codigoAlmacen;
        this.balanceActual = balanceActual;
    }

    public Long getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(Long codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public BigDecimal getBalanceActual() {
        return balanceActual;
    }

    public void setBalanceActual(BigDecimal balanceActual) {
        this.balanceActual = balanceActual;
    }
}
