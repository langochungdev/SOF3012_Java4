package com.instar.vueapi.repository;
import com.instar.vueapi.entity.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BaiVietRepository extends JpaRepository<BaiViet, String> {
    List<BaiViet> findByNguoiDung_MaNguoiDung(String maNguoiDung);
}
