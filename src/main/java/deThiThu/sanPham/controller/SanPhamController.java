package deThiThu.sanPham.controller;

import deThiThu.sanPham.model.SanPham;
import deThiThu.sanPham.repository.LoaiSPRepository;
import deThiThu.sanPham.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SanPhamController", value = {
        "/san-pham/hien-thi",
        "/san-pham/detail",
        "/san-pham/delete",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/add"
})
public class SanPhamController extends HttpServlet {
    SanPhamRepository sanPhamRepository= new SanPhamRepository();
    LoaiSPRepository loaiSPRepository= new LoaiSPRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req,resp);
        }else if(uri.contains("detail")){
            detail(req,resp);
        }else if(uri.contains("view-update")){
            viewUpdate(req, resp);
        }else if(uri.contains("delete")){
            delete(req, resp);
        }

    }
    protected void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lstSanPham", sanPhamRepository.getAll());
        req.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(req,resp);
    }
    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sanPham", sanPhamRepository.getOne(id));
        req.setAttribute("lstLoaiSP", loaiSPRepository.getAll());
        req.setAttribute("lstSanPham", sanPhamRepository.getAll());
        req.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(req,resp);
    }
    protected void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        req.setAttribute("sanPham", sanPhamRepository.getOne(id));
        req.setAttribute("lstLoaiSP", loaiSPRepository.getAll());
        req.getRequestDispatcher("/san-pham/view-update.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        sanPhamRepository.delete(id);
//        req.setAttribute("lstSanPham", sanPhamRepository.getAll());
//        req.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(req,resp);
        resp.sendRedirect("/san-pham/hien-thi");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("add")){
            add(req,resp);
        }else if(uri.contains("update")){
            update(req,resp);
        }

    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        String ma= req.getParameter("ma");
        String ten= req.getParameter("ten");
        String moTa= req.getParameter("moTa");
        String website= req.getParameter("website");
        Double giaBan= Double.valueOf(req.getParameter("giaBan"));
        Integer soLuong= Integer.valueOf(req.getParameter("soLuong"));
        Integer idLoaiSP= Integer.valueOf(req.getParameter("loaiSanPham"));
        Integer trangThai= Integer.valueOf(req.getParameter("trangThai"));

        SanPham sp= new SanPham(id,ma,ten,moTa,website,
                giaBan,soLuong,
                loaiSPRepository.getOne(idLoaiSP),trangThai);
        sanPhamRepository.add(sp);
        resp.sendRedirect("/san-pham/hien-thi");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        String ma= req.getParameter("ma");
        String ten= req.getParameter("ten");
        String moTa= req.getParameter("moTa");
        String website= req.getParameter("website");
        Double giaBan= Double.valueOf(req.getParameter("giaBan"));
        Integer soLuong= Integer.valueOf(req.getParameter("soLuong"));
        Integer idLoaiSP= Integer.valueOf(req.getParameter("loaiSanPham"));
        Integer trangThai= Integer.valueOf(req.getParameter("trangThai"));

        SanPham sp= new SanPham(id,ma,ten,moTa,website,
                giaBan,soLuong,
                loaiSPRepository.getOne(idLoaiSP),trangThai);
        sanPhamRepository.update(sp);
        resp.sendRedirect("/san-pham/hien-thi");
    }
}
