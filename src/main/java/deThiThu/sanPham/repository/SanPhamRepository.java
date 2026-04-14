package deThiThu.sanPham.repository;

import deThiThu.sanPham.model.SanPham;
import deThiThu.sanPham.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    private Session s;

    public SanPhamRepository() {
        s = HibernateConfig.getFACTORY().openSession(); //mở phiên làm việc của session
    }
    //truy vấn trực tiếp trên thực thể: HQL (Hibernate Query Languge) không còn dùng SQL
    //ko còn select * from...
    /* Lỗi 1: is not mapped
     -  chưa có @Entity
     - chưa cấu hình trong hibernate config: Configuration -> addAnnotatedClass
       Lỗi 2: invalid column  name
       -> kiểm tra lại @Column (name) xem chính xác chưa => đã mapping chưa?
     */
    public List<SanPham> getAll(){
        return s.createQuery("FROM SanPham").list();
    }
    public SanPham getOne(Integer id){
        return s.find(SanPham.class, id);
    }
    public void add(SanPham sanPham){
        try {
            s.getTransaction().begin();
            s.save(sanPham);
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void update(SanPham sanPham){
        try {
            s.getTransaction().begin();
            s.merge(sanPham);
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(Integer id){
        try {
            s.getTransaction().begin();
            s.delete(this.getOne(id));
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getAll());
//        System.out.println(new SanPhamRepository().getOne(1).toString());
    }
}
