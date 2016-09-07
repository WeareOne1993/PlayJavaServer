package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.fasterxml.jackson.databind.JsonNode;

import dao.ProductDemoDAO;
import models.ProductDemo;
import models.StorageSearch;
import play.Logger;

@Repository
public class ProductDemoDAOImpl implements ProductDemoDAO
{
    private EntityManager entityManager;
    
    private static int maxDataSize;
    private static int maxWatchSize;
    private static int maxJewelrySize;

    private static List<StorageSearch> countListForSearchName = new ArrayList<StorageSearch>();
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    public int addProductDemo(JsonNode p)
    {
        Integer id = null;
        String name = p.findPath("name").asText();
        String type = p.findPath("type").asText();
        String brand = p.findPath("brand").asText();
        String model = p.findPath("model").asText();
        String gender = p.findPath("gender").asText();
        String movement = p.findPath("movement").asText();
        String watchLabel = p.findPath("watchLabel").asText();
        double caseSize = p.findPath("caseSize").asDouble();
        double caseThickness = p.findPath("caseThickness").asDouble();
        String caseMaterial = p.findPath("caseMaterial").asText();
        String caseShape = p.findPath("caseShape").asText();
        String dialType = p.findPath("dialType").asText();
        String dialColor = p.findPath("dialColor").asText();
        String crystal = p.findPath("crystal").asText();
        String waterResistance = p.findPath("waterResistance").asText();

        String metal = p.findPath("metal").asText();
        String clasp = p.findPath("clasp").asText();
        double chainLength = p.findPath("chainLength").asDouble();
        String chainType = p.findPath("chainType").asText();
        double width = p.findPath("width").asDouble();
        double length = p.findPath("length").asDouble();
        String rhodiumPlated = p.findPath("rhodiumPlated").asText();
        int numberOfCenterRoundDiamonds = p.findPath("numberOfCenterRoundDiamonds").asInt();
        double minimumCaratTotalWeight = p.findPath("minimumCaratTotalWeight").asDouble();
        String minimumColor = p.findPath("minimumColor").asText();
        String minimumClarity = p.findPath("minimumClarity").asText();
        String minimumCut = p.findPath("minimumCut").asText();
        String settingType = p.findPath("settingType").asText();

        double price = p.findPath("price").asDouble();
        String path = p.findPath("path").asText();
        
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

        if (type.equals("watch") && name != null && price != 0)
        {
            ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchLabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
            entityManager.persist(productDemo);
            
            maxDataSize = maxDataSize + 1;
            maxWatchSize = maxWatchSize + 1;
        }
        else if (type.equals("jewelry") && name != null && price != 0)
        {
            ProductDemo productDemo = new ProductDemo(name, type, brand, model, gender, movement, watchLabel, caseSize, caseThickness, caseMaterial, caseShape, dialType, dialColor, crystal, waterResistance, metal, clasp, chainLength, chainType, width, length, rhodiumPlated, numberOfCenterRoundDiamonds, minimumCaratTotalWeight, minimumColor, minimumClarity, minimumCut, settingType, price, path);
            entityManager.persist(productDemo);
            maxDataSize = maxDataSize + 1;
            maxJewelrySize = maxJewelrySize + 1;
        }
        else
            return 244;
        
        reCountListAfterAddOrUpdate(name);
        
        return 200;
    }

