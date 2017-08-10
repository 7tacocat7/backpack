
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
            ArrayList<Backpack> backpacks = Backpack.getAll();
            model.put("posts", backpacks);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            boolean mapBoolean = Boolean.parseBoolean(request.params("mapBoolean"));
            int wallet = Integer.parseInt(request.queryParams("wallet"));
//            System.out.println("Wallet Value: " + wallet);
            String content = request.queryParams("content");
            Backpack newBackpack = new Backpack(mapBoolean,content,wallet);
            model.put("post",newBackpack);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Backpack foundBackpack = Backpack.findById(idOfPostToFind); //use it to find backpack
            model.put("post", foundBackpack); //add it to model for template to display
            return new ModelAndView(model, "post-form.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
        get("/posts", (req, res) -> {
            Map<String , Object> model = new HashMap<>();
            ArrayList<Backpack> backpacks = Backpack.getAll();
            model.put("posts", backpacks);
            return new ModelAndView(model, "allPosts.hbs");
        }, new HandlebarsTemplateEngine());
    }

}