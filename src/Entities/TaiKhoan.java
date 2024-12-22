/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

public class TaiKhoan {
    
    private String tenTaiKhoan;
    private String matKhau;
    private boolean vaiTro;

    public TaiKhoan() {
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + '}';
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau, boolean vaiTro) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public TaiKhoan(String tenTaiKhoan, String matKhau) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

}
