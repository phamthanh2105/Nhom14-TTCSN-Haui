/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class CuDan {
    private String maCuDan;
    private String tenCuDan;
    private String ngaySinh;
    private boolean gioiTinh;
    private String soDT;
    private String soCMT;
    private String queQuan;
    private String maCanHo;

    public String getMaCuDan() {
        return maCuDan;
    }

    public void setMaCuDan(String maCuDan) {
        this.maCuDan = maCuDan;
    }

    public String getTenCuDan() {
        return tenCuDan;
    }

    public void setTenCuDan(String tenCuDan) {
        this.tenCuDan = tenCuDan;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public CuDan() {
    }
    
    public CuDan(String maCuDan, String tenCuDan, String ngaySinh, boolean gioiTinh, String soDT, String soCMT, String queQuan) {
        this.maCuDan = maCuDan;
        this.tenCuDan = tenCuDan;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.soCMT = soCMT;
        this.queQuan = queQuan;
    }
    
     public CuDan(String maCanHo,String maCuDan){
        this.maCanHo=maCanHo;
        this.maCuDan=maCuDan;
    }

   
}
