package com.sof3012.main.B2_CRUD_P2.repository;

import com.sof3012.main.B2_CRUD_P2.entity.BaiHat;
import com.sof3012.main.B2_CRUD_P2.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BaiHatRepository {

    private Session s;

    public BaiHatRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<BaiHat> getAll() {
        return s.createQuery("FROM BaiHat").list();
    }

    public BaiHat getOne(Integer id) {
        return s.find(BaiHat.class, id);
    }

    public void add(BaiHat bh) {
        try {
            s.getTransaction().begin();
            s.persist(bh);
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public void delete(BaiHat bh) {
        try {
            s.getTransaction().begin();
            s.delete(bh);
            s.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new BaiHatRepository().getAll());
    }
}
