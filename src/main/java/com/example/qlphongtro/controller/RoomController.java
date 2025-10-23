package com.example.qlphongtro.controller;

import com.example.qlphongtro.model.Room;
import com.example.qlphongtro.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 🏠 Hiển thị danh sách phòng
    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    // ➕ Hiển thị form thêm phòng
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("room", new Room());
        return "room-form";
    }

    // 💾 Lưu phòng
    @PostMapping("/add")
    public String addRoom(@ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }

    // ✏️ Sửa phòng (nếu cần)
    @GetMapping("/edit/{id}")
    public String editRoom(@PathVariable("id") Long id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "room-form";
    }

    // ❌ Xóa phòng
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
        return "redirect:/rooms";
    }
}
