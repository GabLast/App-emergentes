package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.ServiceInstances;
import org.Models.MovimientoInventario;
import org.Models.Suplidor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;

public class SuplidoresController {

    Javalin app;

    public SuplidoresController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            before(ctx -> {

            });

            path("/suplidor", () -> {

                get("/listar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("/templates/Suplidor.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("/templates/RegistrarSuplidor.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long idarticulo = ctx.formParam("idarti", Long.class).get();
                    long idSuplidor = ctx.formParam("idSuplidor", Long.class).get();
                    int tiempoEntrega = ctx.formParam("tiempoEntrega", Integer.class).get();
                    BigDecimal precioCompra = new BigDecimal(ctx.formParam("precioCompra"));

                });
            });

        });
    }
}
