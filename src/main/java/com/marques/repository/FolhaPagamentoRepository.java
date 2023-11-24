package com.marques.repository;

import com.marques.domain.FolhaPagamento;
import com.marques.dtos.FolhaPagamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento,Long> {

    //OS REPOSITORIES FAZEM COMUNICAÇÃO COM O BANCO DE DADOS, INCLUINDO AS OPERAÇOES
    //REPOSITORIES SAO INSTANCIADOS NA CAMADA SERVICE, PARA CONSEGUIR FAZER TODOS OS SERVIÇOS PARA O BANCO DE DADOS

    @Query(nativeQuery = true, value = """
            SELECT oasis.tbfolhapagamento.id, oasis.tbfolhapagamento.salario, oasis.tbfolhapagamento.bonus,oasis.tbfolhapagamento.descontos,
             oasis.tbfolhapagamento.funcionario_id
              FROM oasis.tbfolhapagamento
            JOIN oasis.tbfuncionario ON oasis.tbfolhapagamento.funcionario_id = oasis.tbfuncionario.id
            WHERE UPPER(oasis.tbfuncionario.cargo) = UPPER(:cargo)""")
    //QUERY que busca a Folha de Pagamento pelo cargo dos Funcionarios.

    List<FolhaPagamento>findByCargo(@Param("cargo")String cargo);
}

