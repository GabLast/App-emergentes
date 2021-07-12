package org.Database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoDB {

    public static MongoClient connection;

    public static MongoClient connect() {
        if (connection == null) {
            connection = MongoClients.create("mongodb://localhost:27017");
        }

        return connection;
    }

    public static MongoDatabase getDB() {

        //------------- Obtener objeto de una base datos -------------//
        return connect().getDatabase("compras");
    }

    public static void stopDB() {
        if (connection != null) {
            connection.close();
        }
    }
}
