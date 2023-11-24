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

    //A CAMADA SERVICE FAZ TODOS OS SERVIÇOS ENVOLVENDO O BANCO DE DADOS E PASSANDO PARA OS CONTROLLERS RETORNAR


    @Autowired
    private FolhaPagamentoRepository rep;

    @Transactional(readOnly = true)
    public List<FolhaPagamentoDTO>findAll(){
        List<FolhaPagamento>list = rep.findAll();
        return list.stream().map(FolhaPagamentoDTO::new).toList(); //SERVIÇO PARA RETORNAR TODAS AS FOLHAS DE PAGAMENTO
    }
    @Transactional(readOnly = true)
    public FolhaPagamento insert(FolhaPagamento folha){
        return rep.save(folha); // SERVIÇO PARA CADASTRAR UM NOVA FOLHA
    }
    @Transactional(readOnly = true)
    public void deleteById(Long id){
        rep.deleteById(id); //SERVIÇO PARA DELETAR PELO ID
    }
    @Transactional(readOnly = true)
    public FolhaPagamento update(Long id, FolhaPagamento fp){
        FolhaPagamento folha = rep.getReferenceById(id);
        updateData(folha,fp);
        return rep.save(folha);  //SERVIÇO PARA ATUALIZAR A FOLHA DE PAGAMENTO
    }
    @Transactional(readOnly = true)
    public void updateData(FolhaPagamento fp, FolhaPagamento obj){
        fp.setSalario(obj.getSalario());
        fp.setBonus(obj.getBonus());
        fp.setDescontos(obj.getDescontos()); //SERVIÇO PARA ATUALIZAR A FOLHA DE PAGAMENTO
    }
    @Transactional(readOnly = true)
    public FolhaPagamentoDTO findById(Long id){
        FolhaPagamento folha = rep.findById(id).get();
        return new FolhaPagamentoDTO(folha);//SERVIÇO PARA RETORNAR A FOLHA DE PAGAMENTO PELO ID
    }

    public List<FolhaPagamentoDTO>findByCargo(String cargo){
        List<FolhaPagamento> list = rep.findByCargo(cargo);
        return list.stream().map(FolhaPagamentoDTO::new).toList();//FAZ O SERVIÇO PARA RETORNAR A LISTA PELO CARGO DOS FUNCIONARIOS
    }
}
