package org;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import org.Models.OrdenCompra;
import org.Services.OrdenCompraServices;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("rutas"));
            config.enableCorsForAllOrigins();

        }).start(7000);


        app.get("/", ctx -> {
            ctx.redirect("/home");
        });

        app.error(404, ctx -> {
            ctx.redirect("/404.html");
        });

//        OrdenCompraServices a = new OrdenCompraServices();
//        List<OrdenCompra> lista = a.getOrdenes();
//
//        for(OrdenCompra orden : lista)
//        {
//            System.out.println("Testing");
//            System.out.println(orden.getCodigoArticulo());
//            System.out.println(orden.getCodigoOrdenCompra());
//            System.out.println(orden.getCodigoSuplidor());
//            System.out.println(orden.getFechaOrden());
//            System.out.println(orden.getUnidadCompra());
//            System.out.println(orden.getMontoTotal());
//        }

    }
}
