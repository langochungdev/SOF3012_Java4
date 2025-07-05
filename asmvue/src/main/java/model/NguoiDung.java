package model;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonIgnore // ✅ tránh vòng lặp khi serialize NguoiDung → baiViets → nguoiDung...
    private List<BaiViet> baiViets;
}
