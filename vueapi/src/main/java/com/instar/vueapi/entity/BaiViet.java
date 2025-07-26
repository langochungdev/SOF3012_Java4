package com.instar.vueapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BaiViet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiViet {
    @Id
    @Column(name = "MaBaiViet", length = 50)
    private String maBaiViet;

    @ManyToOne
    @JoinColumn(name = "MaNguoiDung")
    private NguoiDung nguoiDung;

    @Column(name = "TieuDe", length = 200)
    private String tieuDe;

    @Column(name = "NoiDung", columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @OneToMany(mappedBy = "baiViet")
    @JsonIgnore
    private List<BinhLuan> binhLuans;
}
