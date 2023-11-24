package com.marques.dtos;

import com.marques.domain.Funcionario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FuncionarioDTO{

    // OS DTOs SAO CLASSES QUASE IGUAIS AS DE ENTIDADES,
    // POREM NELA ESTA SOMENTE OS ATRIBUTOS QUE VOCE QUEIRA RETORNAR AO INVES DE RETORNAR TODOS

    private Long id;
    private String cargo;
    private String nome ;

    public FuncionarioDTO(Funcionario fun){
        this.id = fun.getId();
        this.cargo = fun.getCargo();
        this.nome = fun.getNome();
    }
}
