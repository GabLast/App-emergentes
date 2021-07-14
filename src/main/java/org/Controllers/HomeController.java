package org.Controllers;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HomeController {
    Javalin app;

    public HomeController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {

            path("/home", () -> {
                get(ctx -> {
                    Map<String, Object> freeMarkerVars = new HashMap<>();
                    freeMarkerVars.put("title", "Home");
                    ctx.render("/templates/Home.ftl", freeMarkerVars);
                });
            });
        });
    }
}
