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
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("/templates/Movimiento.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    ctx.render("/templates/RegistrarMov.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long idarticulo = ctx.formParam("idarti", Long.class).get();
                    String tipoMovimiento = ctx.formParam("tipoMovimiento");
                    int cantidad = ctx.formParam("cantidad", Integer.class).get();

                    /*<label for="cars">Choose a car:</label>
                    <select id="cars" name="cars">
                      <option value="volvo">Volvo</option>
                      <option value="saab">Saab</option>
                      <option value="fiat">Fiat</option>
                      <option value="audi">Audi</option>
                    </select>*/

                    MovimientoInventario aux = new MovimientoInventario(idarticulo, tipoMovimiento, cantidad, new Date());
                    ServiceInstances.movimientoServices.insertMovimiento(aux);
                    ServiceInstances.articuloServices.updateArticulo(idarticulo, cantidad, tipoMovimiento);
                });
            });

        });
    }
}
