package model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NguoiDung {

    @Id
    private String maNguoiDung;

    private String ten;

    @Column(unique = true)
    private String email;

    private String matKhau;

    private Boolean gioiTinh;

    private String anhDaiDien;

    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<BaiViet> baiViets;

    // === Constructors ===

    public NguoiDung() {
    }

    public NguoiDung(String maNguoiDung, String ten, String email, String matKhau, Boolean gioiTinh, String anhDaiDien, List<BaiViet> baiViets) {
        this.maNguoiDung = maNguoiDung;
        this.ten = ten;
        this.email = email;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.anhDaiDien = anhDaiDien;
        this.baiViets = baiViets;
    }

    // === Getters and Setters ===

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public List<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(List<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }
}
