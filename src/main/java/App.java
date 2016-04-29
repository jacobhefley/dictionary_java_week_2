// import java.util.Map;
// import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String homePhone = request.queryParams("homePhone");
      String mobilePhone = request.queryParams("mobilePhone");
      String workPhone = request.queryParams("workPhone");
      String address = request.queryParams("address");
      String email = request.queryParams("email");
      Contact newContact = new Contact(firstName, lastName, homePhone, mobilePhone, workPhone, address, email);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("contacts", Contact.all());
      model.put("template", "templates/contacts.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contactsupdated", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String homePhone = request.queryParams("homePhone");
      String mobilePhone = request.queryParams("mobilePhone");
      String workPhone = request.queryParams("workPhone");
      String address = request.queryParams("address");
      String email = request.queryParams("email");
      int id = Integer.parseInt(request.queryParams("id"));
      Contact newContact = new Contact(firstName, lastName, homePhone, mobilePhone, workPhone, address, email, id);
      model.put("template", "templates/contactsupdated.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/contacts/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      model.put("contact", contact);
      model.put("template", "templates/contact.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
