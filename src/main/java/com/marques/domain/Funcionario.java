package com.marques.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbfuncionario",schema = "oasis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    //Classe de entidade, que contem os atributos que representam as colunas no banco de dados.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", unique = true, length = 11,nullable = false)
    private String cpf;

    @Column(name = "cargo",nullable = false)
    private String cargo;

    @Column(name = "salario")
    private Double salario;
}
