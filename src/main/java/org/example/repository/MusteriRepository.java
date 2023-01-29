package org.example.repository;


import org.example.entitiy.Musteri;
import org.example.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class MusteriRepository {
    private Session session = null;
    public void getByMusteri(){
        List<Object> list = null;
        try{

            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Musteri.class);
            list = criteria.list();
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getByMusteriId(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select m.id, sk.adet from siparis as s\n" +
                    "inner join siparis_sipariskalemi as ssk\n" +
                    "on s.id = ssk.Siparis_id\n" +
                    "inner join sipariskalemi as sk\n" +
                    "on ssk.siparisKalemi_id = sk.id\n" +
                    "inner join urun as u\n" +
                    "on u.id = sk.urun_id\n" +
                    "inner join musteri as m\n" +
                    "on m.id = s.musteri_id\n";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Müşteri Id : " + item[0] + ", "
                                + "Sipariş sayısı : " + item[1]
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getAllMusteriD(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select m.isim,m.soyad,s.id from siparis as s\n" +
                    "inner join siparis_sipariskalemi as ssk\n" +
                    "on s.id = ssk.Siparis_id\n" +
                    "inner join sipariskalemi as sk\n" +
                    "on ssk.siparisKalemi_id = sk.id\n" +
                    "inner join urun as u\n" +
                    "on u.id = sk.urun_id\n" +
                    "inner join musteri as m\n" +
                    "on m.id = s.musteri_id\n" +
                    "\n";
            list = entityManager.createNativeQuery(query).getResultList();
            for(Object[] item:list){
                System.out.println(
                        "Müşteri Ad : " + item[0] + " "
                                + "Müşteri Soyad : " + item[1] + " "
                                + "Sipariş ID: " + item[2]
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
