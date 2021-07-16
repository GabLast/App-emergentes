package org;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import org.Controllers.*;
import org.Helpers.ServiceInstances;
import org.Models.OrdenCompra;
import org.Services.OrdenCompraServices;


import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("rutas"));
            config.enableCorsForAllOrigins();

        }).start(7000);

        new HomeController(app).routes();
        new ArticulosController(app).routes();
        new MovimientosController(app).routes();
        new SuplidoresController(app).routes();
        new OrdenesController(app).routes();

        app.get("/", ctx -> {
            ctx.redirect("/home");
        });

        app.error(404, ctx -> {
            ctx.redirect("/404.html");
        });

    }
}
