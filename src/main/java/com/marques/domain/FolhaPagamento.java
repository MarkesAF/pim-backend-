package com.marques.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbfolhapagamento",schema = "teste")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FolhaPagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salario_base")
    private Double salario;

    private Double descontos;

    private Double bonus;

    @OneToOne
    @JoinColumn(name = "funcionario_id",referencedColumnName = "id")
    private Funcionario funcionario;
}
