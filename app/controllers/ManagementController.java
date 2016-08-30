package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.JsonNode;

import models.ProductDemo;
import models.ResponseStatus;
import play.libs.Json;
import play.mvc.Http.Request;
import play.mvc.Result;
import services.ProductDemoService;

@Controller
public class ManagementController
{
    @Autowired
    private ProductDemoService productDemoService;
    
   
    
    /*
     * add new product to database
     * return: added product ID
     * URL   : localhost:9000/product/add
     * method: POST
     * */
    public Result addProductDemo()
    {
        JsonNode jsonProductDemo = play.mvc.Controller.request().body().asJson();
        ResponseStatus reponseStatus;

        if (jsonProductDemo == null)
        {
            return play.mvc.Controller.badRequest("Expecting a json body");
        }
        else
        {
            if (this.productDemoService.addProductDemo(jsonProductDemo) == 200)
                reponseStatus = new ResponseStatus(200, "Ok, added!");
            else
                reponseStatus = new ResponseStatus(244, "fail to add new product");
            
            return play.mvc.Controller.ok(Json.toJson(reponseStatus)); 
        }
    }
}
