package deThiThu.sanPham.repository;

import deThiThu.sanPham.model.LoaiSanPham;
import deThiThu.sanPham.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LoaiSPRepository {
    private Session s;

    public LoaiSPRepository() {
        s= HibernateConfig.getFACTORY().openSession();
    }
    public List<LoaiSanPham> getAll(){
        return s.createQuery("FROM LoaiSanPham").list();
    }
    public LoaiSanPham getOne(Integer id){
        return s.find(LoaiSanPham.class,id);
    }
}
