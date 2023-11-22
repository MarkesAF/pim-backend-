package com.marques.dtos;

import com.marques.domain.FolhaPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FolhaPagamentoDTO {
        private Long id;
        private Long funcionarioId;

        private String cargo;
        private Double salario;
        private Double bonus;
        private Double descontos;

        public FolhaPagamentoDTO(FolhaPagamento fp){
            this.id = fp.getId();
            this.funcionarioId = fp.getFuncionario().getId();
            this.cargo = fp.getFuncionario().getCargo();
            this.salario = fp.getSalario();
            this.bonus = fp.getBonus();
            this.descontos = fp.getDescontos();
        }


}
