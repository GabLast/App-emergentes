package org.Services;

import com.mongodb.client.*;
import org.Database.MongoDB;
import org.Models.Articulo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ArticuloServices {

    private MongoCollection<Document> articulos = MongoDB.getDB().getCollection("articulos");

    public void insertArticulo(Articulo articulo) {

        Document arti = new Document();
        arti.put("codigoArticulo", articulo.getCodigoArticulo());
        arti.put("descripcion", articulo.getDescripcion());
        arti.put("unidadCompra", articulo.getUnidadCompra());
        arti.put("balanceActual", articulo.getBalanceActual());

        articulos.insertOne(arti);
    }

    public List<Articulo> getArticulos(){

        MongoCursor<Document> cursor = articulos.find().iterator();
        Document result;

        List<Articulo> articulosLista = new ArrayList<>();
        try{
            while(cursor.hasNext()){
                result = cursor.next();
                Long codigoArticulo = result.getLong("codigoArticulo");
                String descripcion = result.get("descripcion").toString();
                int balanceActual = result.getInteger("balanceActual");
                String unidad = result.get("unidadCompra").toString();

                Articulo aux = new Articulo(codigoArticulo, descripcion, unidad, balanceActual);
                articulosLista.add(aux);
            }
        } finally {
            cursor.close();
        }

        return articulosLista;
    }

    public void updateArticulo(long codigoArticulo, int cantidad, String tipoEntrada){

        if(tipoEntrada.equalsIgnoreCase("ENTRADA")){
            articulos.findOneAndUpdate(
                    eq("codigoArticulo", codigoArticulo),
                    new Document("$inc", new Document("balanceActual", cantidad))
            );
        }
        else if(tipoEntrada.equalsIgnoreCase("SALIDA")){
            articulos.findOneAndUpdate(
                    eq("codigoArticulo", codigoArticulo),
                    new Document("$inc", new Document("balanceActual", -1 * cantidad))
            );
        }

    }
}
