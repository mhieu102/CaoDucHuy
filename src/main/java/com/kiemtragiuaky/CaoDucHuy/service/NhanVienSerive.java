package com.kiemtragiuaky.CaoDucHuy.service;

import com.kiemtragiuaky.CaoDucHuy.entity.NhanVien;
import com.kiemtragiuaky.CaoDucHuy.repository.INhanVienRepository;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienSerive {

    @Autowired
    private INhanVienRepository nhanVienRepository;

    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    public NhanVien getById(String id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    public void add(NhanVien nhanvien) {
        nhanVienRepository.save(nhanvien);
    }

    public void DeleteNhanVienById(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        nhanVienRepository.deleteById(id);
    }

    public void updateNhanvien(@NotNull NhanVien nhanvien){
        if (nhanvien == null || nhanvien.getMa_NV() == null) {
            throw new IllegalArgumentException("Invalid nhanvien object");
        }

        NhanVien existingBook = getById(nhanvien.getMa_NV());


        existingBook.setMa_NV(nhanvien.getMa_NV());
        existingBook.setTen_NV(nhanvien.getTen_NV());
        existingBook.setPhai(nhanvien.getPhai());
        existingBook.setNoi_Sinh(nhanvien.getNoi_Sinh());
        existingBook.setLuong(nhanvien.getLuong());
        existingBook.setPhongban(nhanvien.getPhongban());


        nhanVienRepository.save(existingBook);
    }
}