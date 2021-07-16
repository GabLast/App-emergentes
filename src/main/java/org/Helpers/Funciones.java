package org.Helpers;

import org.Models.Suplidor;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Funciones {

    public static int calcularDiasParaEntregar(Date fechaRequerida)
    {

        int days;

        long currentDateinMS = new Date().getTime();
        long fechaReq = fechaRequerida.getTime();

        long timeDiff;
        if(currentDateinMS > fechaReq) {
            timeDiff = currentDateinMS - fechaReq;
        } else {
            timeDiff = fechaReq - currentDateinMS;
        }

        days = (int) (timeDiff / (1000 * 60 * 60 * 24));

        return days;
    }

    public static Date calcularFechaOrden(Suplidor supli, Date fechaRequerida)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaRequerida);
        cal.add(Calendar.DATE, (supli.getTiempoEntrega() * -1) - 1);
        Date fechaOrden = cal.getTime();

        return fechaOrden;

    }


    public static int cantidadOrdenar(long idArti, Date fechaReq, int cantRequeridaInventario){

        int consumidoHaciaFechaReq =
                calcularDiasParaEntregar(fechaReq)
                * ServiceInstances.movimientoServices.consumoDiario(idArti);

        int calculo = consumidoHaciaFechaReq + cantRequeridaInventario;

        int ordenar = calculo -
                ServiceInstances.articuloServices.getArticuloById(idArti).getBalanceActual();

        return ordenar;

//        quiero tener 100
//        actual = 13
//        fecha para tener = 15
//        fecha actual = 7
//        consumo diario = 5
//        consumidoHaciaFecha + CantRequerida = (8*5) + 100 = 140
//        ordenar = 140 - 13 = 127
//        *****verificacion******
//        13 - 5*8 = -27
//        127 - 27 = 100
    }
}
