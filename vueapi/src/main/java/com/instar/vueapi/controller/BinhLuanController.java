package com.instar.vueapi.controller;

import com.instar.vueapi.entity.BinhLuan;
import com.instar.vueapi.repository.BinhLuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/binhluan")
public class BinhLuanController {

    @Autowired
    private BinhLuanRepository repo;

    @GetMapping
    public List<BinhLuan> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public BinhLuan getById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public BinhLuan create(@RequestBody BinhLuan bl) {
        return repo.save(bl);
    }

    @PutMapping("/{id}")
    public BinhLuan update(@PathVariable String id, @RequestBody BinhLuan bl) {
        bl.setMaBinhLuan(id);
        return repo.save(bl);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}
