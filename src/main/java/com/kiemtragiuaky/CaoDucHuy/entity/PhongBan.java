package com.kiemtragiuaky.CaoDucHuy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    private String Ma_Phong;

    @NotBlank(message = "Tên là bắt buộc")
    private String name;
}

