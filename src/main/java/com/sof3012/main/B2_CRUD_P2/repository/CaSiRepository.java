package com.sof3012.main.B2_CRUD_P2.repository;

import com.sof3012.main.B2_CRUD_P2.entity.BaiHat;
import com.sof3012.main.B2_CRUD_P2.entity.CaSi;
import com.sof3012.main.B2_CRUD_P2.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CaSiRepository {
    private Session s;

    public CaSiRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<CaSi> getAll() {
        return s.createQuery("FROM CaSi").list();
    }

    public static void main(String[] args) {
        System.out.println(new CaSiRepository().getAll());
    }
}
