package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.ServiceInstances;
import org.Models.MovimientoInventario;
import org.Models.OrdenCompra;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.post;

public class OrdenesController {

    Javalin app;

    public OrdenesController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            before(ctx -> {

            });

            path("/ordenes", () -> {

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long codigoOrdenCompra = ctx.formParam("idarti", Long.class).get();
                    long codigoArticulo = ctx.formParam("codigoArticulo", Long.class).get();
                    long codigoSuplidor = ctx.formParam("codigoSuplidor", Long.class).get();
                    Date fechaOrden = ctx.formParam("fechaOrden", Date.class).get();
                    BigDecimal precioCompra = new BigDecimal(ctx.formParam("precioCompra"));
                    int cantidadOrdenada = ctx.formParam("cantidadOrdenada", Integer.class).get();
                    String unidadcompra = ctx.formParam("unidadcompra");

                    OrdenCompra aux = new OrdenCompra(codigoOrdenCompra, codigoArticulo, codigoSuplidor, fechaOrden, precioCompra, cantidadOrdenada, unidadcompra);
                    ServiceInstances.ordenCompraServices.insertOrden(aux);

                });
            });

        });
    }
}
