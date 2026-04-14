package phongKham.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import phongKham.model.PhongKham;
import phongKham.util.HibernateConfig;

import java.util.List;

public class PhongKhamRepository {
    private Session s;

    public PhongKhamRepository() {
        s = HibernateConfig.getFACTORY().openSession();
    }

    public List<PhongKham> getAll() {
        // SQL - native query
        // JPQL
        return s.createQuery("FROM PhongKham").list();
    }

    public PhongKham getOne(Integer id) {
        return s.find(PhongKham.class, id);
    }

    public void add(PhongKham phongKham) {
        try {
            s.getTransaction().begin();
            s.save(phongKham);
            s.getTransaction().commit();
        } catch(Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(PhongKham phongKham) {
        try {
            s.getTransaction().begin();
            s.merge(phongKham);
            s.getTransaction().commit();
        } catch(Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(PhongKham phongKham) {
        try {
            s.getTransaction().begin();
            s.delete(this.getOne(phongKham.getId()));
            s.getTransaction().commit();
        } catch(Exception e) {
            s.getTransaction().rollback();
        }
    }

    public List<PhongKham> search(String ten) {
        Query query = s.createQuery("FROM PhongKham WHERE ten LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        return (List<PhongKham>) query.list();
    }

    public List<PhongKham> paging(int pageNo, int pageSize) {
        Query query = s.createQuery("FROM PhongKham");
        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize);
        return (List<PhongKham>) query.list();
    }
}
