package org.example.service;

import org.example.entitiy.Siparis;
import org.example.entitiy.SiparisKalemi;
import org.example.repository.SiparisRepository;

import java.util.List;


public class SiparisService {
    SiparisRepository siparisRepository = new SiparisRepository();
    public void save(Siparis siparis){
        try{
            siparisRepository.save(siparis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void siparisleriListele(){
        List<Siparis> siparisList=siparisRepository.getAll();
        for(Siparis s: siparisList){
            int toplam=0;
            System.out.println("SiparisId:"+s.getId()+",Müsteri Ad Soyad:"+s.getMusteri().getIsim()+""+
                    s.getMusteri().getSoyad()+"Müsteri Id:"+s.getMusteri().getId());
            for(SiparisKalemi sk:s.getSiparisKalemi()){
                System.out.println("Ürün Adı:"+sk.getUrun()+",Fiyat:"+sk.getUrun().getFiyat()+",Adet Sayısı" +sk.getAdet());
                  toplam=toplam+sk.getAdet()+sk.getUrun().getFiyat();
            }
            System.out.println("Sipariş toplam:"+toplam);
        }
    }






    public void getAll(){
        try{
            siparisRepository.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void update(Siparis siparis){
        try{
            siparisRepository.update(siparis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            siparisRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
