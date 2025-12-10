package com.sof3012.main.B2_CRUD_P2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "ten_bai_hat", length = 100)
    private String tenBaiHat;

    @Nationalized
    @Column(name = "ten_tac_gia", length = 100)
    private String tenTacGia;

    @Column(name = "thoi_luong")
    private Integer thoiLuong;

    @Column(name = "ngay_san_xuat")
    private Date ngaySanXuat;

    @Column(name = "gia")
    private Double gia;

    @ManyToOne
    @JoinColumn(name = "ca_si_id")
    private CaSi caSi;
    // Bai hat & Ca Si
    // 1 Bai hat -> 1 Ca Si
    // 1 Ca si -> N Bai hat  => N -> 1 (ManyToOne)

    @Column(name = "phat_hanh_dia")
    private Boolean phatHanhDia;

    @Column(name = "ngay_ra_mat")
    private LocalDate ngayRaMat;

}