package models;

import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bar {

    @Id
    @GeneratedValue
    @Column(name="id")
    public int id;

    @Constraints.Required(message = "The name is required")
    @Column(name="name")
    public String name;

}