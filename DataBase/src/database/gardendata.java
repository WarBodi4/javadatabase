package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class gardendata {
    
    private final StringProperty idkd;
    private final StringProperty namekd;
    private final StringProperty contactkd;
    private final StringProperty headkd;
    private final StringProperty countkd;
    private final StringProperty imgkd;
  
   

    
    public gardendata(String idkd,String namekd,String contactkd,String headkd,String countkd,String imgkd){
        this.namekd = new SimpleStringProperty(namekd);
        this.contactkd = new SimpleStringProperty(contactkd);
        this.headkd = new SimpleStringProperty(headkd);
        this.countkd = new SimpleStringProperty(countkd);
        this.idkd = new SimpleStringProperty(idkd);
        this.imgkd = new SimpleStringProperty(imgkd);
    }

    public String getIdkd()
  {
    return (String)this.idkd.get();
  }
  
  public String getNamekd()
  {
    return (String)this.namekd.get();
  }
  
  public String getContactkd()
  {
    return (String)this.contactkd.get();
  }
  
  public String getHeadkd()
  {
    return (String)this.headkd.get();
  }
  
  public String getCountkd()
  {
    return (String)this.countkd.get();
  }
  
  public String getImgkd()
  {
    return (String)this.imgkd.get();
  }
  
  
  public void setIdkd(String value)
  {
    this.idkd.set(value);
  }
  
  public void setNamekd(String value)
  {
    this.namekd.set(value);
  }
  
  public void setHeadkd(String value)
  {
    this.headkd.set(value);
  }
  
  public void setContactkd(String value)
  {
    this.contactkd.set(value);
  }
  
  public void setCountkd(String value)
  {
    this.countkd.set(value);
  }
  
  public void setImgkd(String value)
  {
    this.imgkd.set(value);
  }
  
  public StringProperty idkdProperty()
  {
    return this.idkd;
  }
  
  public StringProperty namekdProperty()
  {
    return this.namekd;
  }
  
  public StringProperty contactkdProperty()
  {
    return this.contactkd;
  }
  
  public StringProperty headkdProperty()
  {
    return this.headkd;
  }
  
  public StringProperty countkdProperty()
  {
    return this.countkd;
  }
  
  public StringProperty imgkdProperty()
  {
    return this.imgkd;
  }
  

//    public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}

