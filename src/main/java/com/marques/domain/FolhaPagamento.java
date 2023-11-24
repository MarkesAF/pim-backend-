package com.marques.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbfolhapagamento",schema = "oasis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolhaPagamento {
    //Classe de entidade, que contem os atributos que representam as colunas no banco de dados.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "salario")
    private Double salario;
    private Double descontos;
    private Double bonus;
    @OneToOne
    @JoinColumn(name = "funcionario_id",referencedColumnName = "id")
    private Funcionario funcionario;
}
