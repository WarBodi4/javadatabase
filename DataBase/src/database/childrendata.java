
package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class childrendata {
    
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty fathername;
    private final StringProperty group1;
    private final StringProperty adress;
    private final StringProperty date;
    private final StringProperty garden;
    private final StringProperty images;
   // public Button updatebutton;
    
   

    
    public childrendata(String id,String name,String surname,String fathername,String date,String adress,String group1,String garden,String images){
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.fathername = new SimpleStringProperty(fathername);
        this.group1 = new SimpleStringProperty(group1);
        this.adress = new SimpleStringProperty(adress);
        this.date = new SimpleStringProperty(date);
        this.id = new SimpleStringProperty(id);
        this.garden = new SimpleStringProperty(garden); 
        this.images = new SimpleStringProperty(images);
        
    }
    

    public String getId()
  {
    return (String)this.id.get();
  }
  
  public String getName()
  {
    return (String)this.name.get();
  }
  
  public String getSurname()
  {
    return (String)this.surname.get();
  }
  
  public String getFathername()
  {
    return (String)this.fathername.get();
  }
  
  public String getDate()
  {
    return (String)this.date.get();
  }
 
  public String getAdress()
  {
    return (String)this.adress.get();
  }
  
  public String getGroup1()
  {
    return (String)this.group1.get();
  }
  
  public String getGarden()
  {
    return (String)this.garden.get();
  }
  
  public String getImages()
  {
    return (String)this.images.get();
  }
  
  public void setId(String value)
  {
    this.id.set(value);
  }
  
  public void setName(String value)
  {
    this.name.set(value);
  }
  
  public void setSurname(String value)
  {
    this.surname.set(value);
  }
  
  public void setFathername(String value)
  {
    this.fathername.set(value);
  }
  
  public void setDate(String value)
  {
    this.date.set(value);
  }
  
  public void setAdress(String value)
  {
    this.adress.set(value);
  }
  
  public void setGroup1(String value)
  {
    this.group1.set(value);
  }
  
   public void setGarden(String value)
  {
    this.garden.set(value);
  }
  
  public void setImages(String value)
  {
    this.images.set(value);
  }
  
  public StringProperty idProperty()
  {
    return this.id;
  }
  
  public StringProperty nameProperty()
  {
    return this.name;
  }
  
  public StringProperty surnameProperty()
  {
    return this.surname;
  }
  
  public StringProperty fathernameProperty()
  {
    return this.fathername;
  }
  
  public StringProperty dateProperty()
  {
    return this.date;
  }

  public StringProperty adressProperty()
  {
    return this.adress;
  }
  
  public StringProperty group1Property()
  {
    return this.group1;
  }
  
  public StringProperty gardenProperty()
  {
    return this.garden;
  }
  
  public StringProperty imagesProperty()
  {
    return this.images;
  }

//   public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}
