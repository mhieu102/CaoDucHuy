package com.kiemtragiuaky.CaoDucHuy.controller;

import com.kiemtragiuaky.CaoDucHuy.entity.NhanVien;
import com.kiemtragiuaky.CaoDucHuy.service.NhanVienSerive;
import com.kiemtragiuaky.CaoDucHuy.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienSerive nhanvienService;
    @Autowired
    private PhongBanService phongbanService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("nhanviens", nhanvienService.getAll());
        return "NhanVien/list";
    }

    // For adding
    @GetMapping("/add")
    public String addNhanVien(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans", phongbanService.getAll());
        return "NhanVien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(NhanVien newNhanvien, Model model) {
        nhanvienService.add(newNhanvien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanvienService.DeleteNhanVienById(id);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{Ma_NV}")
    public String showEditForm(@PathVariable("Ma_NV") String Ma_NV, Model model) {
        NhanVien nhanVien = nhanvienService.getById(Ma_NV);

        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("phongbans", phongbanService.getAll()); //Load categories
        return "/nhanvien/edit";
    }
    // Process the form for updating a product
    @PostMapping("/edit/{Ma_NV}")
    public String updateNhanVien( @PathVariable("Ma_NV") String Ma_NV,  NhanVien nhanVien) {


        nhanvienService.updateNhanvien(nhanVien);
        return "redirect:/nhanviens";
    }

}
