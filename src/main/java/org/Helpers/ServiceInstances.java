package org.Helpers;

import org.Services.ArticuloServices;
import org.Services.MovimientoServices;
import org.Services.OrdenCompraServices;
import org.Services.SuplidorServices;

public class ServiceInstances {

    public static ArticuloServices articuloServices = new ArticuloServices();
    public static MovimientoServices movimientoServices = new MovimientoServices();
    public static SuplidorServices suplidorServices = new SuplidorServices();
    public static OrdenCompraServices  ordenCompraServices = new OrdenCompraServices();
}
