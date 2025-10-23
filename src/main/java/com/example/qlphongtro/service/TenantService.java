package com.example.qlphongtro.service;

import com.example.qlphongtro.model.Tenant;
import com.example.qlphongtro.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TenantService {
    private final TenantRepository repo;

    @Autowired
    private TenantRepository tenantRepository;

    public TenantService(TenantRepository repo) {
        this.repo = repo;
    }

    public List<Tenant> getAll() {
        return repo.findAll();
    }

    public Tenant save(Tenant t) {
        return repo.save(t);
    }

    public long countTenants() {
        return tenantRepository.count();
    }
}
