package com.instar.vueapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "BinhLuan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinhLuan {
    @Id
    @Column(name = "MaBinhLuan", length = 50)
    private String maBinhLuan;

    @ManyToOne
    @JoinColumn(name = "MaBaiViet")
    private BaiViet baiViet;

    @Column(name = "MaNguoiDung", length = 50)
    private String maNguoiDung;

    @Column(name = "NoiDung", columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
}
