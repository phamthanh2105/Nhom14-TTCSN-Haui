/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class HopDong {
    private String maHopDong;
    private String tenKH;
    private String ngayGiaoDich;
    private String diaChiKhachHang;
    private String maCuDan;
    private String maCanHo;
    private int gia;

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getDiaChiKhachHang() {
        return diaChiKhachHang;
    }

    public void setDiaChiKhachHang(String diaChiKhachHang) {
        this.diaChiKhachHang = diaChiKhachHang;
    }

    public String getMaCuDan() {
        return maCuDan;
    }

    public void setMaCuDan(String maCuDan) {
        this.maCuDan = maCuDan;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public HopDong() {
    }

    public HopDong(String maHopDong, String tenKH, String ngayGiaoDich, String diaChiKhachHang, String maCuDan, String maCanHo) {
        this.maHopDong = maHopDong;
        this.tenKH=tenKH;
        this.ngayGiaoDich = ngayGiaoDich;
        this.diaChiKhachHang = diaChiKhachHang;
        this.maCuDan = maCuDan;
        this.maCanHo = maCanHo;
    }
    
    
}
