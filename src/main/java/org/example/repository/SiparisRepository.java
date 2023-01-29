package org.example.repository;

import org.example.entitiy.Siparis;

import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SiparisRepository {

    private Session session = null;


    public void save(Siparis siparis){

        try{
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println(siparis.getId() + " nolu sipariş kaydedilmiştir.");
            session.close();
        }catch (Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getCause();
        }
    }
    public List<Siparis> getAll() {
        List<Siparis> list = null;
        try {

            session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return list;
    }

    public void update(Siparis siparis){
        try{

            session.beginTransaction();
            session.update(siparis);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteById(int id){
        try{


            session.beginTransaction();
            Siparis siparis = session.load(Siparis.class,id);
            session.delete(siparis);
            session.getTransaction().commit();
        }catch (Exception e){
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }
    }
}
