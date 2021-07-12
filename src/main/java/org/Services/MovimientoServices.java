package org.Services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.Database.MongoDB;
import org.Models.Articulo;
import org.Models.MovimientoInventario;
import org.Models.Suplidor;
import org.bson.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        movi.put("fechaMovmiento", movimiento.getFechaMovimiento());

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
}
