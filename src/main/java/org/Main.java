package org;

import com.mongodb.client.MongoCollection;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import org.Database.MongoDB;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {

        //******************************************************//
        //Base de datos

        MongoCollection<Document> collection = MongoDB.getDB().getCollection("inventario");
        System.out.println(collection.countDocuments());
        //******************************************************//

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("rutas"));
            config.enableCorsForAllOrigins();

        }).start(7000);

        app.get("/", ctx -> {
            ctx.redirect("/home");
        });

        app.error(404, ctx -> {
            ctx.redirect("/404.html");
        });
    }
}
