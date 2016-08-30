package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import dao.ProductDemoDAO;
import models.ProductDemo;
import play.Logger;

@Service
public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private EntityManager entityManager;
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    public int addProductDemo(JsonNode p)
    {
        Integer id = null;
        String name = p.findPath("name").asText();
        Logger.debug("frist name = " + name);
        
        String type = p.findPath("type").asText();
        Logger.debug("frist type = " + type);
        String brand = p.findPath("brand").asText();
        Logger.debug("frist brand = " + brand);
        String model = p.findPath("model").asText();
        Logger.debug("frist model = " + model);
        String gender = p.findPath("gender").asText();
        Logger.debug("frist gender = " + gender);
        String movement = p.findPath("movement").asText();
        Logger.debug("frist movement = " + movement);
        
        String watchLabel = p.findPath("watchLabel").asText();
        Logger.debug("frist watchLabel = " + watchLabel);
        
        double caseSize = p.findPath("caseSize").asDouble();
        Logger.debug("frist caseSize = " + caseSize);
        
        double caseThickness = p.findPath("caseThickness").asDouble();
        Logger.debug("frist caseThickness = " + caseThickness);
        
        String caseMaterial = p.findPath("caseMaterial").asText();
        Logger.debug("frist caseMaterial = " + caseMaterial);
        
        String caseShape = p.findPath("caseShape").asText();
        Logger.debug("frist caseShape = " + caseShape);
        
        String dialType = p.findPath("dialType").asText();
        Logger.debug("frist dialType = " + dialType);
        
        String dialColor = p.findPath("dialColor").asText();
        Logger.debug("frist dialColor = " + dialColor);
        
        String crystal = p.findPath("crystal").asText();
        Logger.debug("frist crystal = " + crystal);
        
        String waterResistance = p.findPath("waterResistance").asText();
        Logger.debug("frist waterResistance = " + waterResistance);
        
        
        String metal = p.findPath("metal").asText();
        Logger.debug("frist metal = " + metal);
        
        String clasp = p.findPath("clasp").asText();
        Logger.debug("frist clasp = " + clasp);
        
        double chainLength = p.findPath("chainLength").asDouble();
        Logger.debug("frist chainLength = " + chainLength);
        
        String chainType = p.findPath("chainType").asText();
        Logger.debug("frist chainType = " + chainType);
        
        double width = p.findPath("width").asDouble();
        Logger.debug("frist width = " + width);
        
        double length = p.findPath("length").asDouble();
        Logger.debug("frist length = " + length);
        
        String rhodiumPlated = p.findPath("rhodiumPlated").asText();
        Logger.debug("frist rhodiumPlated = " + rhodiumPlated);
        
        int numberOfCenterRoundDiamonds = p.findPath("numberOfCenterRoundDiamonds").asInt();
        Logger.debug("frist numberOfCenterRoundDiamonds = " + numberOfCenterRoundDiamonds);
        
        double minimumCaratTotalWeight = p.findPath("minimumCaratTotalWeight").asDouble();
        Logger.debug("frist minimumCaratTotalWeight = " + minimumCaratTotalWeight);
        
        String minimumColor = p.findPath("minimumColor").asText();
        Logger.debug("frist minimumColor = " + minimumColor);
        
        String minimumClarity = p.findPath("minimumClarity").asText();
        Logger.debug("frist minimumClarity = " + minimumClarity);
        
        String minimumCut = p.findPath("minimumCut").asText();
        Logger.debug("frist minimumCut = " + minimumCut);
        
        String settingType = p.findPath("settingType").asText();
        Logger.debug("frist settingType = " + settingType);
        
        double price = p.findPath("price").asDouble();
        Logger.debug("frist price = " + price);
        
        String path = p.findPath("path").asText();
        Logger.debug("frist path = " + path);
        
        if (name == "")
            name = null;
        if (type == "")
            type = null;
        if (brand == "")
            brand = null;
        if (model == "")
            model = null;
        if (gender == "")
            gender = null;
        if (movement == "")
            movement = null;
        if (watchLabel == "")
            watchLabel = null;
        if (caseMaterial == "")
            caseMaterial = null;
        if (caseShape == "")
            caseShape = null;
        if (dialType == "")
            dialType = null;
        if (dialColor == "")
            dialColor = null;
        if (crystal == "")
            crystal = null;
        if (waterResistance == "")
            waterResistance = null;
        if (metal == "")
            metal = null;
        if (clasp == "")
            clasp = null;
        if (chainType == "")
            chainType = null;
        if (rhodiumPlated == "")
            rhodiumPlated = null;
        if (minimumColor == "")
            minimumColor = null;
        if (minimumClarity == "")
            minimumClarity = null;
        if (minimumCut == "")
            minimumCut = null;
        if (settingType == "")
            settingType = null;
        if (path == "")
            path = null;

        
        
        Logger.debug("name = " + name + "  type = " + type + "  price = " + price);
        
        if (name == null)
        {
            name = null;
        }
        
        
        System.out.println("type = " + type);
        
        if (type.equals("watch"))
        {
            Logger.debug("equal watch ne");
        }
        
        if (type == "watch")
        {
            Logger.debug("== watch luon");
        }
        
        if (!name.equals(null))
        {
            Logger.debug("# null ne");
        }
        if (price != 0)
        {
            Logger.debug(" # 0 ne");
        }
        
        if (type.equals("watch") && !name.equals(null) && price != 0)
        {
            Logger.debug("watch ne");
            ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchLabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
            entityManager.persist(productDemo);
            maxDataSize = maxDataSize + 1;
            maxWatchSize = maxWatchSize + 1;
            Logger.debug("xong cai dong ho");
        }
        else if (type.equals("jewelry") && !name.equals(null) && price != 0)
        {
            
            Logger.debug("trang cmn suc");
            ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchLabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
            entityManager.persist(productDemo);
            maxDataSize = maxDataSize + 1;
            maxJewelrySize = maxJewelrySize + 1;
            Logger.debug("oay xugn luon");
        }
        else
            return 244;
        
        return 200;
    }

    
    public void getMaxDataSize()
    {
        //CriteriaQuery<ProductDemo> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Long.class);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
//        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(ProductDemo.class)));
        criteriaQuery.select(criteriaBuilder.count(rootProductDemo));
        
        maxDataSize = entityManager.createQuery(criteriaQuery).getSingleResult().intValue();
        Logger.debug("max data size = " + maxDataSize);
    }
    
    public void getMaxWatchSize()
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
        criteriaQuery.select(criteriaBuilder.count(rootProductDemo));
        criteriaQuery.where(criteriaBuilder.equal(rootProductDemo.get("type"), "watch"));
        
        maxWatchSize = entityManager.createQuery(criteriaQuery).getSingleResult().intValue();
        Logger.debug("max watch Size = " + maxWatchSize);
        
    }
    
    public void getMaxJewelrySize()
    {
        maxJewelrySize = maxDataSize - maxWatchSize;
        Logger.debug("max jewelry size = " + maxJewelrySize);
    }

}
