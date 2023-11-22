package com.marques.dtos;

import com.marques.domain.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FuncionarioDTO{

    private Long id;
    private String cargo;
    private String nome ;

    public FuncionarioDTO(Funcionario fun){
        this.id = fun.getId();
        this.cargo = fun.getCargo();
        this.nome = fun.getNome();
    }
}
