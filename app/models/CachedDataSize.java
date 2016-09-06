package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cachedDataSize")
public class CachedDataSize
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="number")
    private int number;
    
    public CachedDataSize()
    {
        
    }
    
    public CachedDataSize(String name, int number)
    {
        this.name = name;
        this.number = number;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    
}
