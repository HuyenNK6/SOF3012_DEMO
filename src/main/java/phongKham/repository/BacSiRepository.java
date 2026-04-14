package phongKham.repository;

import org.hibernate.Session;
import phongKham.model.BacSi;
import phongKham.util.HibernateConfig;

import java.util.List;

public class BacSiRepository {
    private Session s;
    //Session giống như kết nối giữa Java và database; Mỗi lần muốn truy vấn DB thì cần session
    public BacSiRepository() {
        s = HibernateConfig.getFACTORY().openSession();
    }
    /*
        - HQL (Hibernate Query Language) là ngôn ngữ truy vấn của Hibernate dùng để làm việc với dữ liệu
        thông qua các class Java (Entity) thay vì thao tác trực tiếp với bảng trong database
            + SQL → làm việc với bảng (table), cột (column)
            + HQL → làm việc với class (entity), thuộc tính (field)
     */
    public List<BacSi> getAll() {
        return s.createQuery("FROM BacSi").list();
    }

    public BacSi getOne(Integer id) {
        return s.find(BacSi.class, id);
    }

    public void add(BacSi bacSi) {
        try {
            s.getTransaction().begin(); // bắt đầu transaction
            s.save(bacSi); // insert dữ liệu vào DB
            s.getTransaction().commit(); //xác nhận lưu
        } catch (Exception e) {
            s.getTransaction().rollback(); //hủy toàn bộ thao tác (tránh lỗi dữ liệu)
            e.printStackTrace();
        }
    }

    public void update(BacSi bacSi) {
        try {
            s.getTransaction().begin();
            s.merge(bacSi);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            s.getTransaction().begin();
            s.delete(this.getOne(id));
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
