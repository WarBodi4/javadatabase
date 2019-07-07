/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Window;


/**
 *
 * @author bodi4
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TextField searchChildren;
     @FXML
    private TextField searchGroup;
     @FXML
    private TextField searchGarden;   
     
    
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField fathername;
    @FXML
    private DatePicker date;
    @FXML
    private TextField adress;
    @FXML
    private TextField group1;
    @FXML
    private TextField garden;
    @FXML
    private TextField images;
    @FXML
    private Button updatebutton;
    
    @FXML
    private TextField idgrp;
    @FXML
    private TextField namegrp;
    @FXML
    private TextField lvlgrp;
    @FXML
    private TextField teachergrp;
    @FXML
    private TextField nursegrp;
    @FXML
    private TextField countgrp;
    @FXML
    private TextField imggrp;
   
    
    @FXML
    private TextField idkd;
    @FXML
    private TextField namekd;
    @FXML
    private TextField contactkd;
    @FXML
    private TextField headkd;
    @FXML
    private TextField countkd;
    @FXML
    private TextField imgkd;
    
    
    
    @FXML
     private TableView <childrendata> childrentable;
    @FXML
    private TableView <groupdata> grouptable;
    @FXML
    private TableView <gardendata> gardentable;
    
    @FXML
    private TableColumn <childrendata, String> idcolumn;
    @FXML
    private TableColumn <childrendata, String> namecolumn;
    @FXML
    private TableColumn <childrendata, String> surnamecolumn;
    @FXML
    private TableColumn <childrendata, String> fathernamecolumn;
    @FXML
    private TableColumn <childrendata, String> datecolumn;
    @FXML
    private TableColumn <childrendata, String> adresscolumn;
    @FXML
    private TableColumn <childrendata, String> group1column;
    @FXML
    private TableColumn <childrendata, String> gardencolumn;
    @FXML
    private TableColumn <childrendata, String> imagescolumn;
    
    
    @FXML 
    private TableColumn <groupdata, String> idgrpcolumn;
    @FXML
    private TableColumn <groupdata, String> namegrpcolumn;
    @FXML
    private TableColumn <groupdata, String> lvlgrpcolumn;
    @FXML
    private TableColumn <groupdata, String> teachergrpcolumn;
    @FXML
    private TableColumn <groupdata, String> nursegrpcolumn;
    @FXML
    private TableColumn <groupdata, String> countgrpcolumn;
    @FXML
    private TableColumn <groupdata, String> imggrpcolumn; 
    
     
    @FXML 
    private TableColumn <gardendata, String> idkdcolumn;
    @FXML
    private TableColumn <gardendata, String> namekdcolumn;
    @FXML
    private TableColumn <gardendata, String> contactkdcolumn;
    @FXML
    private TableColumn <gardendata, String> headkdcolumn;
    @FXML
    private TableColumn <gardendata, String> countkdcolumn;
    @FXML
    private TableColumn <gardendata, String> imgkdcolumn;
    
    @FXML
    private ImageView containerimg;
    @FXML
    private ImageView containerimggrp;
    @FXML
    private ImageView containerimggarden;
     
    String c1;
    private sql_connection dc;
   
    private ObservableList<childrendata> newdata;
    private ObservableList<groupdata> newgroupdata;
    private ObservableList<gardendata> newgardendata;
    
     
     
    
    public void changeIdCellEvent(CellEditEvent edditedCell) {
        childrendata newid = childrentable.getSelectionModel().getSelectedItem();
        newid.setId(edditedCell.getNewValue().toString());
    }
    
    public void changeNameCellEvent(CellEditEvent edditedCell) {
        childrendata newname = childrentable.getSelectionModel().getSelectedItem();
        newname.setName(edditedCell.getNewValue().toString());
    }
    
     public void changeSurNameCellEvent(CellEditEvent edditedCell) {
        childrendata newsurname = childrentable.getSelectionModel().getSelectedItem();
        newsurname.setSurname(edditedCell.getNewValue().toString());
    }
    
      public void changeFatherNameCellEvent(CellEditEvent edditedCell) {
        childrendata newfathername = childrentable.getSelectionModel().getSelectedItem();
        newfathername.setFathername(edditedCell.getNewValue().toString());
    }
      
       public void changeGroupCellEvent(CellEditEvent edditedCell) {
        childrendata newgroup = childrentable.getSelectionModel().getSelectedItem();
        newgroup.setGroup1(edditedCell.getNewValue().toString());
    }
       
        public void changeAddressCellEvent(CellEditEvent edditedCell) {
        childrendata newaddress = childrentable.getSelectionModel().getSelectedItem();
        newaddress.setAdress(edditedCell.getNewValue().toString());
    }
    
         public void changeDataCellEvent(CellEditEvent edditedCell) {
        childrendata newname = childrentable.getSelectionModel().getSelectedItem();
        newname.setDate(edditedCell.getNewValue().toString());
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.dc = new sql_connection();
         editable();
 
       
        
         
    }   
     
                       
    
    
   
    @FXML
    private void img(){
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 images.setText(somepath);
 
        System.out.println(somepath);
        
        
        
    }
    
    
    @FXML
    private void imgload(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT images FROM users WHERE id='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("images");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimg.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
    
    @FXML
        private void imgloadgrp(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT imggrp FROM grp WHERE idgrp='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("imggrp");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimggrp.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
        @FXML
            private void imgloadgarden(ActionEvent event) {
        try {
        Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
           
            ResultSet rs = conn.createStatement().executeQuery("SELECT imgkd FROM kinderg WHERE idkd='"+rowNew+"' ");
                  while(rs.next()){
                  String str = rs.getString("imgkd");
                   System.out.println(str);
                    File file = new File(str);
        Image image = new Image(file.toURI().toString());
        containerimggarden.setImage(image);
                  }
                  
         
                  
        }
        catch(SQLException e){
            System.err.println("error " + e);
            
        }
               
    }
     
     @FXML
    private void imggrp(){
        
        
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 imggrp.setText(somepath);
 
        System.out.println(somepath);
        
    }
    
     @FXML
    private void imgkd(){
        FileChooser chooser = new FileChooser();
       
Window stage = null;
chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG(*.jpg)", "*.jpg","PNG(*.png)", "*.png"));
File selectedFile = chooser.showOpenDialog(stage);

 String somepath = selectedFile.getAbsolutePath();
 
 imgkd.setText(somepath);
 
        System.out.println(somepath);
        
    }
    
    @FXML
    private void searchChildren(KeyEvent event) {
         FilteredList <childrendata> childrenfilter = new FilteredList<>(newdata,e->true);
         searchChildren.textProperty().addListener((observable,oldvalue,newvalue) -> {
            childrenfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getId().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getName().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getSurname().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getFathername().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getDate().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getAdress().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getGarden().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getGroup1().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
                
                return false;
            });
            
            SortedList<childrendata> childrensorted = new SortedList<>(childrenfilter);
            childrensorted.comparatorProperty().bind(childrentable.comparatorProperty());
            childrentable.setItems(childrensorted);
         });
        
    }
    
    

            
    
    
    @FXML
    private void searchGroup(KeyEvent event) {
         FilteredList <groupdata> groupfilter = new FilteredList<>(newgroupdata,e->true);
         searchGroup.textProperty().addListener((observable,oldvalue,newvalue) -> {
            groupfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getIdgrp().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getNamegrp().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getLvlgrp().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getTeachergrp().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getNursegrp().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getCountgrp().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
             
                return false;
            });
            
            SortedList<groupdata> groupsorted = new SortedList<>(groupfilter);
            groupsorted.comparatorProperty().bind(grouptable.comparatorProperty());
            grouptable.setItems(groupsorted);
         });
        
    }
    

    
    @FXML
    private void searchGarden(KeyEvent event) {
         FilteredList <gardendata> gardenfilter = new FilteredList<>(newgardendata,e->true);
         searchGarden.textProperty().addListener((observable,oldvalue,newvalue) -> {
            gardenfilter.setPredicate(pers -> {
                
                if(newvalue==null || newvalue.isEmpty()){
                    return true;
                }
              String typedText = newvalue.toLowerCase();
              if(pers.getIdkd().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getNamekd().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getContactkd().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              if(pers.getHeadkd().toLowerCase().indexOf(typedText)!=-1){  
                  return true;
              }
              if(pers.getCountkd().toLowerCase().indexOf(typedText)!=-1){
                  return true;
              }
              
                
                return false;
            });
            
            SortedList<gardendata> gardensorted = new SortedList<>(gardenfilter);
            gardensorted.comparatorProperty().bind(gardentable.comparatorProperty());
            gardentable.setItems(gardensorted);
         });
        
    }
                

    
    @FXML
    private void loadchildrenData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newdata = FXCollections.observableArrayList();
                
                
                ResultSet rs = conn.createStatement().executeQuery("SELECT users.[id],users.[name],users.[surname],users.[fathername],users.[date],users.[adress],grp.[namegrp],kinderg.[namekd],users.[images] FROM users INNER JOIN grp ON grp.[namegrp]=users.[group1] INNER JOIN kinderg ON kinderg.[namekd]=users.[garden]");
                while(rs.next()){
                    this.newdata.add(new childrendata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
        this.surnamecolumn.setCellValueFactory(new PropertyValueFactory("surname"));
        this.fathernamecolumn.setCellValueFactory(new PropertyValueFactory("fathername"));
        this.datecolumn.setCellValueFactory(new PropertyValueFactory("date"));
        this.adresscolumn.setCellValueFactory(new PropertyValueFactory("adress"));
        this.group1column.setCellValueFactory(new PropertyValueFactory("group1"));
        this.gardencolumn.setCellValueFactory(new PropertyValueFactory("garden"));
        this.imagescolumn.setCellValueFactory(new PropertyValueFactory("images"));
       // this.update.setCellValueFactory(new PropertyValueFactory("updatebutton"));
        
        
        this.childrentable.setItems(null);
        this.childrentable.setItems(this.newdata);
        
        
        
        
        }
    
    @FXML
    private void loadgroupData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newgroupdata = FXCollections.observableArrayList();
                
                
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM grp");
                while(rs.next()){
                    this.newgroupdata.add(new groupdata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.idgrpcolumn.setCellValueFactory(new PropertyValueFactory("idgrp"));
        this.namegrpcolumn.setCellValueFactory(new PropertyValueFactory("namegrp"));
        this.lvlgrpcolumn.setCellValueFactory(new PropertyValueFactory("lvlgrp"));
        this.teachergrpcolumn.setCellValueFactory(new PropertyValueFactory("teachergrp"));
        this.nursegrpcolumn.setCellValueFactory(new PropertyValueFactory("nursegrp"));
        this.countgrpcolumn.setCellValueFactory(new PropertyValueFactory("countgrp"));
        this.imggrpcolumn.setCellValueFactory(new PropertyValueFactory("imggrp"));
      
        
        this.grouptable.setItems(null);
        this.grouptable.setItems(this.newgroupdata);
        
        
        }
    
       @FXML
    private void loadgardenData(ActionEvent event) throws SQLException{
        
        try{
                Connection conn = sql_connection.getConnection();
                this.newgardendata = FXCollections.observableArrayList();
                
                
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kinderg");
                while(rs.next()){
                    this.newgardendata.add(new gardendata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
        } 
        catch(SQLException e){
            System.err.println("error " + e);
    }
        
        this.idkdcolumn.setCellValueFactory(new PropertyValueFactory("idkd"));
        this.namekdcolumn.setCellValueFactory(new PropertyValueFactory("namekd"));
        this.contactkdcolumn.setCellValueFactory(new PropertyValueFactory("contactkd"));
        this.headkdcolumn.setCellValueFactory(new PropertyValueFactory("headkd"));
        this.countkdcolumn.setCellValueFactory(new PropertyValueFactory("countkd"));
        this.imgkdcolumn.setCellValueFactory(new PropertyValueFactory("imgkd"));
        //this.countgrpcolumn.setCellValueFactory(new PropertyValueFactory("countgrp"));
      
        
        this.gardentable.setItems(null);
        this.gardentable.setItems(this.newgardendata);
        
        
        }
    
   private void editable() {
       
       
        
        idcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        namecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fathernamecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        datecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        adresscolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        group1column.setCellFactory(TextFieldTableCell.forTableColumn());
        gardencolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imagescolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        idgrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        namegrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lvlgrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        teachergrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nursegrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        countgrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imggrpcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        idkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        namekdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        contactkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        headkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        countkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
        imgkdcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
        
        
         idcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });
         
          namecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });
          
            surnamecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setSurname(e.getNewValue());
        });
            
              fathernamecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setFathername(e.getNewValue()); 
        });
        
                datecolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue());
        });
              
                adresscolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdress(e.getNewValue());
        });
                
                  group1column.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setGroup1(e.getNewValue());
        });
                  
                  gardencolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setGarden(e.getNewValue());
        });
                   
                  imagescolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImages(e.getNewValue());
        });
                
                
                
                idgrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdgrp(e.getNewValue());
        });
         
          namegrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setNamegrp(e.getNewValue());
        });
          
            lvlgrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setLvlgrp(e.getNewValue());
        });
            
              teachergrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setTeachergrp(e.getNewValue()); 
        });
        
                nursegrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setNursegrp(e.getNewValue());
        });
              
                countgrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setCountgrp(e.getNewValue());
        });
                imggrpcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImggrp(e.getNewValue());
        });
              
                
                
                
                
                idkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setIdkd(e.getNewValue());
        });
         
          namekdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setNamekd(e.getNewValue());
        });
          
            contactkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setContactkd(e.getNewValue());
        });
            
              headkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setHeadkd(e.getNewValue()); 
        });
        
                countkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setCountkd(e.getNewValue());
        });
                imgkdcolumn.setOnEditCommit(e-> {
         e.getTableView().getItems().get(e.getTablePosition().getRow()).setImgkd(e.getNewValue());
        });
                  
     
        this.childrentable.setEditable(true);
        this.grouptable.setEditable(true);
        this.gardentable.setEditable(true);

    
   }
    

@FXML 
private void load(ActionEvent event) {
 
        TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


childrendata item = childrentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 
       
}



    public void updataData() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = childrentable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="id";
            }else if(colIndex==1){
                rowText="name";
            }else if(colIndex==2){
                rowText="surname";
            }else if(colIndex==3){
                rowText="fathername";
            }else if(colIndex==4){
                rowText="date";
            }else if (colIndex==5){
                rowText="adress";
            }else if (colIndex==6){
                rowText="group1";
            }else if (colIndex==7){
                rowText="garden";
            }else if (colIndex==8){
                rowText="images";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE users SET '"+rowText+"' = '"+data1+"' WHERE id = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    public void updataGRP() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = grouptable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="idgrp";
            }else if(colIndex==1){
                rowText="namegrp";
            }else if(colIndex==2){
                rowText="lvlgrp";
            }else if(colIndex==3){
                rowText="teachergrp";
            }else if(colIndex==4){
                rowText="nursegrp";
            }else if (colIndex==5){
                rowText="countgrp";
            }else if (colIndex==6){
                rowText="imggrp";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE grp SET '"+rowText+"' = '"+data1+"' WHERE idgrp = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    public void updataGarden() {
     
        try {
            Connection conn = sql_connection.getConnection();
            Statement con = conn.createStatement();
            //connection
            TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            int rowNew = pos.getRow();
            String rowText = null;
            
             if(rowNew==0){
                rowNew=1;
            }else if(rowNew==1){
                rowNew=2;
            }else if(rowNew==2){
                rowNew=3;
            }else if(rowNew==3){
                rowNew=4;
            }else if(rowNew==4){
                rowNew=5;
            }else if (rowNew==5){
                rowNew=6;
            }else if (rowNew==6){
                rowNew=7;
            }else if (rowNew==7){
                rowNew=8;
            }else if (rowNew==8){
                rowNew=9;
            }else if (rowNew==9){
                rowNew=10;
            }
             
             System.out.println(rowNew);
            
            TableColumn col = pos.getTableColumn();
            int colIndex = gardentable.getColumns().indexOf(col);
            
            if(colIndex==0){
                rowText="idkd";
            }else if(colIndex==1){
                rowText="namekd";
            }else if(colIndex==2){
                rowText="contactkd";
            }else if(colIndex==3){
                rowText="headkd";
            }else if(colIndex==4){
                rowText="countkd";
            }else if(colIndex==5){
                rowText="imgkd";
            }
                
                
            System.out.println(rowText);
             String data1 = (String) col.getCellObservableValue(row).getValue();
             System.out.println(data1);
            
           
           con.execute("UPDATE kinderg SET '"+rowText+"' = '"+data1+"' WHERE idkd = '"+rowNew+"' ");
                   
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    
    
    
    

    
      @FXML
    private void addStudent(ActionEvent event)
  {
    String sql = "INSERT INTO users(`id`, `name`, `surname`, `fathername`, `date`, `adress`, `group1`, `garden`, 'images') VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.name.getText());
      stmt.setString(3, this.surname.getText());
      stmt.setString(4, this.fathername.getText());
      stmt.setString(5, this.date.getEditor().getText());
      stmt.setString(6, this.adress.getText());
      stmt.setString(7, this.group1.getText());
      stmt.setString(8, this.garden.getText());
      stmt.setString(9, this.images.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void addGroup(ActionEvent event)
  {
    String sql = "INSERT INTO grp(`idgrp`, `namegrp`, `lvlgrp`, `teachergrp`, `nursegrp`, `countgrp`, 'imggrp') VALUES (? , ?, ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.idgrp.getText());
      stmt.setString(2, this.namegrp.getText());
      stmt.setString(3, this.lvlgrp.getText());
      stmt.setString(4, this.teachergrp.getText());
      stmt.setString(5, this.nursegrp.getText());
      stmt.setString(6, this.countgrp.getText());
      stmt.setString(7, this.imggrp.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void addKG(ActionEvent event)
  {
    String sql = "INSERT INTO kinderg(`idkd`, `namekd`, `contactkd`, `headkd`, `countkd`, 'imgkd') VALUES (? , ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.idkd.getText());
      stmt.setString(2, this.namekd.getText());
      stmt.setString(3, this.contactkd.getText());
      stmt.setString(4, this.headkd.getText());
      stmt.setString(5, this.countkd.getText());
      stmt.setString(6, this.imgkd.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
    
     @FXML
    private void deleteStudent(ActionEvent event)
  {
   
  TablePosition pos = childrentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


childrendata item = childrentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM users WHERE id=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

childrentable.getItems().removeAll(childrentable.getSelectionModel().getSelectedItem());
      
   
  }
    
    @FXML
    private void deleteGroup(ActionEvent event)
  {
   
  TablePosition pos = grouptable.getSelectionModel().getSelectedCells().get(0);
  System.out.println(pos);
int row = pos.getRow();


groupdata item = grouptable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM grp WHERE idgrp=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

grouptable.getItems().removeAll(grouptable.getSelectionModel().getSelectedItem());
      
   
  }
    
    @FXML
    private void deleteGarden(ActionEvent event)
  {
   
  TablePosition pos = gardentable.getSelectionModel().getSelectedCells().get(0);
int row = pos.getRow();


gardendata item = gardentable.getItems().get(row);

TableColumn col = pos.getTableColumn();
String data = (String) col.getCellObservableValue(item).getValue();
System.out.println(data);

 String sql = "DELETE FROM kinderg WHERE idkd=?";
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, data);
      
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }

gardentable.getItems().removeAll(gardentable.getSelectionModel().getSelectedItem());
      
   
  }
    
   @FXML 
    private void deleteFromForm(ActionEvent event)
  {
     
           String sql = "DELETE FROM users WHERE id=?";
           
    try
    {
      Connection conn = sql_connection.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,this.id.getText());
      
      stmt.execute();
      conn.close();
    }
    catch (SQLException e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
      }
    
    


    
    @FXML
     private void clearFields(ActionEvent event)
  {
    this.id.setText("");
    this.name.setText("");
    this.surname.setText("");
    this.fathername.setText("");
    this.date.setValue(null);
    this.adress.setText("");
    this.group1.setText("");
    this.garden.setText("");
    this.images.setText("");
  }
     
     @FXML
     private void clearFieldsgroup(ActionEvent event)
  {
    this.idgrp.setText("");
    this.namegrp.setText("");
    this.lvlgrp.setText("");
    this.teachergrp.setText("");
    this.countgrp.setText("");
    this.nursegrp.setText("");
    this.imggrp.setText("");
  }
     @FXML
       private void clearFieldsgarden(ActionEvent event)
  {
    this.idkd.setText("");
    this.namekd.setText("");
    this.contactkd.setText("");
    this.headkd.setText("");
    this.countkd.setText("");
    this.imgkd.setText("");
  }
}
