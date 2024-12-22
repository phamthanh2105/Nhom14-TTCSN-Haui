/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PhamDai
 */
public class TaiKhoanDAL {
    
    private TaiKhoanDAL(){
        
    }
    
    public static Connection connection=ConnectSQL.connect();
    
    public static ArrayList<TaiKhoan> show(boolean vaiTro){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            Statement s = ConnectSQL.connect().createStatement();
            ResultSet r =  s.executeQuery("SELECT TenTaiKhoan,MatKhau FROM TAIKHOAN WHERE VaiTro='"+vaiTro+"'");
       
            while (r.next()){
                list.add(new TaiKhoan(r.getString("TenTaiKhoan"), r.getString("MatKhau")));
            }   
            
        } catch (SQLException ex) {
            return null;
        }
        
        return list;
    }
    
    public static TaiKhoan dangNhap(String userName,String passWord) {
		boolean vaiTro;
		TaiKhoan tk=null;
		try {
                    String sql="select * from TAIKHOAN where TenTaiKhoan=? and MatKhau=?";			
                    PreparedStatement pre=connection.prepareStatement(sql);
                    pre.setString(1, userName);
                    pre.setString(2, passWord);
                    ResultSet result=pre.executeQuery();
                    if (result.next()) {
                            tk=new TaiKhoan();
                            tk.setTenTaiKhoan(result.getString("TenTaiKhoan"));
                            tk.setMatKhau(result.getString("MatKhau"));
                            tk.setVaiTro(result.getBoolean("VaiTro"));
                            vaiTro=result.getBoolean("VaiTro");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
    
    public static boolean insert(String tenTaiKhoan,String matKhau) {
        
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("INSERT [dbo].[TAIKHOAN] VALUES (?, ?, ?)");
            pre.setString(1,tenTaiKhoan);
            pre.setString(2,matKhau);
            pre.setBoolean(3,false);
            pre.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
 
    }
    
    public static boolean update(String tenTaiKhoan,String matKhau,boolean vaiTro){
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyChungCu].[dbo].[TAIKHOAN] "
                    + "SET TenTaiKhoan = ?,MatKhau =? WHERE VaiTro =?");
            pre.setString(1,tenTaiKhoan);
            pre.setString(2,matKhau);
            pre.setBoolean(3,vaiTro);
            return  pre.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean update(String tenTaiKhoan,String matKhau){
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("UPDATE [QuanLyChungCu].[dbo].[TAIKHOAN] "
                    + "SET MatKhau =? WHERE TenTaiKhoan =?");
            pre.setString(2,tenTaiKhoan);
            pre.setString(1,matKhau);
            return  pre.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean delete(String tenTaiKhoan){
        try {
            PreparedStatement pre = ConnectSQL.connect().prepareStatement("DELETE TAIKHOAN WHERE TenTaiKhoan = ?");
            pre.setString(1,tenTaiKhoan);
            return pre.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
