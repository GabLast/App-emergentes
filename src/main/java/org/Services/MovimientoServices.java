package org.Services;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.Database.MongoDB;
import org.Models.Articulo;
import org.Models.MovimientoInventario;
import org.Models.OrdenCompra;
import org.Models.Suplidor;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovimientoServices {
    private MongoCollection<Document> movimientos = MongoDB.getDB().getCollection("movimientos");

    public void insertMovimiento(MovimientoInventario movimiento) {

        Document movi = new Document();

        movi.put("codigoMovimiento", movimiento.getCodigoMovimiento());
        movi.put("codigoArticulo", movimiento.getCodigoArticulo());
        movi.put("tipoMovimiento", movimiento.getTipoMovimiento());
        movi.put("cantidad", movimiento.getCantidad());
        movi.put("fechaMovimiento", movimiento.getFechaMovimiento());

        movimientos.insertOne(movi);
    }

    public List<MovimientoInventario> getMovimientos(){
        MongoCursor<Document> cursor = movimientos.find().iterator();
        Document result;
        List<MovimientoInventario> lista = new ArrayList<>();

        try{
            while(cursor.hasNext()){
                result = cursor.next();

                long codigoMovimiento = result.getLong("codigoMovimiento");
                long codigoArticulo = result.getLong("codigoArticulo");
                String tipoMovimiento = result.getString("tipoMovimiento");
                int cantidad = result.getInteger("cantidad");
                Date fechaMovimiento = result.getDate("fechaMovimiento");

                MovimientoInventario aux = new MovimientoInventario(codigoMovimiento, codigoArticulo, tipoMovimiento, cantidad, fechaMovimiento);

                lista.add(aux);
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

    public int consumoDiario(long idarti) {

        //La forma correcta de calcularlo es:
        //Hacerlo entre un rango de fechas y calcularlo con los dias
        //que tengo entre ellas

        // o
        // un promedio historico con un avg en vez del sum

        List<Document> listadoEtapas = new ArrayList<>();

        Document match =
                new Document("tipoMovimiento", "SALIDA")
                        .append("codigoArticulo", idarti);


        listadoEtapas.add(new Document("$match", match));

        Document _id = new Document("codigoArticulo", "$codigoArticulo");

        Document sum = new Document("$sum", "$cantidad");

        Document group = new Document("_id", _id)
                .append("totalUnidades", sum);

        listadoEtapas.add(new Document("$group", group));

        Document project2 =
                new Document("_id", 0)
                        .append("codigoArticulo", "$_id.codigoArticulo")
                        .append("consumoDiario",
                                new Document("$divide", Arrays.asList("$totalUnidades", 30)));

        listadoEtapas.add(new Document("$project", project2));


        AggregateIterable<Document> resultadoConsulta = movimientos.aggregate(listadoEtapas);

//        resultadoConsulta.forEach((var documento) -> {
//            System.out.println(documento.toJson());
//        });

        double valor = -1;

        for (Document doc : resultadoConsulta) {
            valor = Double.valueOf(doc.get("consumoDiario").toString());
        }

        return (int) Math.ceil(valor);

    }
}
