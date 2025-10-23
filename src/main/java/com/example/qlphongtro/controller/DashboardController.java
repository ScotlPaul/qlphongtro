package com.example.qlphongtro.controller;

import com.example.qlphongtro.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private UserService userService;

    @GetMapping({ "/", "/dashboard" })
    public String dashboard(Model model) {
        model.addAttribute("roomCount", roomService.countRooms());
        model.addAttribute("tenantCount", tenantService.countTenants());
        model.addAttribute("invoiceCount", invoiceService.countInvoices());
        model.addAttribute("userCount", userService.countUsers());
        return "dashboard";
    }
}
