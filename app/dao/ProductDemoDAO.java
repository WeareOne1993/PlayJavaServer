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
    
//    public int getIsActiveCountData();
//    public int getIsActiveCountWatch();
//    public int getIsActiveCountJewelry();
    
//    public void setMaxDataSize(int maxDataSize);
//    public void setMaxWatchSize(int maxWatchSize);
//    public void setMaxJewelrySize(int maxJewelrySize);
    
//    public void setIsActiveCountData(int number);
//    public void setIsActiveCountWatch(int number);
//    public void setIsActiveCountJewelry(int number);
//    
//    public String getCurrentTimeStamp();
//    public void getInfoMemory();
 
}
