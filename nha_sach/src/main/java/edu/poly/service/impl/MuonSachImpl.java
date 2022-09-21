package edu.poly.service.impl;

import edu.poly.entity.MuonSach;
import edu.poly.repository.MuonSachRepository;
import edu.poly.service.MuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuonSachImpl implements MuonSachService {
    @Autowired
    MuonSachRepository muonSachRepository;

    @Override
    public MuonSach save(MuonSach muonSach) {
        if(muonSach.getId()==null){
            return muonSachRepository.save(muonSach);
        }
        return null;
    }

    @Override
    public MuonSach update(MuonSach muonSach) {
        Integer id = muonSach.getId();
        System.out.println("-- ID UPDATE: "+id);
        if(id!=null){
            Optional<MuonSach> nxb = findById(id);
            if(!nxb.isEmpty()){
                return muonSachRepository.save(muonSach);
            }
        }
        return null;
    }
    @Override
    public Boolean deleteById(Integer id) {
        System.out.println("-- ID DELETE: "+id);
        if(id!=null){
            Optional<MuonSach> nxb = findById(id);
            if(!nxb.isEmpty()){
                muonSachRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }
    @Override
    public List<MuonSach> findAll(){
        return muonSachRepository.findAll();
    }

    @Override
    public Optional<MuonSach> findById(Integer id) {
        return muonSachRepository.findById(id);
    }
}
