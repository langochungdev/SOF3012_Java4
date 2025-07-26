package com.instar.vueapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.instar.vueapi.service.CloudinaryService;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return cloudinaryService.upload(file);
    }
}
