package com.kiemtragiuaky.CaoDucHuy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    private String Ma_NV;

    @NotBlank(message = "Tên là bắt buộc")
    private String Ten_NV;
    private String Phai;
    private String Noi_Sinh;
    @ManyToOne
    @JoinColumn(name = "Phong_Ban")
    private PhongBan phongban;
    private int Luong;
}
