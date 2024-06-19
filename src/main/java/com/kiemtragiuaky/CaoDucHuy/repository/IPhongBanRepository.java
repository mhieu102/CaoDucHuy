package com.kiemtragiuaky.CaoDucHuy.repository;

import com.kiemtragiuaky.CaoDucHuy.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, String> {

}
