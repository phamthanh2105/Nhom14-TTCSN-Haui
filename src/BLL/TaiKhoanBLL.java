/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.*;
import Entities.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;


public class TaiKhoanBLL {
    private TaiKhoanBLL(){
        
    }
    
    public static boolean checkEmpty(){
        return TaiKhoanDAL.show(false).isEmpty();
    }
    
    public static TableModel show(){
        ArrayList<TaiKhoan> list = TaiKhoanDAL.show(false);
        String[] colunmNames = {"Username","Password"};
        Object[][] data = new Object[list.size()][colunmNames.length];
        for(int i =0;i<list.size();i++){
            data[i][0] = list.get(i).getTenTaiKhoan();
            data[i][1] = list.get(i).getMatKhau();
        }
        
        return new DefaultTableModel(data,colunmNames);
    }
    
    public static boolean checkAccountManager(String tenTaiKhoan,String matKhau){
         ArrayList<TaiKhoan> list = TaiKhoanDAL.show(true);
         return matKhau.equalsIgnoreCase(list.get(0).getMatKhau()) && tenTaiKhoan.equalsIgnoreCase(list.get(0).getTenTaiKhoan());
    }
    public static boolean insert(String tenTaiKhoan,String matKhau){
        return TaiKhoanDAL.insert(tenTaiKhoan,matKhau);  
    }
    
    public static boolean update(String tenTaiKhoan,String matKhau,boolean vaiTro){
        return TaiKhoanDAL.update(tenTaiKhoan,matKhau,vaiTro);
        
    }
    
     public static boolean update(String tenTaiKhoan,String matKhau){
        return TaiKhoanDAL.update(tenTaiKhoan,matKhau);
        
    }
    
    public static boolean delete(String tenTaiKhoan){
        return TaiKhoanDAL.delete(tenTaiKhoan);
    }
    
}
