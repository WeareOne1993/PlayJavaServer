package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import models.ProductDemo;
import play.libs.Json;
import play.mvc.Result;
import services.ProductDemoService;

@Controller
public class ManagementController
{
    @Autowired
    private ProductDemoService productDemoService;
    
    
    /*
     *return list all of products
     *URL   : localhost:9000/products
     *method: GET 
     * */
    public Result listProductDemo()
    {
        List<ProductDemo> listProductDemo = this.productDemoService.listProductDemo();
        
        return play.mvc.Controller.ok(Json.toJson(listProductDemo));
    }
    
    
    /*
     * add new product to database
     * return: added product ID
     * URL   : localhost:9000/product/add
     * method: POST
     * */
    public Result addProductDemo(ProductDemo productDemo)
    {
        ProductDemo p = this.productDemoService.addProductDemo(productDemo);
        return play.mvc.Controller.ok(Json.toJson(p));
    }
}
