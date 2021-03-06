package org.Services;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.Database.MongoDB;
import org.Models.Articulo;
import org.Models.MovimientoInventario;
import org.Models.OrdenCompra;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrdenCompraServices {

    private MongoCollection<Document> ordenes = MongoDB.getDB().getCollection("ordenes");

    public void insertOrden(OrdenCompra compra) {

        Document orden = new Document();

        orden.put("codigoOrdenCompra", compra.getCodigoOrdenCompra());
        orden.put("codigoArticulo", compra.getCodigoArticulo());
        orden.put("codigoSuplidor", compra.getCodigoSuplidor());
        orden.put("fechaRequerida", compra.getFechaRequerida());
        orden.put("fechaOrden", compra.getFechaOrden());
        orden.put("precioCompra", compra.getPrecioCompra());
        orden.put("cantidadOrdenada", compra.getCantidadOrdenada());
        orden.put("unidadCompra", compra.getUnidadCompra());

        ordenes.insertOne(orden);
    }

    public List<OrdenCompra> getOrdenes() {

        List<OrdenCompra> lista = new ArrayList<>();

        List<Document> listadoEtapas = new ArrayList<>();

        Document opcionesProject =
                new Document("codigoOrdenCompra", "$codigoOrdenCompra")
                        .append("codigoArticulo", "$codigoArticulo")
                        .append("codigoSuplidor", "$codigoSuplidor")
                        .append("fechaRequerida", "$fechaRequerida")
                        .append("fechaOrden", "$fechaOrden")
                        .append("precioCompra", "$precioCompra")
                        .append("cantidadOrdenada", "$cantidadOrdenada")
                        .append("montoPorArticulo",
                                new Document("$multiply", Arrays.asList("$precioCompra", "$cantidadOrdenada")))
                        .append("unidadCompra", "$unidadCompra");

        listadoEtapas.add(new Document("$project", opcionesProject));

        Document _id = new Document("codigoOrdenCompra", "$codigoOrdenCompra")
                .append("codigoArticulo", "$codigoArticulo")
                .append("codigoSuplidor", "$codigoSuplidor")
                .append("fechaRequerida", "$fechaRequerida")
                .append("fechaOrden", "$fechaOrden")
                .append("unidadCompra", "$unidadCompra")
                .append("cantidadOrdenada", "$cantidadOrdenada")
                .append("precioCompra", "$precioCompra");

        Document sum = new Document("$sum", "$montoPorArticulo");

        Document group = new Document("_id", _id)
                .append("montoTotal", sum);

        listadoEtapas.add(new Document("$group", group));

        Document project2 =
                new Document("_id", 0)
                        .append("codigoOrdenCompra", "$_id.codigoOrdenCompra")
                        .append("codigoArticulo", "$_id.codigoArticulo")
                        .append("codigoSuplidor", "$_id.codigoSuplidor")
                        .append("fechaRequerida", "$_id.fechaRequerida")
                        .append("fechaOrden", "$_id.fechaOrden")
                        .append("unidadCompra", "$_id.unidadCompra")
                        .append("cantidadOrdenada", "$_id.cantidadOrdenada")
                        .append("precioCompra", "$_id.precioCompra")
                        .append("montoTotal", "$montoTotal");

        listadoEtapas.add(new Document("$project", project2));

        Document ordenarPorOrden = new Document("codigoOrdenCompra", 1);

        Document sort = new Document("$sort", ordenarPorOrden);

        listadoEtapas.add(sort);

        AggregateIterable<Document> resultadoConsulta = ordenes.aggregate(listadoEtapas);

//        resultadoConsulta.forEach((var documento) -> {
//            System.out.println(documento.toJson());
//        });

        OrdenCompra orden;
        for (Document doc : resultadoConsulta) {

            try {
                orden = new OrdenCompra();
                orden.setCodigoOrdenCompra(Long.valueOf(doc.get("codigoOrdenCompra").toString()));
                orden.setCodigoArticulo(Long.valueOf(doc.get("codigoArticulo").toString()));
                orden.setCodigoSuplidor(Long.valueOf(doc.get("codigoSuplidor").toString()));
                orden.setFechaRequerida(doc.getDate("fechaRequerida"));
                orden.setFechaOrden(doc.getDate("fechaOrden"));
                orden.setUnidadCompra(doc.getString("unidadCompra"));
                orden.setCantidadOrdenada(doc.getInteger("cantidadOrdenada"));
                orden.setPrecioCompra(new BigDecimal(doc.get("precioCompra").toString()));
                orden.setMontoTotal(new BigDecimal(doc.get("montoTotal").toString()));

                lista.add(orden);
            } catch (NullPointerException e) {

            }
        }

        return lista;

    }


    public List<OrdenCompra> ordenesPorSuplidorFechaOrden() {

        List<OrdenCompra> lista = new ArrayList<>();

        List<Document> listadoEtapas = new ArrayList<>();

        Document opcionesProject =
                new Document("codigoOrdenCompra", "$codigoOrdenCompra")
                        .append("codigoSuplidor", "$codigoSuplidor")
                        .append("fechaOrden", "$fechaOrden");

        listadoEtapas.add(new Document("$project", opcionesProject));

        Document _id = new Document("codigoOrdenCompra", "$codigoOrdenCompra")
                .append("codigoSuplidor", "$codigoSuplidor")
                .append("fechaOrden", "$fechaOrden");

        Document group = new Document("_id", _id);

        listadoEtapas.add(new Document("$group", group));

        Document project2 =
                new Document("_id", 0)
                        .append("codigoOrdenCompra", "$_id.codigoOrdenCompra")
                        .append("codigoSuplidor", "$_id.codigoSuplidor")
                        .append("fechaOrden", "$_id.fechaOrden");


        listadoEtapas.add(new Document("$project", project2));

        Document ordenarPorOrden = new Document("codigoOrdenCompra", 1);

        Document sort = new Document("$sort", ordenarPorOrden);

        listadoEtapas.add(sort);

        AggregateIterable<Document> resultadoConsulta = ordenes.aggregate(listadoEtapas);

        resultadoConsulta.forEach((var documento) -> {
            System.out.println(documento.toJson());
        });

//        OrdenCompra orden;
//        for (Document doc : resultadoConsulta) {
//
//            try {
//                orden = new OrdenCompra();
//                orden.setCodigoOrdenCompra(Long.valueOf(doc.get("codigoOrdenCompra").toString()));
//                orden.setCodigoArticulo(Long.valueOf(doc.get("codigoArticulo").toString()));
//                orden.setCodigoSuplidor(Long.valueOf(doc.get("codigoSuplidor").toString()));
//                orden.setFechaRequerida(doc.getDate("fechaRequerida"));
//                orden.setFechaOrden(doc.getDate("fechaOrden"));
//                orden.setUnidadCompra(doc.getString("unidadCompra"));
//                orden.setCantidadOrdenada(doc.getInteger("cantidadOrdenada"));
//                orden.setPrecioCompra(new BigDecimal(doc.get("precioCompra").toString()));
//                orden.setMontoTotal(new BigDecimal(doc.get("montoTotal").toString()));
//
//                lista.add(orden);
//            } catch (NullPointerException e) {
//
//            }
//        }

        return null;

    }


}
