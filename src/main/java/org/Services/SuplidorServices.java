package org.Services;

import com.mongodb.BasicDBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.Database.MongoDB;
import org.Models.Articulo;
import org.Models.Suplidor;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.mongodb.client.model.Filters.eq;

public class SuplidorServices {

    private MongoCollection<Document> suplidores = MongoDB.getDB().getCollection("suplidores");

    public void insertarSuplidor(Suplidor suplidor){

        Document supli = new Document();

        supli.put("codigoArticulo", suplidor.getCodigoArticulo());
        supli.put("codigoSuplidor", suplidor.getCodigoSuplidor());
        supli.put("tiempoEntrega", suplidor.getTiempoEntrega());
        supli.put("precioCompra", suplidor.getPrecioCompra());

        suplidores.insertOne(supli);
    }

    public Suplidor getSuplidorByIdAndArti(long idsup, long idart)
    {
        BasicDBObject criteria = new BasicDBObject();
        criteria.append("codigoArticulo", idart);
        criteria.append("codigoSuplidor", idsup);
        MongoCursor<Document> cursor = suplidores.find(criteria).iterator();
        Document result;
        Suplidor aux = null;
        try{
            while(cursor.hasNext()){
                result = cursor.next();
                Long codigoArticulo = result.getLong("codigoArticulo");
                Long codigoSuplidor = result.getLong("codigoSuplidor");
                int tiempoEntrega = result.getInteger("tiempoEntrega");
                BigDecimal precioCompra = new BigDecimal(result.get("precioCompra").toString());

                aux = new Suplidor(codigoArticulo, codigoSuplidor, tiempoEntrega, precioCompra);
            }
        } finally {
            cursor.close();
        }
        return aux;
    }

    public List<Suplidor> getSuplidores(){
        MongoCursor<Document> suplidoresCursor = suplidores.find().iterator();
        Document result;
        List<Suplidor> lista = new ArrayList<>();

        try{
            while(suplidoresCursor.hasNext()){
                result = suplidoresCursor.next();
                Long codigoArticulo = result.getLong("codigoArticulo");
                Long codigoSuplidor = result.getLong("codigoSuplidor");
                int tiempoEntrega = result.getInteger("tiempoEntrega");
                BigDecimal precioCompra = new BigDecimal(result.get("precioCompra").toString());

                Suplidor aux = new Suplidor(codigoArticulo, codigoSuplidor, tiempoEntrega, precioCompra);

                lista.add(aux);
            }
        } finally {
            suplidoresCursor.close();
        }
        return lista;
    }

    public Suplidor getMejorSuplidor(long idarti, long diasEntrega)
    {
        List<Document> listadoEtapas = new ArrayList<>();

        Document lte = new Document("$lte", diasEntrega);

        Document match =
                new Document("codigoArticulo", idarti)
                        .append("tiempoEntrega", lte);


        listadoEtapas.add(new Document("$match", match));

        Document sort = new Document("$sort",  new Document("precioCompra", 1));

        listadoEtapas.add(sort);

        listadoEtapas.add(new Document("$limit", 1));

        Document project2 =
                new Document("_id", 0)
                        .append("codigoSuplidor", "$codigoSuplidor")
                        .append("tiempoEntrega","$tiempoEntrega")
                        .append("precioCompra","$precioCompra")
                        .append("codigoArticulo","$codigoArticulo");

        listadoEtapas.add(new Document("$project", project2));


        AggregateIterable<Document> resultadoConsulta = suplidores.aggregate(listadoEtapas);

        int tam = 0;
//        resultadoConsulta.forEach((var documento) -> {
//            System.out.println(documento.toJson());
//        });

        for(Document doc : resultadoConsulta)
        {
            if(doc.isEmpty() || tam > 0)
            {
                break;
            }else {
                tam++;
            }
        }

        Suplidor supli = null;

        if(tam > 0) {
            for (Document doc : resultadoConsulta) {
                supli = new Suplidor(
                        Long.valueOf(doc.get("codigoArticulo").toString()),
                        Long.valueOf(doc.get("codigoSuplidor").toString()),
                        Integer.valueOf(doc.get("tiempoEntrega").toString()),
                        new BigDecimal(doc.get("precioCompra").toString())
                );
            }
        }else {

            List<Document> listadoEtapas2 = new ArrayList<>();

            Document match2 =
                    new Document("codigoArticulo", idarti);

            listadoEtapas2.add(new Document("$match", match2));

            Document sort2 = new Document("$sort",  new Document("tiempoEntrega", 1)
                                                        .append("precioCompra", 1));

            listadoEtapas2.add(sort2);

            listadoEtapas2.add(new Document("$limit", 1));

            Document project3 =
                    new Document("_id", 0)
                            .append("codigoSuplidor", "$codigoSuplidor")
                            .append("tiempoEntrega","$tiempoEntrega")
                            .append("precioCompra","$precioCompra")
                            .append("codigoArticulo","$codigoArticulo");

            listadoEtapas2.add(new Document("$project", project3));


            AggregateIterable<Document> resultadoConsulta2 = suplidores.aggregate(listadoEtapas2);

            for (Document doc : resultadoConsulta2) {
                supli = new Suplidor(
                        Long.valueOf(doc.get("codigoArticulo").toString()),
                        Long.valueOf(doc.get("codigoSuplidor").toString()),
                        Integer.valueOf(doc.get("tiempoEntrega").toString()),
                        new BigDecimal(doc.get("precioCompra").toString())
                );
            }
        }
        return supli;
    }
}