    public int updateProductDemo(JsonNode p)
    {
        int id = p.findPath("id").asInt();
        
        ProductDemo findProduct = entityManager.find(ProductDemo.class, id);
        
        if (findProduct == null)
        {
            return 245;
        }
        
        String oldName = findProduct.getName();
        String oldType = findProduct.getType();
        
        String name = p.findPath("name").asText();
        String type = p.findPath("type").asText();
        
        String brand = p.findPath("brand").asText();
        String model = p.findPath("model").asText();
        String gender = p.findPath("gender").asText();
        String movement = p.findPath("movement").asText();
        String watchLabel = p.findPath("watchLabel").asText();
        double caseSize = p.findPath("caseSize").asDouble();
        double caseThickness = p.findPath("caseThickness").asDouble();
        String caseMaterial = p.findPath("caseMaterial").asText();
        String caseShape = p.findPath("caseShape").asText();
        String dialType = p.findPath("dialType").asText();
        String dialColor = p.findPath("dialColor").asText();
        String crystal = p.findPath("crystal").asText();
        String waterResistance = p.findPath("waterResistance").asText();

        String metal = p.findPath("metal").asText();
        String clasp = p.findPath("clasp").asText();
        double chainLength = p.findPath("chainLength").asDouble();
        String chainType = p.findPath("chainType").asText();
        double width = p.findPath("width").asDouble();
        double length = p.findPath("length").asDouble();
        String rhodiumPlated = p.findPath("rhodiumPlated").asText();
        int numberOfCenterRoundDiamonds = p.findPath("numberOfCenterRoundDiamonds").asInt();
        double minimumCaratTotalWeight = p.findPath("minimumCaratTotalWeight").asDouble();
        String minimumColor = p.findPath("minimumColor").asText();
        String minimumClarity = p.findPath("minimumClarity").asText();
        String minimumCut = p.findPath("minimumCut").asText();
        String settingType = p.findPath("settingType").asText();

        double price = p.findPath("price").asDouble();
        String path = p.findPath("path").asText();
        
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

        findProduct.setName(name);
        findProduct.setType(type);
        findProduct.setBrand(brand);
        findProduct.setModel(model);
        findProduct.setGender(gender);
        findProduct.setMovement(movement);
        findProduct.setWatchLabel(watchLabel);
        findProduct.setCaseSize(caseSize);
        findProduct.setCaseThickness(caseThickness);
        findProduct.setCaseMaterial(caseMaterial);
        findProduct.setCaseShape(caseShape);
        findProduct.setDialType(dialType);
        findProduct.setDialColor(dialColor);
        findProduct.setCrystal(crystal);
        findProduct.setWaterResistance(waterResistance);
        findProduct.setMetal(metal);
        findProduct.setClasp(clasp);
        findProduct.setChainLength(chainLength);
        findProduct.setChainType(chainType);
        findProduct.setWidth(width);
        findProduct.setLength(length);
        findProduct.setRhodiumPlated(rhodiumPlated);
        findProduct.setNumberOfCenterRoundDiamonds(numberOfCenterRoundDiamonds);
        findProduct.setMinimumCaratTotalWeight(minimumCaratTotalWeight);
        findProduct.setMinimumColor(minimumColor);
        findProduct.setMinimumClarity(minimumClarity);
        findProduct.setMinimumCut(minimumCut);
        findProduct.setSettingType(settingType);
        findProduct.setPrice(price);
        findProduct.setPath(path);
        
        if (type.equals("watch") && name != null && price != 0)
        {
//            entityManager.merge(findProduct);
            
            if (oldType.equals("jewelry"))
            {
                maxWatchSize = maxWatchSize - 1;
                maxJewelrySize = maxJewelrySize + 1;
            }
        }
        else if (type.equals("jewelry") && name != null && price != 0)
        {
//            entityManager.merge(findProduct);
            
            if (oldType.equals("watch"))
            {
                maxWatchSize = maxWatchSize + 1;
                maxJewelrySize = maxJewelrySize - 1;
            }
        }
        else
            return 245;
        
        reCountListAfterRemove(oldName);
        reCountListAfterAddOrUpdate(name);
        
        return 200;
    }
    
    public int removeProductDemo(int id)
    {
        ProductDemo findProduct = entityManager.find(ProductDemo.class, id);
  

        if (findProduct == null)
        {
            return 246;
        }
        else
        {         
            String name = findProduct.getName();
            String type = findProduct.getType(); 
            
            entityManager.remove(findProduct);
            
            if (type.equals("watch"))
            {
                maxWatchSize = maxWatchSize - 1;
                maxDataSize = maxDataSize -1;
            }
            else if (type.equals("jewelry"))
            {
                maxJewelrySize = maxJewelrySize - 1;
                maxDataSize = maxDataSize -1;
            }
            
            reCountListAfterRemove(name);
            
            return 200;           
        }
    }
    
    public List<ProductDemo> returnProductsForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        
        if (TransactionSynchronizationManager.isActualTransactionActive() == true)
        {
            Logger.debug("return ProductForOnePage: there have a Transaction");
        }        
        
