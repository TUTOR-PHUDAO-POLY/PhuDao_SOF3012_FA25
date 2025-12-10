package com.sof3012.main.B2_CRUD_P2.servlet;

import com.sof3012.main.B2_CRUD_P2.entity.BaiHat;
import com.sof3012.main.B2_CRUD_P2.repository.BaiHatRepository;
import com.sof3012.main.B2_CRUD_P2.repository.CaSiRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "BaiHatServlet", value = {
        "/song-management/playlists",
        "/song-management/add",
        "/song-management/detail",
        "/song-management/remove",
})
public class BaiHatServlet extends HttpServlet {

    private BaiHatRepository baiHatRepository = new BaiHatRepository();

    private CaSiRepository caSiRepository = new CaSiRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("playlists")) {
            this.hienThiDanhSachBaiHat(request, response);
        } else if (uri.contains("remove")) {
            this.removeBaiHat(request, response);
        } else {
            this.detailBaiHat(request, response);
        }
    }

    private void removeBaiHat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id2"));
        BaiHat bh = baiHatRepository.getOne(id);
        baiHatRepository.delete(bh);
        response.sendRedirect("/song-management/playlists");
    }

    private void detailBaiHat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id1"));
        request.setAttribute("baiHat", baiHatRepository.getOne(id));
        // C1: Copy toan bo noi dung cua ham hien thi danh sach
        // C2: Chuyen ham hien thi
        this.hienThiDanhSachBaiHat(request, response);
    }

    private void hienThiDanhSachBaiHat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBaiHat", baiHatRepository.getAll());
        request.setAttribute("listCaSi", caSiRepository.getAll());
        request.getRequestDispatcher("/buoi2/bai-hat.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xu ly add luon => vi chi co 1 chuc nang 
        // B1: Lay toan bo du lieu tu form
        BaiHat bh = new BaiHat();
        // MAPPING TOAN BO DU LIEU TREN FORM CHO THUOC TINH CUA DOI TUONG BAI HAT
        BeanUtils.populate(bh, request.getParameterMap());
        // Lay date tu request.getParameter
        String date = request.getParameter("ngayRaMat1");
        //Ep kieu roi set lai cho doi tuong
        bh.setNgayRaMat(LocalDate.parse(date));
        // B2: Goi add trong repository
        baiHatRepository.add(bh);
        // B3:Quay ve trang chu
        response.sendRedirect("/song-management/playlists");
    }
}
