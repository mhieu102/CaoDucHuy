package com.kiemtragiuaky.CaoDucHuy.repository;

import com.kiemtragiuaky.CaoDucHuy.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}
