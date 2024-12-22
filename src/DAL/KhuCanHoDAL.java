/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import Entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class KhuCanHoDAL {
  
    private KhuCanHoDAL() {
        
    }
    
    public static ArrayList<KhuCanHo> show(){
        
        ArrayList<KhuCanHo> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r =  s.executeQuery("SELECT * FROM KHUCANHO");
        
            while (r.next()){
                list.add(new KhuCanHo(r.getString(1), r.getString(2), r.getInt(3), r.getInt(4), r.getString(5)));
            }   
            
        } catch (SQLException ex) {
            return null;
        }
        
        Collections.sort(list,(x,y)->{
            return x.getMaKhu().compareTo(y.getMaKhu());
        });
        
        return list;
    }
    
    public static boolean insert(KhuCanHo khu){  
         try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement
            ("INSERT INTO [dbo].[KHUCANHO] VALUES (?, ?, ?, ?, ?)");
              pre.setString(1, khu.getMaKhu());
              pre.setString(2, khu.getTenKhu());
              pre.setInt(3, khu.getSoTang());
              pre.setInt(4, khu.getSoCanTT());
              pre.setString(5,khu.getDiaChi());
              pre.executeUpdate();
              
              return true;
              
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean update(String maKhu,String tenKhu,String diaChi){
           try {
               
               PreparedStatement pre = ConnectSQL.connect().prepareStatement
                    ("UPDATE dbo.KHUCANHO SET TenKhu = ?,DiaChi = ? WHERE MaKhu = ?");
                pre.setString(1, tenKhu);
                pre.setString(2, diaChi);
                pre.setString(3, maKhu);
            return pre.executeUpdate() > 0;
            
        } catch(SQLException e){
            return false;
        }
    }
    
    public static boolean delete(String maKhu){
           try {
               
            PreparedStatement pre = ConnectSQL.connect().prepareStatement
                ("DELETE dbo.KHUCANHO WHERE MaKhu = ?");
                pre.setString(1, maKhu);
            return pre.executeUpdate() > 0;
            
        } catch(SQLException e){
            return false;
        }
    }    
    
    public static ArrayList<KhuCanHo> search(String text) throws SQLException{
        
        Statement s  = ConnectSQL.connect().createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM dbo.KHUCANHO WHERE "
        + "MaKhu LIKE '%"+text+"%' OR TenKhu LIKE N'%"+text+"%' OR SoTang LIKE '%"+text+"%' OR SoCanTT LIKE '%"+text+"%' OR DiaChi LIKE N'%"+text+"%'");
        ArrayList<KhuCanHo> list = new ArrayList<>();
        while(r.next()){
             list.add(new KhuCanHo(r.getString(1), r.getString(2), r.getInt(3), r.getInt(4), r.getString(5)));
        }
        return list;
    }
    
}
