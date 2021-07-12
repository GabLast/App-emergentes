package org.Controllers;

import io.javalin.Javalin;

public class MainController {

    Javalin app;

    public MainController(Javalin app) {
        this.app = app;
    }

    public void routes() {

        app.routes(() -> {



        });
    }
}
