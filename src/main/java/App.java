
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Backpack;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        post("/posts/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            boolean mapBoolean = Boolean.parseBoolean(request.params("mapBoolean"));
            int wallet = Integer.parseInt(request.queryParams("wallet"));
//            System.out.println("Wallet Value: " + wallet);
            String content = request.queryParams("content");
            Backpack newBackpack = new Backpack(mapBoolean,content,wallet);
            model.put("post",newBackpack);
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());

    }

}