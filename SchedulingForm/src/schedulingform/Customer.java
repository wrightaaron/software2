/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingform;

/**
 *
 * @author Aaron
 */
public class Customer {
   private String name;
   private String street;
   private String city;
   private String country;
   private int id;

   /**
    * Part Constructor for all classes extending the Part class
    * @param name
    * @param partID
    * @param price
    * @param instock
    * @param min
    * @param max 
    */
   public Customer(int id, String name, String street, String city, String country) {
      this.name = name;
      this.street = street;
      this.city = city;
      this.country = country;
      this.id = id;
   }
   
   public Customer(String name, String street, String city, String country) {
      this.name = name;
      this.street = street;
      this.city = city;
      this.country = country;
   }
   /**
    * Sets the part name
    * @param name 
    */
   public void setName(String name)
   {
       this.name = name;
   }
   
   /**
    * returns the part name
    * @return 
    */
   public String getName()
   {
       return this.name;
   }
   
   /**
    * Sets the price of the part
    * @param price 
    */
   public void setStreet(String street)
   {
       this.street = street;
   }
   
   /**
    * Returns the price of the part
    * @return 
    */
   public String getStreet()
   {
       return this.street;
   }
   
   /**
    * Sets the inventory level of the part
    * @param instock 
    */
   public void setCity(String city)
   {
       this.city = city;
   }
   
   /**
    * Returns the inventory level of the part
    * @return 
    */
   public String getCity()
   {
       return this.city;
   }
   
   /**
    * Sets the minimum inventory level of the part
    * @param min 
    */
   public void setCountry(String country)
   {
       this.country = country;
   }
   
   /**
    * Returns the minimum inventory level for the part
    * @return 
    */
   public String getCountry()
   {
       return this.country;
   }
   
   /**
    * Sets the part ID
    * @param partID 
    */
   public void setCustID(int id)
   {
       this.id = id;
   }
   
   /**
    * Returns the part ID
    * @return 
    */
   public int getCustID()
   {
       return this.id;
   }
}