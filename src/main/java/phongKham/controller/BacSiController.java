package phongKham.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phongKham.model.BacSi;
import phongKham.repository.BacSiRepository;
import phongKham.repository.PhongKhamRepository;

import java.io.IOException;
@WebServlet(name = "BacSiController", value = {
        "/bac-si/hien-thi",
        "/bac-si/view-update",
        "/bac-si/detail",
        "/bac-si/delete",
        "/bac-si/add",
        "/bac-si/update"
})
public class BacSiController extends HttpServlet {
    BacSiRepository bacSiRepository = new BacSiRepository();
    PhongKhamRepository phongKhamRepository = new PhongKhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("bacSi", bacSiRepository.getOne(id));
        req.setAttribute("listPhongKham", phongKhamRepository.getAll());
        req.getRequestDispatcher("/bac-si/detail.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        bacSiRepository.delete(id);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("bacSi", bacSiRepository.getOne(id));
        req.setAttribute("listPhongKham", phongKhamRepository.getAll());
        req.getRequestDispatcher("/bac-si/view-update.jsp").forward(req, resp);

    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPhongKham", phongKhamRepository.getAll());
        req.setAttribute("listBacSi", bacSiRepository.getAll());
        req.getRequestDispatcher("/bac-si/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        } else {
            update(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Integer idPhongKham = Integer.valueOf(req.getParameter("phongKham"));

        BacSi bacSi = new BacSi(id, ten, diaChi, luong, phongKhamRepository.getOne(idPhongKham));
        bacSiRepository.update(bacSi);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        Float luong = Float.valueOf(req.getParameter("luong"));
        Integer idPhongKham = Integer.valueOf(req.getParameter("phongKham"));

        BacSi bacSi = new BacSi(null, ten, diaChi, luong, phongKhamRepository.getOne(idPhongKham));
        bacSiRepository.add(bacSi);
        resp.sendRedirect("/bac-si/hien-thi");
    }
}
