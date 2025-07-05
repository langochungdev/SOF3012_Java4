package model;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
