package com.sof3012.main.B1_CRUD_P1.servlet;

import com.sof3012.main.B1_CRUD_P1.repository.MayTinhRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MayTinhServlet", value = {
        "/may-tinh/hien-thi", // GET
        "/may-tinh/detail",// GET
        "/may-tinh/view-update",// GET
        "/may-tinh/update",// POST
        "/may-tinh/add", // POST
        "/may-tinh/remove", // GET
})
public class MayTinhServlet extends HttpServlet {

    private MayTinhRepository mtRepository = new MayTinhRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            this.detailDuLieu(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateDuLieu(request, response);
        } else {
            // REMOVE
            this.removeDuLieu(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addDuLieu(request, response);
        } else {
            // UPDATE
            this.updateDuLieu(request, response);
        }
    }

    private void updateDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailDuLieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists",mtRepository.getAll());
        request.getRequestDispatcher("/buoi1/may-tinh.jsp").forward(request,response);
    }

}
