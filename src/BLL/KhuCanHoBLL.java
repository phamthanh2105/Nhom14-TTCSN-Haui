package BLL;
import DAL.*;
import Entities.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class KhuCanHoBLL {

    private KhuCanHoBLL() {
    }
    
    public static boolean checkEmpty(){
        return KhuCanHoDAL.show().isEmpty();
    }
    
    public static TableModel show(){
        ArrayList<KhuCanHo> list = KhuCanHoDAL.show();
        
        String[] columnNames = {"STT","Mã Khu","Khu","Số Tầng","Số căn/tầng","Địa chỉ"};
        
        Object[][] data = new Object[list.size()][columnNames.length];
        
        int i = 0;
        
        for(KhuCanHo khu : list){
            data[i][0] = i + 1;
            data[i][1] = khu.getMaKhu();
            data[i][2] = khu.getTenKhu();
            data[i][3] = khu.getSoTang();
            data[i][4] = khu.getSoCanTT();
            data[i][5] = khu.getDiaChi();
            i++;
        }
        
        return  new DefaultTableModel(data,columnNames);
    }
    
    public static Object[] showControlWithCombobox(String cbbValue){
        ArrayList<KhuCanHo> list = KhuCanHoDAL.show();
        Object[] obj = new Object[4];
        for(KhuCanHo k :list){
            if(cbbValue.equals(k.getMaKhu())){
                  obj[0]  = k.getDiaChi();
                  obj[1]  = k.getSoCanTT();
                  obj[2]  = k.getSoTang();
                  obj[3]  = k.getTenKhu();
            }
        }
        return obj;
    }
    
    public static ComboBoxModel cbb_show(){
        
        StringBuilder items = new StringBuilder();
        
        for(int i = 0;i<KhuCanHoDAL.show().size();i++){
            items.append(KhuCanHoDAL.show().get(i).getMaKhu());
            items.append("#");
        }
        
        return new DefaultComboBoxModel(items.toString().split("#"));
    }
    
    public static boolean insert(String tenKhu,int soTang,int soCanTT, String diaChi, float dienTich, long gia,int soPhong){

        String lastID;
        char first_lastID;
        char second_lastID;
        String maKhu = null;
        
        if(KhuCanHoDAL.show().isEmpty()){
             maKhu = "EA";// chưa có khu nào lấy giá trị mặc định mã khu là EA
        }else{
            lastID = KhuCanHoDAL.show().get(KhuCanHoDAL.show().size()-1).getMaKhu();
            first_lastID =  lastID.charAt(0);
            second_lastID = lastID.charAt(1);
            
            if(first_lastID == 'Z' && second_lastID == 'Z'){ //gioi han ten khu ZZ
                JOptionPane.showMessageDialog(null,"System Error!");
            }else if(second_lastID == 'Z'){
                first_lastID = (char)((int)first_lastID+1);
                second_lastID = 'A';
                maKhu = String.valueOf(first_lastID) + String.valueOf(second_lastID);
            }else{
                second_lastID = (char)((int)second_lastID+1);
                maKhu = String.valueOf(first_lastID) + String.valueOf(second_lastID);
            }
        } // tao ma khu chay tu dong
        
        ArrayList<CanHo> list = new ArrayList<>();// tạo danh sách là những căn hộ trong khu
        for(int i = 1;i<=soTang;i++) {
            for(int j=1;j<=soCanTT;j++) {
		if(i<10 && j<10) { // chi hien dung khi so tang <100 va so can/tang <100

                    list.add(new CanHo(maKhu+"0"+i+"0"+j, dienTich, gia, false, soPhong,null, maKhu));
                    
		} else if (i <10) {
                    
                    list.add(new CanHo(maKhu+"0"+i+j, dienTich, gia, false, soPhong,null, maKhu)); 
                    
		} else if (j<10) {
                    
                    list.add(new CanHo(maKhu+i+"0"+j, dienTich, gia, false, soPhong,null, maKhu));
                    
		} else {
                    
                    list.add(new CanHo(maKhu+i+j, dienTich, gia, false, soPhong,null, maKhu));
                    
		}
            }		
	}
        
        return KhuCanHoDAL.insert(new KhuCanHo(maKhu, tenKhu, soTang, soCanTT, diaChi)) && CanHoDAL.inserts(list);
        // trả về true nếu thêm thành công cả khu và căn hộ trong khu
    }
    
    public static TableModel search(String text) throws SQLException{
        
        ArrayList<KhuCanHo> list = KhuCanHoDAL.search(text);
        
        String[] columnNames = {"STT","Mã Khu","Khu","Số Tầng","Số căn/tầng","Địa chỉ"};
        
        Object[][] data = new Object[list.size()][columnNames.length];
        
        int i =0;
        
        for(KhuCanHo khu : list){
            data[i][0] = i + 1;
            data[i][1] = khu.getMaKhu();
            data[i][2] = khu.getTenKhu();
            data[i][3] = khu.getSoTang();
            data[i][4] = khu.getSoCanTT();
            data[i][5] = khu.getDiaChi();
            i++;
        }
       // TableModel
        return new DefaultTableModel(data, columnNames);
    }
    
    public static boolean checkNotDuplicateAreaName(String tenKhu){
        ArrayList<KhuCanHo> list = KhuCanHoDAL.show();
        if(list.isEmpty()) return false;
        for(KhuCanHo khu : list){
            if(tenKhu.trim().equalsIgnoreCase(khu.getTenKhu().trim()))
            {
                return true;
            }
        }
        return false;  
    }
    
    public static boolean update(String maKhu,String tenKhu,String diaChi){
        return KhuCanHoDAL.update(maKhu, tenKhu, diaChi);
    }
    
    public static boolean delete(String maKhu){
        return KhuCanHoDAL.delete(maKhu);
    }      
    
}