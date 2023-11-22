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
            SELECT teste.tbfolhapagamento.id, teste.tbfolhapagamento.salario_base, teste.tbfolhapagamento.bonus,teste.tbfolhapagamento.descontos,
             teste.tbfolhapagamento.funcionario_id
              FROM teste.tbfolhapagamento
            JOIN teste.tbfuncionario ON teste.tbfolhapagamento.funcionario_id = teste.tbfuncionario.id
            WHERE UPPER(teste.tbfuncionario.cargo) = UPPER(:cargo)""")

    List<FolhaPagamento>findByCargo(@Param("cargo")String cargo);
}
