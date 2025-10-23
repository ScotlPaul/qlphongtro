package com.example.qlphongtro.repository;

import com.example.qlphongtro.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {}
