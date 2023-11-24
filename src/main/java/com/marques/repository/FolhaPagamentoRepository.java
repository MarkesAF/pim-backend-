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

    @Query(nativeQuery = true, value = """
            SELECT oasis.tbfolhapagamento.id, oasis.tbfolhapagamento.salario, oasis.tbfolhapagamento.bonus,oasis.tbfolhapagamento.descontos,
             oasis.tbfolhapagamento.funcionario_id
              FROM oasis.tbfolhapagamento
            JOIN oasis.tbfuncionario ON oasis.tbfolhapagamento.funcionario_id = oasis.tbfuncionario.id
            WHERE UPPER(oasis.tbfuncionario.cargo) = UPPER(:cargo)""")

    List<FolhaPagamento>findByCargo(@Param("cargo")String cargo);
}

