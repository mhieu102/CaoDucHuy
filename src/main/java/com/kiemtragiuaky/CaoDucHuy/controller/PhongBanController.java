package com.kiemtragiuaky.CaoDucHuy.controller;

import com.kiemtragiuaky.CaoDucHuy.entity.NhanVien;
import com.kiemtragiuaky.CaoDucHuy.entity.PhongBan;
import com.kiemtragiuaky.CaoDucHuy.service.NhanVienSerive;
import com.kiemtragiuaky.CaoDucHuy.service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PhongBanController {
    @Autowired
    private final PhongBanService phongBanService;

    @GetMapping("/phongbans/add")
    public String showAddForm(Model model) {
        model.addAttribute("phongban", new PhongBan());
        return "/PhongBan/add";
    }

    @PostMapping("/phongbans/add")
    public String addCategory(@Valid PhongBan phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "/PhongBan/add";
        }
        phongBanService.add(phongban);
        return "redirect:/phongbans";
    }

    // Hiển thị danh sách danh mục
    @GetMapping("/phongbans")
    public String listCategories(Model model) {
        List<PhongBan> phongbans = phongBanService.getAll();
        model.addAttribute("phongbans", phongbans);
        return "/PhongBan/list";
    }
    /*@GetMapping("/phongban/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        PhongBan phongban = phongBanService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phongban Id:"
                        + id));
        model.addAttribute("phongban", phongban);
        return "/phongban/update-phongban";
    }
    // POST request to update category
    @PostMapping("/phongban/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid PhongBan phongban,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            phongban.setId(id);
            return "/phongban/update-phongban";
        }
        phongBanService.updatePhongBan(phongban);
        model.addAttribute("phongbans", phongBanService.getAll());
        return "redirect:/phongban";
    }
    // GET request for deleting category
    @GetMapping("/phongban/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id, Model model) {
        PhongBan phongban = phongBanService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phongban Id:"
                        + id));
        phongBanService.deleteById(id);
        model.addAttribute("phongbans", phongBanService.getAll());
        return "redirect:/phongban";
    }*/
}



