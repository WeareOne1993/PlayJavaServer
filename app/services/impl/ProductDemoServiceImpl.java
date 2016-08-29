package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ProductDemo addProductDemo(ProductDemo p) {
        return this.productDemoDAO.addProductDemo(p);
    }
    
    @Transactional
    public List<ProductDemo> listProductDemo()
    {
        return this.productDemoDAO.listProductDemo();
    }
    
    @Transactional
    public void initializeListProduct()
    {
        this.productDemoDAO.initializeListProduct();
    }
    
    public void getMaxDataSize()
    {
        this.productDemoDAO.getMaxDataSize();
    }
    
    public void getMaxWatchSize()
    {
        this.productDemoDAO.getMaxWatchSize();
    }
    
    public void getMaxJewelrySize()
    {
        this.productDemoDAO.getMaxJewelrySize();
    }
}
