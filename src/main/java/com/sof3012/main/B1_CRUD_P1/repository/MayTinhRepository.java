package com.sof3012.main.B1_CRUD_P1.repository;

import com.sof3012.main.B1_CRUD_P1.entity.MayTinh1;
import com.sof3012.main.B1_CRUD_P1.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MayTinhRepository {

    private Session s;

    public MayTinhRepository(){
        s = HibernateUtil.getFACTORY().openSession(); // Mo cong ket noi
    }

    public List<MayTinh1>getAll(){
        return s.createQuery("FROM MayTinh1").list();
    }

    public static void main(String[] args) {
        System.out.println(new MayTinhRepository().getAll());
    }
}
