package com.example.qlphongtro.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ⚡ Tiền điện
    private double electric;

    // 💧 Tiền nước
    private double water;

    // 💰 Tổng cộng
    private double total;

    // 🗓️ Ngày tạo hoá đơn
    private LocalDate createdAt = LocalDate.now();

    // 🔗 Liên kết với phòng
    @ManyToOne
    @JoinColumn(name = "room_id") // Tên cột trong DB
    private Room room; // 👈 thêm dòng này để khớp với mappedBy = "room"

    public Invoice() {
    }

    public Invoice(double electric, double water, double total, Room room) {
        this.electric = electric;
        this.water = water;
        this.total = total;
        this.room = room;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