        List<ProductDemo> products;
        
        if (maxDataSize == 0)
        {
            products = new ArrayList<ProductDemo>();
            products.add(new ProductDemo(0, 0));
            
            return products;
        }
        else
        {
            if (maxDataSize%pageSize == 0)
                maxPageSize = (int) maxDataSize/pageSize;
            else
                maxPageSize = (int) maxDataSize/pageSize + 1;
            
            if (pageNumber > maxPageSize || pageNumber <= 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(maxPageSize, maxDataSize));
                
                return products;
            }
            else
            {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<ProductDemo> criteriaQuery = criteriaBuilder.createQuery(ProductDemo.class);
                Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
                products = entityManager.createQuery(criteriaQuery).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
                products.add(new ProductDemo(maxPageSize, maxDataSize));
                
//                entityManager.close();
                
                return products; 
            }           
        }
    }
    
    public List<ProductDemo> returnProductsWatchForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        
        List<ProductDemo> products;
        
        if (maxWatchSize == 0)
        {
            products = new ArrayList<ProductDemo>();
            products.add(new ProductDemo(0, 0));
            
            return products;
        }
        else
        {
            if (maxWatchSize%pageSize == 0)
                maxPageSize = (int) maxWatchSize/pageSize;
            else
                maxPageSize = (int) maxWatchSize/pageSize + 1;
            
            if (pageNumber > maxPageSize || pageNumber <= 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(maxPageSize, maxWatchSize));
                
                return products;
            }
            else
            {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<ProductDemo> criteriaQuery = criteriaBuilder.createQuery(ProductDemo.class);
                Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
                criteriaQuery.where(criteriaBuilder.equal(rootProductDemo.get("type"), "watch"));
                products = entityManager.createQuery(criteriaQuery).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
                products.add(new ProductDemo(maxPageSize, maxWatchSize));
                
                return products; 
            }           
        }
    }
    
    public List<ProductDemo> returnProductsJewelryForOnePage(int pageNumber, int pageSize)
    {
        int maxPageSize;
        
        List<ProductDemo> products;
        
        if (maxJewelrySize == 0)
        {
            products = new ArrayList<ProductDemo>();
            products.add(new ProductDemo(0, 0));
            
            return products;
        }
        else
        {
            if (maxJewelrySize%pageSize == 0)
                maxPageSize = (int) maxJewelrySize/pageSize;
            else
                maxPageSize = (int) maxJewelrySize/pageSize + 1;
            
            if (pageNumber > maxPageSize || pageNumber <= 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(maxPageSize, maxJewelrySize));
                
                return products;
            }
            else
            {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<ProductDemo> criteriaQuery = criteriaBuilder.createQuery(ProductDemo.class);
                Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
                criteriaQuery.where(criteriaBuilder.equal(rootProductDemo.get("type"), "jewelry"));
                products = entityManager.createQuery(criteriaQuery).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
                products.add(new ProductDemo(maxPageSize, maxJewelrySize));
                
                return products; 
            }           
        }
    }
    
    public List<ProductDemo> returnProductsForSearchNameForOnePage(int pageNumber, int pageSize, String name)
    {
        int countSize = 0;
        int maxPageSize;
        List<ProductDemo> products;
        boolean isFound = false;
        printCountList();
        
        if (countListForSearchName.size() == 0)
        {
            countSize = countDataWithCorrespondingName(name);
            countListForSearchName.add(new StorageSearch(name, countSize));
            isFound = true;
        }
        else
        {
            int index = 0;
            int maxSize = countListForSearchName.size();
            boolean isContinue = true;
            
            while (index < maxSize && isContinue == true)
            {
                if (countListForSearchName.get(index).getName().equals(name))
                {
                    isContinue = false;
                    countSize = countListForSearchName.get(index).getNumber();
                    isFound = true;
                }
                
                index = index + 1;
            }
        }
        
        if (isFound == false)
        {
            countSize = countDataWithCorrespondingName(name);
            countListForSearchName.add(new StorageSearch(name, countSize));
            isFound = true;
        }

        if (countSize == 0)
        {
            products = new ArrayList<ProductDemo>();
            products.add(new ProductDemo(0, 0));
            
            return products;
        }
        else
        {
            if (countSize%pageSize == 0)
                maxPageSize = (int) countSize/pageSize;
            else
                maxPageSize = (int) countSize/pageSize + 1;
            
            if (pageNumber > maxPageSize || pageNumber <= 0)
            {
                products = new ArrayList<ProductDemo>();
                products.add(new ProductDemo(maxPageSize, countSize));
                
                return products;
            }
            else
            {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<ProductDemo> criteriaQueryProductDemo = criteriaBuilder.createQuery(ProductDemo.class);
                Root<ProductDemo> rootProductDemo = criteriaQueryProductDemo.from(ProductDemo.class);
                criteriaQueryProductDemo.where(criteriaBuilder.like(rootProductDemo.get("name"), "%" + name + "%"));
                
                products = entityManager.createQuery(criteriaQueryProductDemo).setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize).getResultList();
                products.add(new ProductDemo(maxPageSize, countSize));
                
                return products;  
            }
        }
    }
    
    public List<ProductDemo> returnAmountOfProduct(int number)
    {
        List<ProductDemo> products;
        
        if (number <= 0)
        {
            products = new ArrayList<ProductDemo>();
            products.add(new ProductDemo(0, 0));
        }
        else
        {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<ProductDemo> criteriaQuery = criteriaBuilder.createQuery(ProductDemo.class);
            Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
            products = entityManager.createQuery(criteriaQuery).setFirstResult(0).setMaxResults(number).getResultList();
        }
        
        
        return products; 
    }
    
    public void getMaxDataSize()
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
        criteriaQuery.select(criteriaBuilder.count(rootProductDemo));
        
        maxDataSize = entityManager.createQuery(criteriaQuery).getSingleResult().intValue();
        Logger.debug("max data size = " + maxDataSize);

    }
    
    public void getMaxWatchSize()
    {
        if (TransactionSynchronizationManager.isActualTransactionActive() == true)
        {
            Logger.debug("get max WATCH size : there have a Transaction");
        }
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
        if (TransactionSynchronizationManager.isActualTransactionActive() == true)
        {
            Logger.debug("get max jewelry size : there have a Transaction");
        }
        maxJewelrySize = maxDataSize - maxWatchSize;
        Logger.debug("max jewelry size = " + maxJewelrySize);
    }

    public int countDataWithCorrespondingName(String name)
    {
        int countSize;
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<ProductDemo> rootProductDemo = criteriaQuery.from(ProductDemo.class);
        criteriaQuery.select(criteriaBuilder.count(rootProductDemo));
        criteriaQuery.where(criteriaBuilder.like(rootProductDemo.get("name"), "%" + name + "%"));
        
        countSize = entityManager.createQuery(criteriaQuery).getSingleResult().intValue();
        Logger.debug("max count Size = " + countSize); 
        
        return countSize;
    }

    public void printCountList()
    {
        Logger.debug("count List Size = " + countListForSearchName.size());
        
        for (int i = 0; i < countListForSearchName.size(); i++)
        {
            Logger.debug("name = " + countListForSearchName.get(i).getName() + "\tsize = " + countListForSearchName.get(i).getNumber());
        }
        
        System.out.println("\n");
    }
    
    public void reCountListAfterAddOrUpdate(String name)
    {
        for (int i = 0; i < countListForSearchName.size(); i ++)
        {
            if (name.toLowerCase().contains(countListForSearchName.get(i).getName().toLowerCase()) == true)
            {
                countListForSearchName.get(i).setNumber(countListForSearchName.get(i).getNumber()+1);
            }
        }
    }

    public void reCountListAfterRemove(String name)
    {
        for (int i = 0; i < countListForSearchName.size(); i ++)
        {
            if (name.toLowerCase().contains(countListForSearchName.get(i).getName().toLowerCase()) == true)
            {
                countListForSearchName.get(i).setNumber(countListForSearchName.get(i).getNumber()-1);
            }
        }       
    }
    
    public int checkTransactionisActive()
    {
        if (TransactionSynchronizationManager.isActualTransactionActive() == true)
        {
            Logger.debug("checkTransaction is active?? : there have a Transaction");
        }
        return 300;
    }
}
