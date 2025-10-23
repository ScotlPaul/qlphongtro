package com.example.qlphongtro.service;

import com.example.qlphongtro.model.Invoice;
import com.example.qlphongtro.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository repo;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository repo) {
        this.repo = repo;
    }

    public List<Invoice> getAll() {
        return repo.findAll();
    }

    public Invoice save(Invoice i) {
        return repo.save(i);
    }

    public long countInvoices() {
        return invoiceRepository.count();
    }

}
