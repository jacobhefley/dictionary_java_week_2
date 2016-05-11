import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.allWords());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("word", word);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("id", id);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String definition = request.queryParams("definition");
      int id = Integer.parseInt(request.queryParams("id"));
      Word newWord = Word.find(id);
      newWord.addDefintion(definition);
      model.put("definition", definition);
      model.put("template", "templates/defsuccess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
