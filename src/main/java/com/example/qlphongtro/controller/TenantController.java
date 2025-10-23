package com.example.qlphongtro.controller;

import com.example.qlphongtro.model.Tenant;
import com.example.qlphongtro.service.TenantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    private final TenantService service;

    public TenantController(TenantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tenant> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Tenant save(@RequestBody Tenant t) {
        return service.save(t);
    }
}
