package database;

import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class groupdata {
    
    private final StringProperty idgrp;
    private final StringProperty namegrp;
    private final StringProperty lvlgrp;
    private final StringProperty teachergrp;
    private final StringProperty nursegrp;
    private final StringProperty countgrp;
    private final StringProperty imggrp;
  
   

    
    public groupdata(String idgrp,String namegrp,String lvlgrp,String teachergrp,String nursegrp,String countgrp,String imggrp){
        this.namegrp = new SimpleStringProperty(namegrp);
        this.lvlgrp = new SimpleStringProperty(lvlgrp);
        this.teachergrp = new SimpleStringProperty(teachergrp);
        this.nursegrp = new SimpleStringProperty(nursegrp);
        this.countgrp = new SimpleStringProperty(countgrp);
        this.idgrp = new SimpleStringProperty(idgrp);
        this.imggrp = new SimpleStringProperty(imggrp);
        
    }

    public String getIdgrp()
  {
    return (String)this.idgrp.get();
  }
  
  public String getNamegrp()
  {
    return (String)this.namegrp.get();
  }
  
  public String getLvlgrp()
  {
    return (String)this.lvlgrp.get();
  }
  
  public String getTeachergrp()
  {
    return (String)this.teachergrp.get();
  }
  
  public String getNursegrp()
  {
    return (String)this.nursegrp.get();
  }
 
  public String getCountgrp()
  {
    return (String)this.countgrp.get();
  }
  
  public String getImggrp()
  {
      return (String)this.imggrp.get();
  }
  
  
  public void setIdgrp(String value)
  {
    this.idgrp.set(value);
  }
  
  public void setNamegrp(String value)
  {
    this.namegrp.set(value);
  }
  
  public void setLvlgrp(String value)
  {
    this.lvlgrp.set(value);
  }
  
  public void setTeachergrp(String value)
  {
    this.teachergrp.set(value);
  }
  
  public void setNursegrp(String value)
  {
    this.nursegrp.set(value);
  }
  
  public void setCountgrp(String value)
  {
    this.countgrp.set(value);
  }
  
  public void setImggrp(String value)
  {
    this.imggrp.set(value);
  }
  
  public StringProperty idgrpProperty()
  {
    return this.idgrp;
  }
  
  public StringProperty namegrpProperty()
  {
    return this.namegrp;
  }
  
  public StringProperty lvlgrpProperty()
  {
    return this.lvlgrp;
  }
  
  public StringProperty teachergrpProperty()
  {
    return this.teachergrp;
  }
  
  public StringProperty nursegrpProperty()
  {
    return this.nursegrp;
  }
  
  public StringProperty countgrpProperty()
  {
    return this.countgrp;
  }
  
  public StringProperty imggrpProperty()
  {
    return this.imggrp;
  }

//    public Button getUpdatebutton() {
//        return updatebutton;
//    }
//
//    public void setUpdatebutton(Button updatebutton) {
//        this.updatebutton = updatebutton;
//    }

 
    
    
    
   
}

