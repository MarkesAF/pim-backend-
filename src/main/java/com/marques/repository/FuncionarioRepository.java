package com.marques.repository;

import com.marques.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    //OS REPOSITORIES FAZEM COMUNICAÇÃO COM O BANCO DE DADOS, INCLUINDO AS OPERAÇOES
    //REPOSITORIES SAO INSTANCIADOS NA CAMADA SERVICE, PARA CONSEGUIR FAZER TODOS OS SERVIÇOS PARA O BANCO DE DADOS
}
