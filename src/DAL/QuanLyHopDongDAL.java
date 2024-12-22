/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entities.HopDong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class QuanLyHopDongDAL {
     public static boolean kiemTraTonTai(String maHopDong){
         try {
             String sql="select * from HOPDONG where MaHopDong=?";
             PreparedStatement preStatement=ConnectSQL.connect().prepareStatement(sql);
             preStatement.setString(1, maHopDong);
             ResultSet result=preStatement.executeQuery();
             return result.next();  
         }
         catch(SQLException e2) {
              JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống");
        }
        catch(NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống");
        }
        catch(NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác, mời nhập lại .");
        }
         catch (Exception e) {
             e.printStackTrace();
         }
        return false;
     }
     public int themHopDong(HopDong hopDong){
         try {
             String sql="insert into HOPDONG values(?,?,?,?,?,?)";
             PreparedStatement preStatement=ConnectSQL.connect().prepareStatement(sql);
             preStatement.setString(1, hopDong.getMaHopDong());
             preStatement.setString(2, hopDong.getNgayGiaoDich());
             preStatement.setString(3, hopDong.getDiaChiKhachHang());
             preStatement.setString(4, hopDong.getMaCuDan());
             preStatement.setString(5, hopDong.getMaCanHo());
             preStatement.setString(6, hopDong.getTenKH());
             return preStatement.executeUpdate();     
         }
         catch(SQLException e2) {
              JOptionPane.showMessageDialog(null, "Dữ liệu trống hoặc đã tồn tại");
        }
        catch(NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống");
        }
        catch(NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác, mời nhập lại .");
        } 
         
         catch (Exception e) {
             e.printStackTrace();
         }
         return -1;
     }
     public static int xuLyXoaHopDong(String maHopDong){
         try {
             String sql="delete from HOPDONG where MaHopDong=?";
             PreparedStatement preStatement=ConnectSQL.connect().prepareStatement(sql);
             preStatement.setString(1, maHopDong);
             preStatement.executeQuery();
         } 
         catch(NullPointerException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không được để trống");
        }
        catch(NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác, mời nhập lại .");
        }
         catch(SQLException e) {
             JOptionPane.showMessageDialog(null, "Lỗi data");
         }
         catch (Exception e) {
             e.printStackTrace();
         }
          return -1;
     }
     public int updateHopDong(HopDong hopDong){
         try {
             String sql="update HOPDONG set NgayGiaoDich=?,DiaChiKhachHang=?,MaCuDan=?,MaCanHo=?,TenKH=? where MaHopDong=?";
             PreparedStatement preStatement=ConnectSQL.connect().prepareStatement(sql);
             preStatement.setString(1, hopDong.getNgayGiaoDich());
             preStatement.setString(2, hopDong.getDiaChiKhachHang());
             preStatement.setString(3, hopDong.getMaCuDan());
             preStatement.setString(4, hopDong.getMaCanHo());
             preStatement.setString(5, hopDong.getTenKH());
             preStatement.setString(6, hopDong.getMaHopDong());
             return preStatement.executeUpdate();
             
         }
        catch(SQLException e2) {
              JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu");
        }
        
        catch(NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác, mời nhập lại .");
        }
         catch (Exception e) {
             e.printStackTrace();
         }
         return -1;
     }
     public static boolean kiemTraTonTaiMaCanHO(String maCanHo){
         try {
             String sql="select MaCanHo from HOPDONG where MaHopDong=?";
             PreparedStatement preStatement=ConnectSQL.connect().prepareStatement(sql);
             preStatement.setString(1, maCanHo);
             ResultSet result=preStatement.executeQuery();
             return result.next();  
         } catch (Exception e) {
             e.printStackTrace();
         } 
            
         return false;   
         
     }
  
}
