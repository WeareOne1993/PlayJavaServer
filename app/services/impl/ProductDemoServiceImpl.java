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
    public int addProductDemo(JsonNode p) {
        return this.productDemoDAO.addProductDemo(p);
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
}
