package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.ServiceInstances;
import org.Models.Articulo;


import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ArticulosController {

    Javalin app;

    public ArticulosController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            before(ctx -> {

            });

            path("/articulo", () -> {

                get("/listar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Listar");
                    freeMarkerVars.put("articulos", ServiceInstances.articuloServices.getArticulos());
                    ctx.render("/templates/Articulo.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("/templates/RegistrarArticulo.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    String descripcion = ctx.formParam("descripcion");
                    String unidadcompra = ctx.formParam("unidadCompra");
                    int balanceActual = ctx.formParam("balanceActual", Integer.class).get();

                    Articulo aux = new Articulo(descripcion, unidadcompra, balanceActual);

                    ServiceInstances.articuloServices.insertArticulo(aux);
                    ctx.redirect("/articulo/listar");

                });
            });

        });
    }
}
