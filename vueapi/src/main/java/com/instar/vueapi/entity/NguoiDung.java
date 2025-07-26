package com.instar.vueapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "NguoiDung")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDung {
    @Id
    @Column(name = "MaNguoiDung", length = 50)
    private String maNguoiDung;

    @Column(name = "Ten", length = 100)
    private String ten;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "MatKhau", length = 255)
    private String matKhau;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "AnhDaiDien", length = 255)
    private String anhDaiDien;

    @OneToMany(mappedBy = "nguoiDung")
    @JsonIgnore
    private List<BaiViet> baiViets;
}
