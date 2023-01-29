package org.example.service;

import org.example.repository.MusteriRepository;

public class MusteriService {
    MusteriRepository musteriDao = new MusteriRepository();
    public void getAll(){
        try{
            musteriDao.getByMusteri();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getByMusteriId(){
        try{
            musteriDao.getByMusteriId();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getMusteriD(){
        try{
            musteriDao.getAllMusteriD();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
