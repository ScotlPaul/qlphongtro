package com.example.qlphongtro.repository;

import com.example.qlphongtro.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {}
