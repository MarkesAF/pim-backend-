package com.marques.controllers;


import com.marques.domain.FolhaPagamento;
import com.marques.dtos.FolhaPagamentoDTO;
import com.marques.service.FolhaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/folha-de-pagamento")
public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoService service;


    @GetMapping
    public ResponseEntity<List<FolhaPagamentoDTO>>findAll(){
        List<FolhaPagamentoDTO> dto = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<FolhaPagamentoDTO>byId(@PathVariable Long id){
        FolhaPagamentoDTO dto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PostMapping
    public ResponseEntity<FolhaPagamento>insert(@RequestBody FolhaPagamento folhaPagamento){
        FolhaPagamento fp = service.insert(folhaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(fp);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping(value = "/by-id/{id}")
    public ResponseEntity<FolhaPagamento>update(@PathVariable Long id, FolhaPagamento folhaPagamento){
        FolhaPagamento fp = service.update(id,folhaPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(fp);
    }

    @GetMapping(value = "/by-cargo/{cargo}")
    public ResponseEntity<List<FolhaPagamentoDTO>>byCargo(@PathVariable String cargo){
        List<FolhaPagamentoDTO>list = service.findByCargo(cargo);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
