package com.sof3012.main.B1_CRUD_P1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // IS NOT MAPPER
@Table(name = "may_tinh")
@ToString
public class MayTinh1 {
    // Mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma")
    private Integer id;
    // COLUMN THEM TEN KHI MA: TEN BIEN TRONG JAVA KHAC VS TEN BIEN TRONG SQL
    // (THI BAT BUOC PHAI THEM NAME TRONG COLUM)
    @Column
    private String ten;

    @Column
    private Float gia;

    @Column(name = "bo_nho")
    private String boNho;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column
    private String hang;

    @Column(name = "mieu_ta")
    private String mieuTa;

}
