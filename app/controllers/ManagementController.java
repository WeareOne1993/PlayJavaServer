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
    private int pageSize = 8;
    
    @Autowired
    private ProductDemoService productDemoService;
    
   
    
    /*
     * add new product to database
     * return: status
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
    
    
    
    /*
     * update an exist product from database
     * return: 200 if ok - 245 if update failed
     * URL   : localhost:9000/product/update
     * method: PUT
     * */
    public Result updateProductDemo()
    {
        JsonNode jsonProductDemo = play.mvc.Controller.request().body().asJson();
        ResponseStatus reponseStatus;

        if (jsonProductDemo == null)
        {
            return play.mvc.Controller.badRequest("Expecting a json body");
        }
        else
        {
            if (this.productDemoService.updateProductDemo(jsonProductDemo) == 200)
                reponseStatus = new ResponseStatus(200, "Ok, updated!");
            else
                reponseStatus = new ResponseStatus(245, "fail to update product");
            
            return play.mvc.Controller.ok(Json.toJson(reponseStatus)); 
        }
    }
    
    
    
    /*
     * remove an exist product from database
     * return: 200 if ok - 246 if remove failed
     * URL   : localhost:9000/product/remove/{id}
     * method: DELETE
     * */
    public Result removeProductDemo(int id)
    {
        ResponseStatus reponseStatus;

        if (this.productDemoService.removeProductDemo(id) == 200)
            reponseStatus = new ResponseStatus(200, "Ok, removed!");
        else
            reponseStatus = new ResponseStatus(246, "fail to remove product");
        
        return play.mvc.Controller.ok(Json.toJson(reponseStatus)); 
    }
    
    
    
    /*
     * return list of products corresponding with page number called
     * return: list productDemo
     * URL   : localhost:9000/product/page/{pageNumber}
     * method: GET
     * */
    public Result returnProductsForOnePage(Integer pageNumber)
    {
        ResponseStatus reponseStatus;

        List<ProductDemo> products = this.productDemoService.returnProductsForOnePage(pageNumber, pageSize);
        
        return play.mvc.Controller.ok(Json.toJson(products)); 
    }
    
    
    
    /*
     * return list of watch corresponding with page number called
     * return: list watch 
     * URL   : localhost:9000/product/watch/page/{pageNumber}
     * method: GET
     * */
    public Result returnProductsWatchForOnePage(Integer pageNumber)
    {
        ResponseStatus reponseStatus;

        List<ProductDemo> products = this.productDemoService.returnProductsWatchForOnePage(pageNumber, pageSize);
        
        return play.mvc.Controller.ok(Json.toJson(products)); 
    }
    
    
    
    /*
     * return list of jewelry corresponding with page number called
     * return: list jewelry 
     * URL   : localhost:9000/product/watch/page/{pageNumber}
     * method: GET
     * */
    public Result returnProductsJewelryForOnePage(Integer pageNumber)
    {
        ResponseStatus reponseStatus;

        List<ProductDemo> products = this.productDemoService.returnProductsJewelryForOnePage(pageNumber, pageSize);
        
        return play.mvc.Controller.ok(Json.toJson(products)); 
    }
    
    
    
    /*
     * return list of products corresponding with page number and name called
     * return: list products 
     * URL   : localhost:9000/product/page=pageNumber&name=name
     * method: GET
     * */
    public Result returnProductsForSearchNameForOnePage(Integer pageNumber, String name)
    {
        ResponseStatus reponseStatus;

        List<ProductDemo> products = this.productDemoService.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
        
        return play.mvc.Controller.ok(Json.toJson(products)); 
    }
    
    
    
    /*
     * return list of products corresponding with number called
     * return: list products 
     * URL   : localhost:9000/product/{number}
     * method: GET
     * */
    public Result returnAmountOfProduct(int number)
    {
        List<ProductDemo> products = this.productDemoService.returnAmountOfProduct(number);
        
        return play.mvc.Controller.ok(Json.toJson(products)); 
    }
}
