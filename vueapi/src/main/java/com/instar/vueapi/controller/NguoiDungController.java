package com.instar.vueapi.controller;

import com.instar.vueapi.entity.NguoiDung;
import com.instar.vueapi.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nguoidung")
public class NguoiDungController {

    @Autowired
    private NguoiDungRepository repo;

    @GetMapping
    public List<NguoiDung> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public NguoiDung getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public NguoiDung create(@RequestBody NguoiDung nd) {
        return repo.save(nd);
    }

    @PutMapping("/{id}")
    public NguoiDung update(@PathVariable String id, @RequestBody NguoiDung nd) {
        nd.setMaNguoiDung(id);
        return repo.save(nd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
