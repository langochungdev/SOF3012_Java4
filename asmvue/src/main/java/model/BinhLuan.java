package model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BinhLuan {

    @Id
    private String maBinhLuan;

    @Lob
    private String noiDung;

    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "maBaiViet")
    private BaiViet baiViet;

    private String maNguoiDung;

    // === GETTERS ===
    public String getMaBinhLuan() {
        return maBinhLuan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public BaiViet getBaiViet() {
        return baiViet;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    // === SETTERS ===
    public void setMaBinhLuan(String maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setBaiViet(BaiViet baiViet) {
        this.baiViet = baiViet;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
}
