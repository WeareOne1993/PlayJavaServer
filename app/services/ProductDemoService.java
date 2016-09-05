package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import models.ProductDemo;

public interface ProductDemoService
{
    public int addProductDemo(JsonNode p);
    public int updateProductDemo(JsonNode p);
    public int removeProductDemo(int id);
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize);
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize);
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize);
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name);
    public List<ProductDemo> returnAmountOfProduct(int number);
    public void getMaxDataSize();
    public void getMaxWatchSize();
    public void getMaxJewelrySize();
}
