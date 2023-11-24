package com.marques.controllers;

import com.marques.domain.Funcionario;
import com.marques.dtos.FuncionarioDTO;
import com.marques.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>>findAll(){
        List<FuncionarioDTO> dto = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dto);  //RETORNA UMA LISTA DE TODOS OS FUNCIONARIOS
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO>byId(@PathVariable Long id){
        FuncionarioDTO dto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto); //RETORNA UM FUNCIONARIO PELO ID DELE
    }

    @PostMapping
    public ResponseEntity<Funcionario>insert(@RequestBody Funcionario fun){
        Funcionario obj = service.insert(fun);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj); //INSERE UM NOVO FUNCIONARIO.
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //DELETA O FUNCIONARIO, PASSANDO O ID DELE COMO PARAMETRO.
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario>update(@PathVariable Long id, Funcionario obj){
        Funcionario funcionario = service.update(id,obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario); //ATUALIZA OS DADOS DO FUNCIONARIO, COM EXCEÇÃO DO CPF.
    }
}
