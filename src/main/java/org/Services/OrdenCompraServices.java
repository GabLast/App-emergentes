package org.Services;

import com.mongodb.client.MongoCollection;
import org.Database.MongoDB;
import org.Models.MovimientoInventario;
import org.Models.OrdenCompra;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.Date;

public class OrdenCompraServices {
    private MongoCollection<Document> ordenes = MongoDB.getDB().getCollection("ordenes");

    public void insertOrden(OrdenCompra compra) {

        Document orden = new Document();

        orden.put("codigoOrdenCompra", compra.getCodigoOrdenCompra());
        orden.put("codigoArticulo", compra.getCodigoArticulo());
        orden.put("codigoSuplidor", compra.getCodigoSuplidor());
        orden.put("fechaOrden", compra.getFechaOrden());
        orden.put("precioCompra", compra.getPrecioCompra());
        orden.put("cantidadOrdenada", compra.getCantidadOrdenada());
        orden.put("montoTotal", compra.getMontoTotal());
        orden.put("unidadCompra", compra.getUnidadCompra());

        ordenes.insertOne(orden);
    }

}
