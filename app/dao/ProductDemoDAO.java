package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;

import dao.impl.ProductDemoDAOImpl;
import models.ProductDemo;

@Repository
public interface ProductDemoDAO 
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
