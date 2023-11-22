package com.marques.service;

import com.marques.domain.FolhaPagamento;
import com.marques.dtos.FolhaPagamentoDTO;
import com.marques.repository.FolhaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FolhaPagamentoService {

    @Autowired
    private FolhaPagamentoRepository rep;

    @Transactional(readOnly = true)
    public List<FolhaPagamentoDTO>findAll(){
        List<FolhaPagamento>list = rep.findAll();
        return list.stream().map(FolhaPagamentoDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public FolhaPagamento insert(FolhaPagamento folha){
        return rep.save(folha);
    }
    @Transactional(readOnly = true)
    public void deleteById(Long id){
        rep.deleteById(id);
    }
    @Transactional(readOnly = true)
    public FolhaPagamento update(Long id, FolhaPagamento fp){
        FolhaPagamento folha = rep.getReferenceById(id);
        updateData(folha,fp);
        return rep.save(folha);
    }
    @Transactional(readOnly = true)
    public void updateData(FolhaPagamento fp, FolhaPagamento obj){
        fp.setSalario(obj.getSalario());
        fp.setBonus(obj.getBonus());
        fp.setDescontos(obj.getDescontos());
    }
    @Transactional(readOnly = true)
    public FolhaPagamentoDTO findById(Long id){
        FolhaPagamento folha = rep.findById(id).get();
        return new FolhaPagamentoDTO(folha);
    }

    public List<FolhaPagamentoDTO>findByCargo(String cargo){
        List<FolhaPagamento> list = rep.findByCargo(cargo);
        return list.stream().map(FolhaPagamentoDTO::new).toList();
    }
}
