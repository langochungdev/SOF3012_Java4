package model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BaiViet {

    @Id
    private String maBaiViet;

    private String tieuDe;

    @Lob
    private String noiDung;

    private String hinhAnh;

    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "maNguoiDung")
    private NguoiDung nguoiDung;

    @OneToMany(mappedBy = "baiViet")
    @JsonIgnore
    private List<BinhLuan> binhLuans;

    // === Constructors ===

    public BaiViet() {
    }

    public BaiViet(String maBaiViet, String tieuDe, String noiDung, String hinhAnh, Date ngayTao, NguoiDung nguoiDung, List<BinhLuan> binhLuans) {
        this.maBaiViet = maBaiViet;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.hinhAnh = hinhAnh;
        this.ngayTao = ngayTao;
        this.nguoiDung = nguoiDung;
        this.binhLuans = binhLuans;
    }

    // === Getters and Setters ===

    public String getMaBaiViet() {
        return maBaiViet;
    }

    public void setMaBaiViet(String maBaiViet) {
        this.maBaiViet = maBaiViet;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public List<BinhLuan> getBinhLuans() {
        return binhLuans;
    }

    public void setBinhLuans(List<BinhLuan> binhLuans) {
        this.binhLuans = binhLuans;
    }
}
