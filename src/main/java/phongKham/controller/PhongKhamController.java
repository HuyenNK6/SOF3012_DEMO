package phongKham.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phongKham.model.PhongKham;
import phongKham.repository.PhongKhamRepository;

import java.io.IOException;

@WebServlet(name = "PhongKhamController", value = {
        "/phong-kham/hien-thi",
        "/phong-kham/view-add",
        "/phong-kham/view-update",
        "/phong-kham/delete",
        "/phong-kham/detail",
        "/phong-kham/add",
        "/phong-kham/update",
        "/phong-kham/search",
        "/phong-kham/paging"
})
public class PhongKhamController extends HttpServlet {
    PhongKhamRepository phongKhamRepository = new PhongKhamRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-add")) {
            viewAdd(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        } else if(uri.contains("detail")) {
            detail(req, resp);
        } else if(uri.contains("search")) {
            search(req, resp);
        } else if(uri.contains("paging")) {
            paging(req, resp);
        }
    }

    private void paging(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = 1;
        int pageSize = 2;
        if(req.getParameter("page") != null) {
            pageNo = Integer.valueOf(req.getParameter("page"));
        }
        req.setAttribute("pageNo", pageNo);
        req.setAttribute("danhSach", phongKhamRepository.paging(pageNo, pageSize));
        req.getRequestDispatcher("/phong-kham/hien-thi.jsp").forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        req.setAttribute("danhSach", phongKhamRepository.search(ten));
        req.getRequestDispatcher("/phong-kham/hien-thi.jsp").forward(req, resp);
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("phongKham", phongKhamRepository.getOne(id));
        req.getRequestDispatcher("/phong-kham/detail.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        phongKhamRepository.delete(new PhongKham(id, null, null));
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("phongKham", phongKhamRepository.getOne(id));
        req.getRequestDispatcher("/phong-kham/view-update.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/phong-kham/view-add.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", phongKhamRepository.getAll());
        req.getRequestDispatcher("/phong-kham/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            add(req, resp);
        } else if(uri.contains("update")) {
            update(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer soNha = Integer.valueOf(req.getParameter("soNha"));
        phongKhamRepository.update(new PhongKham(id, ten, soNha));
        resp.sendRedirect("/phong-kham/hien-thi");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        Integer soNha = Integer.valueOf(req.getParameter("soNha"));
        phongKhamRepository.add(new PhongKham(null, ten, soNha));
        resp.sendRedirect("/phong-kham/hien-thi");
    }
}
