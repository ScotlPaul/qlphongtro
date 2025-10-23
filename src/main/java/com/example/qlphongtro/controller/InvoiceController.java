package com.example.qlphongtro.controller;

import com.example.qlphongtro.model.Invoice;
import com.example.qlphongtro.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Invoice> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Invoice save(@RequestBody Invoice i) {
        return service.save(i);
    }
}
