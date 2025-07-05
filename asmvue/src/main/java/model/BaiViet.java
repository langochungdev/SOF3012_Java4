package model;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonIgnore // ✅ tránh vòng lặp khi serialize BaiViet → binhLuans → baiViet...
    private List<BinhLuan> binhLuans;
}
