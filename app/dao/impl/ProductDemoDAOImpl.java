package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;

import dao.ProductDemoDAO;
import models.ProductDemo;
import play.Logger;

@Service
public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private EntityManager entityManager;
    private static List<ProductDemo> initializedListProductDemo;
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    public ProductDemo addProductDemo(ProductDemo p)
    {
        Integer id = null;
        String name = p.getName();
        String type = p.getType();
        String brand = p.getBrand();
        String model = p.getModel();
        String gender = p.getGender();
        String movement = p.getMovement();
        String watchLabel = p.getWatchLabel();
        double caseSize = p.getCaseSize();
        double caseThickness = p.getCaseThickness();
        String caseMaterial = p.getCaseMaterial();
        String caseShape = p.getCaseShape();
        String dialType = p.getDialType();
        String dialColor = p.getDialColor();
        String crystal = p.getCrystal();
        String waterResistance = p.getWaterResistance();
        
        String metal = p.getMetal();
        String clasp = p.getClasp();
        double chainLength = p.getChainLength();
        String chainType = p.getChainType();
        double width = p.getWidth();
        double length = p.getLength();
        String rhodiumPlated = p.getRhodiumPlated();
        int numberOfCenterRoundDiamonds = p.getNumberOfCenterRoundDiamonds();
        double minimumCaratTotalWeight = p.getMinimumCaratTotalWeight();
        String minimumColor = p.getMinimumColor();
        String minimumClarity = p.getMinimumClarity();
        String minimumCut = p.getMinimumCut();
        String settingType = p.getSettingType();
        
        double price = p.getPrice();
        String path = p.getPath();
        
        ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchLabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
        
        if (type.equals("watch") && !name.equals(null) && price != 0)
        {
            entityManager.persist(productDemo);
            maxDataSize = maxDataSize + 1;
            maxWatchSize = maxWatchSize + 1;
        }
        else if (type.equals("jewelry") && !name.equals(null) && price != 0)
        {
            entityManager.persist(productDemo);
            maxDataSize = maxDataSize + 1;
            maxJewelrySize = maxJewelrySize + 1;
        }

        return productDemo;
    }
    
    
    public List<ProductDemo> listProductDemo()
    {
        return initializedListProductDemo;
    }
    
    public void initializeListProduct()
    {
        Logger.debug("calling initialize list product demo");
        CriteriaQuery<ProductDemo> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ProductDemo.class);
        criteriaQuery.from(ProductDemo.class);
        initializedListProductDemo = entityManager.createQuery(criteriaQuery).getResultList();
    }
    
    public void getMaxDataSize()
    {
        maxDataSize = initializedListProductDemo.size();
    }
    
    public void getMaxWatchSize()
    {
        maxWatchSize = 0;
        int index = 0;
        int listSize = initializedListProductDemo.size();
        
        while (index < listSize)
        {
            if (initializedListProductDemo.get(index).getType().equals("watch"))
            {
                maxWatchSize = maxWatchSize + 1;
            }
            
            index = index + 1;
        }
    }
    
    public void getMaxJewelrySize()
    {
        maxJewelrySize = initializedListProductDemo.size() - maxWatchSize;
    }
}
