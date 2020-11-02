package com.example.demomvc.service;

import com.example.demomvc.entity.OrganizeEntity;
import com.example.demomvc.respository.OrganizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizeService {
    @Autowired
    private OrganizeRepository organizeRepository;

    public List<OrganizeEntity> findAll(){
        return  organizeRepository.findAll();
    }
    public void createOrganize(OrganizeEntity organizeEntity){
        organizeRepository.save(organizeEntity);
    }
    public void deleteOrg(int id){
        organizeRepository.deleteById(id);
    }
    public OrganizeEntity getOne(int id){
       return organizeRepository.getOne(id);
    }
    public void update(OrganizeEntity organizeEntity){
        organizeRepository.save(organizeEntity);
    }
}
