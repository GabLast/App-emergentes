package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.ServiceInstances;
import org.Models.MovimientoInventario;
import org.Models.Suplidor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
                    freeMarkerVars.put("title", "Listar");
                    freeMarkerVars.put("suplidores", ServiceInstances.suplidorServices.getSuplidores());
                    ctx.render("/templates/Suplidor.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    freeMarkerVars.put("articulos", ServiceInstances.articuloServices.getArticulos());
                    ctx.render("/templates/RegistrarSuplidor.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long idarticulo = ctx.formParam("idarticulo", Long.class).get();
                    long idSuplidor = ctx.formParam("idSuplidor", Long.class).get();
                    int tiempoEntrega = ctx.formParam("tiempoEntrega", Integer.class).get();
                    BigDecimal precioCompra = new BigDecimal(ctx.formParam("precioCompra"));

                    if(idarticulo < 1)
                    {
                        System.out.println("Se ingreso un artículo no válido");
                        ctx.redirect("/404.html");
                    }else if(ServiceInstances.suplidorServices.getSuplidorByIdAndArti(idSuplidor, idarticulo) != null)
                    {
                        System.out.println("Un suplidor ya proporciona este articulo. No se puede repetir el mismo articulos 2 veces");
                        ctx.redirect("/404.html");
                    }else {
                        Suplidor aux = new Suplidor(idarticulo, idSuplidor, tiempoEntrega, precioCompra);
                        ServiceInstances.suplidorServices.insertarSuplidor(aux);
                        ctx.redirect("/suplidor/listar");
                    }

                });
            });

        });
    }
}
