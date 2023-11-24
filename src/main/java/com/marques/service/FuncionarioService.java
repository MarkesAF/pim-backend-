package com.marques.service;

import com.marques.domain.Funcionario;
import com.marques.dtos.FuncionarioDTO;
import com.marques.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    //A CAMADA SERVICE FAZ TODOS OS SERVIÇOS ENVOLVENDO O BANCO DE DADOS E PASSANDO PARA OS CONTROLLERS RETORNAR

    @Autowired
    private FuncionarioRepository repository;
    @Transactional(readOnly = true)
    public List<FuncionarioDTO>findAll(){
        List<Funcionario> list = repository.findAll();
        return list.stream().map(FuncionarioDTO::new).toList(); //SERVIÇO PARA RETORNAR UMA LISTA DE TODOS OS FUNCIONARIOS
    }
    @Transactional(readOnly = true)
    public Funcionario insert(Funcionario funcionario){
        return repository.save(funcionario); //SERVIÇO PARA CADASTRAR NOVO FUNCIONARIO
    }
    @Transactional(readOnly = true)
    public Funcionario update(Long id, Funcionario fun){
        Funcionario funcionario = repository.getReferenceById(id);
        updateData(funcionario,fun);
        return repository.save(funcionario);//SERVIÇO PARA ATUALIZAR OS DADOS DO FUNCIONARIO
    }
    @Transactional(readOnly = true)
    public void updateData(Funcionario fun, Funcionario obj) {
        fun.setCargo(obj.getCargo());
        fun.setSalario(obj.getSalario()); //SERVIÇO PARA ATUALIZAR OS DADOS DO FUNCIONARIO
    }
    @Transactional(readOnly = true)
    public void delete(Long id){
        repository.deleteById(id); //SERVIÇO PARA DELETAR O FUNCIONARIO PELO ID
    }
    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id){
        Funcionario fun = repository.findById(id).get();
        return new FuncionarioDTO(fun); //SERVIÇO PARA RETORNAR O FUNCIONARIO PELO ID
    }
}
