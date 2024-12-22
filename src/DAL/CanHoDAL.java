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

/**
 *
 * @author PhamDai
 */
public class CanHoDAL {
        
    public static ArrayList<CanHo> show(){
        ArrayList<CanHo> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r =  s.executeQuery(" SELECT c.MaCanHo, c.DienTich, c.Gia, c.TrangThai, c.SoPhong, c.MaCuDan, k.TenKhu \n" +
    " FROM [QuanLyChungCu].[dbo].[CANHO] c JOIN [QuanLyChungCu].[dbo].KHUCANHO k ON k.MaKhu = c.MaKhu");
       
            while (r.next()){
                CanHo canHo = new CanHo();
                canHo.setMaCanHo(r.getString("MaCanHo"));
                canHo.setDienTich(r.getFloat("DienTich"));
                canHo.setGia(r.getLong("Gia"));
                canHo.setTrangThai(r.getBoolean("TrangThai"));
                canHo.setSoPhong(r.getInt("SoPhong"));
                canHo.setMaCuDan(r.getString("MaCuDan"));
                canHo.setTenKhu(r.getString("TenKhu"));
                list.add(canHo);
            }   
            
        } catch (SQLException ex) {
            return null;
        }
        
        return list;
    }
    
    public static Object[] showControlWithCombobox(String maCanHo){
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("SELECT c.MaCanHo, c.DienTich, c.Gia, "
                    + "c.TrangThai, c.SoPhong, c.MaCuDan, k.TenKhu \n" +
    " FROM [QuanLyChungCu].[dbo].[CANHO] c JOIN [QuanLyChungCu].[dbo].KHUCANHO k ON k.MaKhu = c.MaKhu WHERE MaCanHo = ?");
            pre.setString(1, maCanHo);
             Object[] o = new Object[5];
            ResultSet r = pre.executeQuery();
            if(r.next()){
                  o[0]  = r.getString("DienTich");
                  o[1]  = r.getLong("Gia");
                  if(r.getString("MaCuDan")==null){
                      o[2] = "<Empty>";
                  }else{
                      o[2]  = r.getString("MaCuDan");
                  }
                  o[3]  = r.getInt("SoPhong");
                  o[4]  = r.getString("TenKhu");
            }
            return o;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static boolean inserts(ArrayList<CanHo> list){
        
        try {
            PreparedStatement pre ;
            for(CanHo c : list){

               pre = ConnectSQL.connect().prepareStatement
                ("INSERT [dbo].[CANHO] ([MaCanHo], [DienTich], [Gia], [TrangThai], [SoPhong], [MaCuDan], [MaKhu])"
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)");
               pre.setString(1, c.getMaCanHo());
               pre.setFloat(2, c.getDienTich());
               pre.setLong(3,c.getGia());
               pre.setBoolean(4, c.isTrangThai());
               pre.setInt(5, c.getSoPhong());
               pre.setString(6, c.getMaCuDan());
               pre.setString(7, c.getMaKhu());
               
               pre.executeUpdate();
 
            }
            return true;
              
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean update(String maCanHo,long gia,int soPhong){
         try {
               
               PreparedStatement pre = ConnectSQL.connect().prepareStatement
                    ("UPDATE dbo.CANHO SET Gia = ?,SoPhong = ? WHERE MaCanHo = ?");
                pre.setLong(1, gia);
                pre.setInt(2, soPhong);
                pre.setString(3, maCanHo);
            return pre.executeUpdate() > 0;
            
        } catch(SQLException e){
            return false;
        }
    }
            
     public static ArrayList<CanHo> search(boolean check,long tuGia,long denGia,float tuDienTich,float denDienTich){
         //System.out.println(check+" "+tuGia+" "+ denGia + " " +tuDienTich +" "+ denDienTich);
        ArrayList<CanHo> list = new ArrayList<>();
        try {
            PreparedStatement pre  = ConnectSQL.connect().prepareStatement
                ("EXEC dbo.searchApartmentWithCriterias ?,?,?,?,?");
                pre.setBoolean(1, check);
                pre.setLong(2, tuGia);
                pre.setLong(3, denGia);
                pre.setFloat(4, tuDienTich);
                pre.setFloat(5, denDienTich);

                ResultSet r = pre.executeQuery();
            while (r.next()){
                CanHo canHo = new CanHo();
                canHo.setMaCanHo(r.getString("MaCanHo"));
                canHo.setDienTich(r.getFloat("DienTich"));
                canHo.setGia(r.getLong("Gia"));
                canHo.setTrangThai(r.getBoolean("TrangThai"));
                canHo.setSoPhong(r.getInt("SoPhong"));
                canHo.setMaCuDan(r.getString("MaCuDan"));
                canHo.setTenKhu(r.getString("TenKhu"));
                list.add(canHo);
            }   
            
        } catch (SQLException ex) {
            return null;
        }
        
        return list;
    }
    

     
}
