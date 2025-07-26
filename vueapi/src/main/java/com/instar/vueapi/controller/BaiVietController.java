package com.instar.vueapi.controller;
import com.instar.vueapi.entity.BaiViet;
import com.instar.vueapi.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/baiviet")
public class BaiVietController {

    @Autowired
    private BaiVietRepository repo;

    @GetMapping
    public List<BaiViet> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public BaiViet getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }


    @GetMapping(params = "maNguoiDung")
    public List<BaiViet> getByUserId(@RequestParam("maNguoiDung") String maNguoiDung) {
        return repo.findByNguoiDung_MaNguoiDung(maNguoiDung);
    }


    @PostMapping
    public BaiViet create(@RequestBody BaiViet bv) {
        return repo.save(bv);
    }

    @PutMapping("/{id}")
    public BaiViet update(@PathVariable String id, @RequestBody BaiViet bv) {
        bv.setMaBaiViet(id);
        return repo.save(bv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
