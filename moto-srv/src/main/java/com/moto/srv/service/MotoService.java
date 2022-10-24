package com.moto.srv.service;


import com.moto.srv.entity.Moto;
import com.moto.srv.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public Moto getMoto(Long id){
        return motoRepository.findById(id).orElse(null);
    }
    public List<Moto> getAll(){
        return motoRepository.findAll();
    }
    public List<Moto> getMotosByUserId(Long id){return motoRepository.findByUserId(id);}
    public Moto saveMoto(Moto moto){
        return motoRepository.save(moto);
    }
}
