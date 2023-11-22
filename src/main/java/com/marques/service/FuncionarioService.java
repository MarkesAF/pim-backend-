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

    @Autowired
    private FuncionarioRepository repository;
    @Transactional(readOnly = true)
    public List<FuncionarioDTO>findAll(){
        List<Funcionario> list = repository.findAll();
        return list.stream().map(FuncionarioDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public Funcionario insert(Funcionario funcionario){
        return repository.save(funcionario);
    }
    @Transactional(readOnly = true)
    public Funcionario update(Long id, Funcionario fun){
        Funcionario funcionario = repository.getReferenceById(id);
        updateData(funcionario,fun);
        return repository.save(funcionario);
    }
    @Transactional(readOnly = true)
    public void updateData(Funcionario fun, Funcionario obj) {
        fun.setCargo(obj.getCargo());
        fun.setSalario(obj.getSalario());
    }
    @Transactional(readOnly = true)
    public void delete(Long id){
        repository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public FuncionarioDTO findById(Long id){
        Funcionario fun = repository.findById(id).get();
        return new FuncionarioDTO(fun);
    }
}
