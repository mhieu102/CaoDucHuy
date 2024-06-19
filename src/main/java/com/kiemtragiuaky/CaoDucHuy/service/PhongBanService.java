
package com.kiemtragiuaky.CaoDucHuy.service;

import com.kiemtragiuaky.CaoDucHuy.entity.NhanVien;
import com.kiemtragiuaky.CaoDucHuy.entity.PhongBan;
import com.kiemtragiuaky.CaoDucHuy.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {

    @Autowired
    private IPhongBanRepository phongBanRepository;

    public List<PhongBan> getAll() {
        return phongBanRepository.findAll();
    }

    public PhongBan getById(String id) {
        return phongBanRepository.findById(id).orElse(null);
    }

    public void add(PhongBan phongBan ) {
        phongBanRepository.save(phongBan);
    }
    public PhongBan save(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }


    public void DeleteNhanVienById(String id) {
        if (!phongBanRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        phongBanRepository.deleteById(id);
    }

/*    public void delete(String id){
        phongBanRepository.deleteById(id);
       } */

}
