package org.Controllers;

import io.javalin.Javalin;
import org.Helpers.Funciones;
import org.Helpers.ServiceInstances;
import org.Models.Articulo;
import org.Models.MovimientoInventario;
import org.Models.OrdenCompra;
import org.Models.Suplidor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

                get("/listar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Listar");
                    freeMarkerVars.put("ordenes", ServiceInstances.ordenCompraServices.getOrdenes());
                    ctx.render("/templates/ListarOrdenes.ftl", freeMarkerVars);
                });

                get("/registrar", ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Registrar");
                    freeMarkerVars.put("articulos", ServiceInstances.articuloServices.getArticulos());
                    ctx.render("/templates/RegistrarOrden.ftl", freeMarkerVars);
                });

                post("/registrar", ctx -> {
                    long codigoArticulo = ctx.formParam("codigoArticulo", Long.class).get();

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaRequerida = format.parse(ctx.formParam("fechaRequerida"));

                    int cantRequeridaInventario = ctx.formParam("cantRequeridaInventario", Integer.class).get();

                    Articulo arti = ServiceInstances.articuloServices.getArticuloById(codigoArticulo);
                    int diasEntrega = Funciones.calcularDiasParaEntregar(fechaRequerida);
                    Suplidor supli = ServiceInstances.suplidorServices.getMejorSuplidor(codigoArticulo, diasEntrega);

                    Date fechaOrden = Funciones.calcularFechaOrden(supli, fechaRequerida);
                    int cantidadOrdenar = Funciones.cantidadOrdenar(codigoArticulo, fechaRequerida, cantRequeridaInventario);

                    OrdenCompra orden = new OrdenCompra(
                            arti.getCodigoArticulo(),
                            supli.getCodigoSuplidor(),
                            supli.getPrecioCompra(),
                            cantidadOrdenar,
                            arti.getUnidadCompra(),
                            fechaOrden,
                            fechaRequerida
                    );

                    ServiceInstances.ordenCompraServices.insertOrden(orden);
                    ctx.redirect("/ordenes/listar");
                });
            });

        });
    }
}
