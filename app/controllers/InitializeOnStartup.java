package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import play.Logger;
import services.ProductDemoService;

@Component
public class InitializeOnStartup implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private ProductDemoService productDemoService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0)
    {
        this.productDemoService.initializeListProduct();
        this.productDemoService.getMaxDataSize();
        this.productDemoService.getMaxWatchSize();
        this.productDemoService.getMaxJewelrySize();
        Logger.debug("initialization finished!");
    }

}
