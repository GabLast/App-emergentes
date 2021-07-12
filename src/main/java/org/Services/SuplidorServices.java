package org.Services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.Database.MongoDB;
import org.Models.Suplidor;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
                BigDecimal precioCompra = new BigDecimal(result.getInteger("precioCompra"));

                Suplidor aux = new Suplidor(codigoArticulo, codigoSuplidor, tiempoEntrega, precioCompra);

                lista.add(aux);
            }
        } finally {
            suplidoresCursor.close();
        }
        return lista;
    }
}
