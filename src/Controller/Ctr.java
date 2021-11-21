package Controller;

import View.Vw;
import Model.Md;
import java.sql.*;

public class Ctr {
    final private Vw View;
    final private Md Model;
    private int GenID = 0;
    private static Connection conn = null;
    private PreparedStatement pst = null;
    
    public Ctr(Vw view, Md model){
        View = view;
        Model = model;
        ConnectToDataBase();
        ClearDataInDataBase();
    }
    
    // ******************* Controller Process ******************* //
    
    private void ConnectToDataBase(){
        String url = "jdbc:sqlserver://DESKTOP-CN19JC6\\SQLEXPRESS;databaseName=Traning_MVC;user=sa;password=Nzeed0";
        
        try{
            conn = DriverManager.getConnection(url);
            System.out.println("Connect Success!!");
        } catch(SQLException e){
            System.out.println("Cannot connect Database");
            System.out.println(e.getMessage());
        }
    }
    
    private void ClearDataInDataBase(){
        String sql = "DELETE FROM POLICY_PARTY";
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            System.out.println("Delete Success!!");
        } catch (SQLException er){
            System.out.println("Cannot Delete Data From Database");
        }
    }
    
    // ******************* View + Model Process ******************* //
    
    public void SendCtrollerObject(Ctr ctr){
        View.SetControllerObject(ctr);
    }
    
    public void InputToDataBase(){           
       String StoreData[] = View.getData();
       String Check =  Model.CheckName(StoreData[0], StoreData[1])+Model.CheckEducation(StoreData[2]); 
       String sql = "INSERT INTO POLICY_PARTY values("+GenID+" , '"+StoreData[0]+" "+StoreData[1]+"','"+StoreData[2]+"','"+StoreData[3]+"') ";
       
       if(Check.equals("11")){
           try{
                   pst = conn.prepareStatement(sql);
                   pst.execute();
                   GenID++;
                   System.out.println("Updated Data!");
               } 
           catch(SQLException e){
                   System.out.println("Cannot Input Data To Database!");
                   System.out.println(e.getMessage());
               }
        View.CheckConnecting(1);
       } else {
        View.CheckConnecting(0);
       }
    }
}
