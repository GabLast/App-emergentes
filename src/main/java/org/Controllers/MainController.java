package org.Controllers;

import com.mongodb.client.MongoCollection;
import io.javalin.Javalin;
import org.Database.MongoDB;
import org.bson.Document;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class MainController {

    Javalin app;

    public MainController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            before(ctx -> {

            });

            path("/home", () -> {
//                long id = ctx.pathParam("id", Long.class).get();
            });

        });
    }
}
