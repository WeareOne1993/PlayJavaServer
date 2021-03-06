package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;

import dao.ProductDemoDAO;
import models.ProductDemo;
import services.ProductDemoService;

@Service
public class ProductDemoServiceImpl implements ProductDemoService
{
    private ProductDemoDAO productDemoDAO;

    @Autowired
    public void setProductDemoDAO(ProductDemoDAO productDemoDAO) {
        this.productDemoDAO = productDemoDAO;
    }

 
    @Transactional
    public int addProductDemo(JsonNode p) 
    {
        return this.productDemoDAO.addProductDemo(p);
    }
    
    @Transactional
    public int updateProductDemo(JsonNode p)
    {
        return this.productDemoDAO.updateProductDemo(p);
    }
    
    @Transactional
    public int removeProductDemo(int id)
    {
        return this.productDemoDAO.removeProductDemo(id);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsWatchForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        return this.productDemoDAO.returnProductsJewelryForOnePage(pageNumber, pageSize);
    }
    
    @Transactional
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        return this.productDemoDAO.returnProductsForSearchNameForOnePage(pageNumber, pageSize, name);
    }
    
    @Transactional
    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        return this.productDemoDAO.returnAmountOfProduct(number);
    }
    
    @Transactional
    public void getMaxDataSize()
    {
        this.productDemoDAO.getMaxDataSize();
    }
    
    @Transactional
    public void getMaxWatchSize()
    {
        this.productDemoDAO.getMaxWatchSize();
    }
    
    public void getMaxJewelrySize()
    {
        this.productDemoDAO.getMaxJewelrySize();
    }
    
    @Transactional
    public int checkTransactionisActive()
    {
        return this.productDemoDAO.checkTransactionisActive();
    }
}
