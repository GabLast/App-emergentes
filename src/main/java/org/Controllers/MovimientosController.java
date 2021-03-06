package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.ServiceInstances;
import org.Models.Articulo;
import org.Models.MovimientoInventario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;

public class MovimientosController {

    Javalin app;

    public MovimientosController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            before(ctx -> {

            });

            path("/movimiento", () -> {

                get("/listar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Listar");
                    freeMarkerVars.put("movimientos", ServiceInstances.movimientoServices.getMovimientos());
                    ctx.render("/templates/Movimiento.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    freeMarkerVars.put("articulos", ServiceInstances.articuloServices.getArticulos());
                    ctx.render("/templates/RegistrarMov.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long idarticulo = ctx.formParam("idarticulo", Long.class).get();
                    String tipoMovimiento = ctx.formParam("tipoMovimiento");
                    int cantidad = ctx.formParam("cantidad", Integer.class).get();

                    if(tipoMovimiento.isEmpty() || idarticulo < 1)
                    {
                        ctx.redirect("/404.html");
                    }

                    MovimientoInventario aux = new MovimientoInventario(idarticulo, tipoMovimiento, cantidad, new Date());
                    ServiceInstances.movimientoServices.insertMovimiento(aux);
                    ServiceInstances.articuloServices.updateArticulo(idarticulo, cantidad, tipoMovimiento);

                    ctx.redirect("/movimiento/listar");
                });
            });

        });
    }
}
